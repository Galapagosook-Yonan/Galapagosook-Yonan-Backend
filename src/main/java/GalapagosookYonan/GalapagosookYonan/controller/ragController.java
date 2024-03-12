package GalapagosookYonan.GalapagosookYonan.controller;
import GalapagosookYonan.GalapagosookYonan.dto.gptResponseDto;
import GalapagosookYonan.GalapagosookYonan.dto.messageDto;
import GalapagosookYonan.GalapagosookYonan.dto.queryDto;
import GalapagosookYonan.GalapagosookYonan.dto.ragRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Collections;
import java.util.Objects;

@RestController
@RequestMapping("/rag")
public class ragController { // 클래스 이름의 첫 글자는 대문자여야 합니다.

    @Value("${gpt.api.url}")
    private String apiUrl;

    @Value("${gpt.model}")
    private String model;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    @PostMapping("/query")
    public ResponseEntity<?> query(@RequestBody queryDto queryDto) {
        try {
            ragRequestDto requestDto = new ragRequestDto();
            requestDto.setModel(model); // YAML에서 로드한 모델 이름 사용

            messageDto userMessage = new messageDto("user", queryDto.getPrompt());
            requestDto.setMessages(Collections.singletonList(userMessage)); // messages 설정

            String requestBody = objectMapper.writeValueAsString(requestDto);

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            HttpEntity<String> entity = new HttpEntity<>(requestBody, headers);

            ResponseEntity<gptResponseDto> response = restTemplate.exchange(
                    apiUrl,
                    HttpMethod.POST,
                    entity,
                    gptResponseDto.class
            );

            // 응답에서 choices 리스트의 첫 번째 요소의 message 내용을 추출하여 반환
            if (response.getBody() != null && !response.getBody().getChoices().isEmpty() && response.getBody().getChoices().get(0).getMessage() != null) {
                return ResponseEntity.ok(response.getBody().getChoices().get(0).getMessage().getContent());
            } else {
                return ResponseEntity.badRequest().body("No valid response from GPT service");
            }
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error: " + e.getMessage());
        }
    }

    private String generatePrompt(queryDto queryDto) { // 클래스 이름의 첫 글자는 대문자여야 합니다.
        return queryDto.getText() + "\n\n###\n\n" + queryDto.getPrompt();
    }
}





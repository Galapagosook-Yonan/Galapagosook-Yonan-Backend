package GalapagosookYonan.GalapagosookYonan.controller;
import GalapagosookYonan.GalapagosookYonan.dto.gptRequestDto;
import GalapagosookYonan.GalapagosookYonan.dto.gptResponseDto;
import GalapagosookYonan.GalapagosookYonan.dto.ragRequestDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.ObjectMapper; // Import ObjectMapper
import java.util.Map;
import java.util.Objects;

import java.util.Objects;

@RestController
@RequestMapping("/rag")
public class ragController {

    @Value("${gpt.api.url}")
    private String apiUrl;

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/query")
    //public String query(@RequestBody String text, @RequestBody String prompt) {
    public String query(String text, String prompt) {

        String requestBody = generatePrompt(text, prompt);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        //headers.setBearerAuth(apiKey); // 이 부분은 gptConfig에서 이미 처리하므로 생략 가능

        HttpEntity<String> entity = new HttpEntity<>(requestBody, headers);

        ResponseEntity<gptResponseDto> response = restTemplate.exchange(
                apiUrl,
                HttpMethod.POST,
                entity,
                gptResponseDto.class
        );

        return Objects.requireNonNull(response.getBody()).getChoices().get(0).getMessage().getContent();
    }

    private String generatePrompt(String text, String prompt) {
        return text + "\n\n###\n\n" + prompt;
    }
}


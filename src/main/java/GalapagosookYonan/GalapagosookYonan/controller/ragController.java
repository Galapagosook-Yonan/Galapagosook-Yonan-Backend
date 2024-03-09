package GalapagosookYonan.GalapagosookYonan.controller;
import GalapagosookYonan.GalapagosookYonan.dto.gptRequestDto;
import GalapagosookYonan.GalapagosookYonan.dto.gptResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

@RestController
@RequestMapping("/gpt")
@RequiredArgsConstructor
public class ragController {
    @Value("${gpt.model}")
    private String model;

    @Value("${gpt.api.url}")
    private String apiUrl;
    private final RestTemplate restTemplate;

    @GetMapping("/chat")
    public String chat(@RequestParam("prompt") String prompt){

        gptRequestDto request = new gptRequestDto(
                model,prompt,1,256,1,2,2);

        gptResponseDto gptResponse = restTemplate.postForObject(
                apiUrl
                , request
                , gptResponseDto.class
        );

        return Objects.requireNonNull(gptResponse).getChoices().get(0).getMessage().getContent();
    }

}

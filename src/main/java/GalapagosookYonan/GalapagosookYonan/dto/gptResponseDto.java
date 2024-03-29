package GalapagosookYonan.GalapagosookYonan.dto;

import lombok.NoArgsConstructor;

import java.util.List;

import lombok.*;
//import org.apache.logging.log4j.message.Message;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class gptResponseDto {

    private List<Choice> choices;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Choice {
        //gpt 대화 인덱스 번호
        private int index;
        // 지피티로 부터 받은 메세지
        // 여기서 content는 유저의 prompt가 아닌 gpt로부터 받은 response
        private messageDto message;

    }
}

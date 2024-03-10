package GalapagosookYonan.GalapagosookYonan.dto;

import lombok.Getter;

@Getter
public class queryDto {
    // Getters and Setters
    private String text;
    private String prompt;


    public void setText(String text) {
        this.text = text;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }

}

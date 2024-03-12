package GalapagosookYonan.GalapagosookYonan.dto;

import lombok.Data;
import lombok.Getter;

import java.util.List;

@Data
public class ragRequestDto {
    private String model;
    private List<messageDto> messages;
}
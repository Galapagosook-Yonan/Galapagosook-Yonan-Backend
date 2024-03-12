package GalapagosookYonan.GalapagosookYonan.dto;

import GalapagosookYonan.GalapagosookYonan.entity.FarmEntity;
import GalapagosookYonan.GalapagosookYonan.entity.PlanTerms;
import GalapagosookYonan.GalapagosookYonan.farm.Application;
import GalapagosookYonan.GalapagosookYonan.farm.People;
import GalapagosookYonan.GalapagosookYonan.farm.Type;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PlanTermsDto {
    private String title;
    private String description;
    private String details;
    private String image_url;

    @Builder
    public PlanTermsDto(String title, String description, String details, String image_url) {
        this.title = title;
        this.description = description;
        this.details = details;
        this.image_url = image_url;
    }

    public PlanTerms toEntity() {
        return PlanTerms.builder()
                .title(this.title)
                .description(this.description)
                .details(this.details)
                .image_url(this.image_url)
                .build();
    }
}

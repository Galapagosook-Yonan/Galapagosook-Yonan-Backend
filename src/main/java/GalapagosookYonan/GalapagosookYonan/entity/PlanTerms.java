package GalapagosookYonan.GalapagosookYonan.entity;
import GalapagosookYonan.GalapagosookYonan.farm.Application;
import GalapagosookYonan.GalapagosookYonan.farm.People;
import GalapagosookYonan.GalapagosookYonan.farm.Type;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "plan")
public class PlanTerms {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String title;
    private String description;
    private String details;
    private String image_url;

    @Builder
    public PlanTerms(String title, String description, String details, String image_url) {
        this.title = title;
        this.description = description;
        this.details = details;
        this.image_url = image_url;
    }
}

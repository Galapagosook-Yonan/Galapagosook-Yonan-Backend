package GalapagosookYonan.GalapagosookYonan.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "farm")
public class farmEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer farmId;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private String address;

    @Column(name = "area_all", nullable = false)
    private Integer areaAll;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private People people;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Application application;

    @Column(nullable = false, length = 100)
    private String amenities;

    @Column(nullable = false)
    private Integer phoneNumber;

    @Column(nullable = false)
    private Integer areaSale;

    @Column(nullable = false)
    private Integer cost;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date date;

    @Column(nullable = false, length = 30)
    private String name;

    // Lombok will handle the creation of the builder with the following annotation
    @Builder
    public farmEntity(Integer farmId, String type, String address, Integer areaAll,
                      People people, Application application, String amenities,
                      Integer phoneNumber, Integer areaSale, Integer cost, Date date, String name) {
        this.farmId = farmId;
        this.type = type;
        this.address = address;
        this.areaAll = areaAll;
        this.people = people;
        this.application = application;
        this.amenities = amenities;
        this.phoneNumber = phoneNumber;
        this.areaSale = areaSale;
        this.cost = cost;
        this.date = date;
        this.name = name;
    }

    // Default constructor is needed for JPA
    public farmEntity() {}

    // Enums should be defined accordingly
    public enum People {
        // Enum values here
    }bran

    public enum Application {
        // Enum values here
    }
}

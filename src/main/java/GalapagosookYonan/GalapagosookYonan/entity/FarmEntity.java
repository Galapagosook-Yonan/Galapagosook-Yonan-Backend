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
@Table(name = "farm")
public class FarmEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long farmId;

    @Enumerated(EnumType.STRING)
    private Type type;

    @Column(nullable = false)
    private String address;

    @Column(name = "area_all", nullable = false)
    private Long areaAll;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private People people;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Application application;

    @Column(nullable = false, length = 100)
    private String amenities;

    @Column(nullable = false)
    private String phoneNumber;

    @Column(nullable = false)
    private Long areaSale;

    @Column(nullable = false)
    private Long cost;

    @Column(nullable = false)
    private String date;

    @Column(nullable = false, length = 30)
    private String name;

    // Lombok will handle the creation of the builder with the following annotation
    @Builder
    public FarmEntity(Long farmId, Type type, String address, Long areaAll,
                      People people, Application application, String amenities,
                      String phoneNumber, Long areaSale, Long cost, String date, String name) {
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
}

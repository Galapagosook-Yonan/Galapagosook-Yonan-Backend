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
    @Column(name = "farm_id")
    private Long id;

    @Enumerated(EnumType.STRING)
    private Type type;

    private String address;

    private Long areaAll;

    @Enumerated(EnumType.STRING)
    private People people;

    @Enumerated(EnumType.STRING)
    private Application application;

    private String amenities;

    private String phoneNumber;

    private Long areaSale;

    private Long cost;

    private String date;

    private String name;

    @Builder
    public FarmEntity(Long id, Type type, String address, Long areaAll,
                      People people, Application application, String amenities,
                      String phoneNumber, Long areaSale, Long cost, String date, String name) {
        this.id = id;
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

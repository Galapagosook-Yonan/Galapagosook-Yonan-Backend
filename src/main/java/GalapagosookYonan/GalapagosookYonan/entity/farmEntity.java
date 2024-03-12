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

    @Column(nullable = true)
    private String latitude;

    @Column(nullable = true)
    private String hardness;

    @Column(name = "area_all", nullable = false)
    private Integer areaAll;

    // Changed to String type
    @Column(nullable = false)
    private String people;

    // Changed to String type
    @Column(nullable = false)
    private String application;

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

    @Builder
    public farmEntity(Integer farmId, String type, String address, String latitude, String hardness, Integer areaAll,
                      String people, String application, String amenities,
                      Integer phoneNumber, Integer areaSale, Integer cost, Date date, String name) {
        this.farmId = farmId;
        this.type = type;
        this.address = address;
        this.latitude = latitude;
        this.hardness = hardness;
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

    public farmEntity() {}

}

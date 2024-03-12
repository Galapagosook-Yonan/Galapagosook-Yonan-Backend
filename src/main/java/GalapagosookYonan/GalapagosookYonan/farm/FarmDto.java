package GalapagosookYonan.GalapagosookYonan.farm;

import GalapagosookYonan.GalapagosookYonan.entity.FarmEntity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class FarmDto {
    private String name;
    @Enumerated(EnumType.STRING)
    private Type type;

    @Enumerated(EnumType.STRING)
    private People people;

    private String address;
    private String phone_number;
    private Long area_all;
    private Long area_sale;

    @Enumerated(EnumType.STRING)
    private Application application;

    private Long cost;
    private String amenities;
    private String date;

    @Builder
    public FarmDto(String name, Type type, People people, String address, String phone_number, Long area_all, Long area_sale, Application application, Long cost, String amenities, String date) {
        this.name = name;
        this.type = type;
        this.people = people;
        this.address = address;
        this.phone_number = phone_number;
        this.area_all = area_all;
        this.area_sale = area_sale;
        this.application = application;
        this.cost = cost;
        this.amenities = amenities;
        this.date = date;
    }

    public FarmEntity toEntity() {
        return FarmEntity.builder()
                .name(this.name)
                .type(this.type)
                .people(this.people)
                .address(this.address)
                .phoneNumber(this.phone_number)
                .areaAll(this.area_all)
                .areaSale(this.area_sale)
                .application(this.application)
                .cost(this.cost)
                .amenities(this.amenities)
                .date(this.date)
                .build();
    }
}

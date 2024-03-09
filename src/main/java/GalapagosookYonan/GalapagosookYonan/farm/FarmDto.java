package GalapagosookYonan.GalapagosookYonan.farm;

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

    private String adress;
    private String phone_number;
    private Long area_all;
    private Long area_sale;

    @Enumerated(EnumType.STRING)
    private Application application;

    private Long price;
    private String amenities;
    private String date;

    @Builder
    public FarmDto(String name, Type type, People people, String adress, String phone_number, Long area_all, Long area_sale, Application application, Long price, String amenities, String date) {
        this.name = name;
        this.type = type;
        this.people = people;g
        this.adress = adress;
        this.phone_number = phone_number;
        this.area_all = area_all;
        this.area_sale = area_sale;
        this.application = application;
        this.price = price;
        this.amenities = amenities;
        this.date = date;
    }

//    public Farm toEntity() {
//        return FarmDto.builder()
//                .name(this.name)
//                .type(this.type)
//                .people(this.people)
//                .adress(this.adress)
//                .phone_number(this.phone_number)
//                .area_all(this.area_all)
//                .area_sale(this.area_sale)
//                .application(this.application)
//                .price(this.price)
//                .amenities(this.amenities)
//                .date(this.date)
//                .build();
//    }
}

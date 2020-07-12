package revolt.backend.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ChargerDto {
    Long id;

    String name;

    Integer apm;

    Integer numbOfBat;

    Integer batteryType;

    String color;

    Integer price;

    String description;

    String picture;

    Long countryId;

    Long brandId;

}

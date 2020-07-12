package revolt.backend.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BatteryDto {
    Long id;

    String name;

    Integer type;

    Integer apm;

    Integer price;

    String description;

    String picture;

    Long countryId;

    Long brandId;
}

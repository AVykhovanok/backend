package revolt.backend.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ComplectsDto {
    Long id;

    String name;

    Integer batteryType;

    String color;

    Double diameter;

    Integer price;

    String description;

    String picture;

    String value;

    Long countryId;

    Long brandId;
}

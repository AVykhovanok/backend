package revolt.backend.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ConsumablesDto {
    Long id;

    String name;

    Double diameter;

    Integer price;

    String description;

    String picture;

    String weight;

    Double volume;

    Long countryId;

    Long brandId;
}

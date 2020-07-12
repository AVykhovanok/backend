package revolt.backend.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LiquidDto {
    Long id;

    String name;

    String nic;

    Integer price;

    String description;

    String picture;

    String value;

    Long countryId;

    Long brandId;
}

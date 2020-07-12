package revolt.backend.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RDTADto {
    Long id;

    String name;

    String color;

    Double diameter;

    Integer price;

    String description;

    String picture;

    String typeRefill;

    Double volume;

    Long countryId;

    Long brandId;
}

package revolt.backend.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ComponentsDto {
    Long id;

    String name;

    Integer price;

    String description;

    String nic;

    String picture;

    String value;

    Long countryId;

    Long brandId;
}


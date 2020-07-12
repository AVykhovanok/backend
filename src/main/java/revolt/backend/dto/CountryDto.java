package revolt.backend.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CountryDto {
    Long id;
    String name;
    List<Long> accessoriesIds;
    List<Long> batteryIds;
    List<Long> boxmodIds;
    List<Long> chargerIds;
    List<Long> complectsIds;
    List<Long> componentsIds;
    List<Long> consumablesIds;
    List<Long> liquidIds;
    List<Long> mechmodIds;
    List<Long> rdaIds;
    List<Long> rdtaIds;
    List<Long> rtaIds;
}

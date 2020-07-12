package revolt.backend.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.NullValueCheckStrategy;
import revolt.backend.dto.MechmodDto;
import revolt.backend.entity.Mechmod;

import java.util.List;

@Mapper(componentModel = "spring", uses = {MechmodMapperResolver.class},
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface MechmodMapper {

    @Mappings({
            @Mapping(source = "brand.id", target = "brandId"),
            @Mapping(source = "country.id", target = "countryId")})
    MechmodDto toDto(Mechmod mechmod);

    Mechmod toEntity(MechmodDto mechmodDto);

    List<MechmodDto> toDtoList(List<Mechmod> mechmods);

    List<Mechmod> toEntityList(List<MechmodDto> mechmodDtos);
}
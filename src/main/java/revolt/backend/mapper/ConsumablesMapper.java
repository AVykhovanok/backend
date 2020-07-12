package revolt.backend.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.NullValueCheckStrategy;
import revolt.backend.dto.ConsumablesDto;
import revolt.backend.entity.Consumables;

import java.util.List;

@Mapper(componentModel = "spring", uses = {ConsumablesMapperResolver.class},
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface ConsumablesMapper {

    @Mappings({
            @Mapping(source = "brand.id", target = "brandId"),
            @Mapping(source = "country.id", target = "countryId")})
    ConsumablesDto toDto(Consumables consumables);

    Consumables toEntity(ConsumablesDto consumablesDto);

    List<ConsumablesDto> toDtoList(List<Consumables> consumables);

    List<Consumables> toEntityList(List<ConsumablesDto> consumablesDtos);
}
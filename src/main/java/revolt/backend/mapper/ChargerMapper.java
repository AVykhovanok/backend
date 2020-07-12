package revolt.backend.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.NullValueCheckStrategy;
import revolt.backend.dto.ChargerDto;
import revolt.backend.entity.Charger;

import java.util.List;

@Mapper(componentModel = "spring", uses = {ChargerMapperResolver.class},
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface ChargerMapper {

    @Mappings({
            @Mapping(source = "brand.id", target = "brandId"),
            @Mapping(source = "country.id", target = "countryId")})
    ChargerDto toDto(Charger charger);

    Charger toEntity(ChargerDto chargerDto);

    List<ChargerDto> toDtoList(List<Charger> chargers);

    List<Charger> toEntityList(List<ChargerDto> chargerDtos);
}
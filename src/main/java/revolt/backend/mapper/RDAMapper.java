package revolt.backend.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.NullValueCheckStrategy;
import revolt.backend.dto.RDADto;
import revolt.backend.entity.RDA;

import java.util.List;

@Mapper(componentModel = "spring", uses = {RDAMapperResolver.class},
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface RDAMapper {

    @Mappings({
            @Mapping(source = "brand.id", target = "brandId"),
            @Mapping(source = "country.id", target = "countryId")})
    RDADto toDto(RDA rda);

    RDA toEntity(RDADto rdaDto);

    List<RDADto> toDtoList(List<RDA> rdas);

    List<RDA> toEntityList(List<RDADto> rdaDtos);
}
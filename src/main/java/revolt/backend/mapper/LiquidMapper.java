package revolt.backend.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.NullValueCheckStrategy;
import revolt.backend.dto.LiquidDto;
import revolt.backend.entity.Liquid;

import java.util.List;

@Mapper(componentModel = "spring", uses = {LiquidMapperResolver.class},
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface LiquidMapper {

    @Mappings({
            @Mapping(source = "brand.id", target = "brandId"),
            @Mapping(source = "country.id", target = "countryId")})
    LiquidDto toDto(Liquid liquid);

    Liquid toEntity(LiquidDto liquidDto);

    List<LiquidDto> toDtoList(List<Liquid> liquids);

    List<Liquid> toEntityList(List<LiquidDto> liquidDtos);
}
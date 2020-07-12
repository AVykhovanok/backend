package revolt.backend.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.NullValueCheckStrategy;
import revolt.backend.dto.ComponentsDto;
import revolt.backend.entity.Components;

import java.util.List;

@Mapper(componentModel = "spring", uses = {ComponentsMapperResolver.class},
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface ComponentsMapper {

    @Mappings({
            @Mapping(source = "brand.id", target = "brandId"),
            @Mapping(source = "country.id", target = "countryId")})
    ComponentsDto toDto(Components components);

    Components toEntity(ComponentsDto componentsDto);

    List<ComponentsDto> toDtoList(List<Components> components);

    List<Components> toEntityList(List<ComponentsDto> componentsDtos);
}
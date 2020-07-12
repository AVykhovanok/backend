package revolt.backend.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.NullValueCheckStrategy;
import revolt.backend.dto.AccessoriesDto;
import revolt.backend.entity.Accessories;

import java.util.List;

@Mapper(componentModel = "spring", uses = {AccessoriesMapperResolver.class},
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface AccessoriesMapper {

    @Mappings({
            @Mapping(source = "brand.id", target = "brandId"),
            @Mapping(source = "country.id", target = "countryId")})
    AccessoriesDto toDto(Accessories accessories);

    Accessories toEntity(AccessoriesDto accessoriesDto);

    List<AccessoriesDto> toDtoList(List<Accessories> accessories);

    List<Accessories> toEntityList(List<AccessoriesDto> accessoriesDtos);
}

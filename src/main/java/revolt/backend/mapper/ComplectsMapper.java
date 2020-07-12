package revolt.backend.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.NullValueCheckStrategy;
import revolt.backend.dto.ComplectsDto;
import revolt.backend.entity.Complects;

import java.util.List;

@Mapper(componentModel = "spring", uses = {ComplectsMapperResolver.class},
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface ComplectsMapper {

    @Mappings({
            @Mapping(source = "brand.id", target = "brandId"),
            @Mapping(source = "country.id", target = "countryId")})
    ComplectsDto toDto(Complects complects);

    Complects toEntity(ComplectsDto complectsDto);

    List<ComplectsDto> toDtoList(List<Complects> complects);

    List<Complects> toEntityList(List<ComplectsDto> complectsDtos);
}
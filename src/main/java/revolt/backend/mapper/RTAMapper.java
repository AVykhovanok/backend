package revolt.backend.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.NullValueCheckStrategy;
import revolt.backend.dto.RTADto;
import revolt.backend.entity.RTA;

import java.util.List;

@Mapper(componentModel = "spring", uses = {RTAMapperResolver.class},
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface RTAMapper {

    @Mappings({
            @Mapping(source = "brand.id", target = "brandId"),
            @Mapping(source = "country.id", target = "countryId")})
    RTADto toDto(RTA rta);

    RTA toEntity(RTADto rtaDto);

    List<RTADto> toDtoList(List<RTA> rtas);

    List<RTA> toEntityList(List<RTADto> rtaDtos);
}
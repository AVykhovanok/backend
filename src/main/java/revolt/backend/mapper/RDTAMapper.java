package revolt.backend.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.NullValueCheckStrategy;
import revolt.backend.dto.RDTADto;
import revolt.backend.entity.RDTA;

import java.util.List;

@Mapper(componentModel = "spring", uses = {RDTAMapperResolver.class},
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface RDTAMapper {

    @Mappings({
            @Mapping(source = "brand.id", target = "brandId"),
            @Mapping(source = "country.id", target = "countryId")})
    RDTADto toDto(RDTA rdta);

    RDTA toEntity(RDTADto rdtaDto);

    List<RDTADto> toDtoList(List<RDTA> rdtas);

    List<RDTA> toEntityList(List<RDTADto> rdtaDtos);
}
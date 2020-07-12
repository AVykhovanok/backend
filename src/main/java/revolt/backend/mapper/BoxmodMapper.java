package revolt.backend.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.NullValueCheckStrategy;
import revolt.backend.dto.BoxmodDto;
import revolt.backend.entity.Boxmod;

import java.util.List;

@Mapper(componentModel = "spring", uses = {BoxmodMapperResolver.class},
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface BoxmodMapper {

    @Mappings({
            @Mapping(source = "brand.id", target = "brandId"),
            @Mapping(source = "country.id", target = "countryId")})
    BoxmodDto toDto(Boxmod boxmod);

    Boxmod toEntity(BoxmodDto boxmodDto);

    List<BoxmodDto> toDtoList(List<Boxmod> boxmods);

    List<Boxmod> toEntityList(List<BoxmodDto> boxmodDtos);
}
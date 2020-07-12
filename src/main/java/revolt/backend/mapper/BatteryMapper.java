package revolt.backend.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.NullValueCheckStrategy;
import revolt.backend.dto.BatteryDto;
import revolt.backend.entity.Battery;

import java.util.List;

@Mapper(componentModel = "spring", uses = {BatteryMapperResolver.class},
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface BatteryMapper {

    @Mappings({
            @Mapping(source = "brand.id", target = "brandId"),
            @Mapping(source = "country.id", target = "countryId")})
    BatteryDto toDto(Battery battery);

    Battery toEntity(BatteryDto batteryDto);

    List<BatteryDto> toDtoList(List<Battery> batteries);

    List<Battery> toEntityList(List<BatteryDto> batteryDtos);
}
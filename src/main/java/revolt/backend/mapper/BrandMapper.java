package revolt.backend.mapper;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;
import revolt.backend.dto.BrandDto;
import revolt.backend.entity.*;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", uses = {BrandMapperResolver.class},
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface BrandMapper {

    BrandDto toDto(Brand brand);

    Brand toEntity(BrandDto brandDto);

    List<BrandDto> toDtoList(List<Brand> brandList);

    List<Brand> toEntityList(List<BrandDto> brandDtos);

    @AfterMapping
    default void mapBrandAccessories(@MappingTarget BrandDto brandDto, Brand brand) {
        brandDto.setAccessoriesIds(brand.getAccessories().stream().map(Accessories::getId).collect(Collectors.toList()));
        brandDto.setBatteryIds(brand.getBatteries().stream().map(Battery::getId).collect(Collectors.toList()));
        brandDto.setBoxmodIds(brand.getBoxmods().stream().map(Boxmod::getId).collect(Collectors.toList()));
        brandDto.setChargerIds(brand.getChargers().stream().map(Charger::getId).collect(Collectors.toList()));
        brandDto.setComplectsIds(brand.getComplects().stream().map(Complects::getId).collect(Collectors.toList()));
        brandDto.setComponentsIds(brand.getComponents().stream().map(Components::getId).collect(Collectors.toList()));
        brandDto.setConsumablesIds(brand.getConsumables().stream().map(Consumables::getId).collect(Collectors.toList()));
        brandDto.setLiquidIds(brand.getLiquids().stream().map(Liquid::getId).collect(Collectors.toList()));
        brandDto.setMechmodIds(brand.getMechmods().stream().map(Mechmod::getId).collect(Collectors.toList()));
        brandDto.setRdaIds(brand.getRdas().stream().map(RDA::getId).collect(Collectors.toList()));
        brandDto.setRdtaIds(brand.getRdtas().stream().map(RDTA::getId).collect(Collectors.toList()));
        brandDto.setRtaIds(brand.getRtas().stream().map(RTA::getId).collect(Collectors.toList()));
    }
}

package revolt.backend.mapper;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;
import revolt.backend.dto.CountryDto;
import revolt.backend.entity.*;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", uses = {CountryMapperResolver.class},
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface CountryMapper {

    CountryDto toDto(Country country);

    Country toEntity(CountryDto countryDto);

    List<CountryDto> toDtoList(List<Country> countries);

    List<Country> toEntityList(List<CountryDto> countryDtos);

    @AfterMapping
    default void mapCountryDto(@MappingTarget CountryDto countryDto, Country country) {
        countryDto.setAccessoriesIds(country.getAccessories().stream().map(Accessories::getId).collect(Collectors.toList()));
        countryDto.setBatteryIds(country.getBatteries().stream().map(Battery::getId).collect(Collectors.toList()));
        countryDto.setBoxmodIds(country.getBoxmods().stream().map(Boxmod::getId).collect(Collectors.toList()));
        countryDto.setChargerIds(country.getChargers().stream().map(Charger::getId).collect(Collectors.toList()));
        countryDto.setComplectsIds(country.getComplects().stream().map(Complects::getId).collect(Collectors.toList()));
        countryDto.setComponentsIds(country.getComponents().stream().map(Components::getId).collect(Collectors.toList()));
        countryDto.setConsumablesIds(country.getConsumables().stream().map(Consumables::getId).collect(Collectors.toList()));
        countryDto.setLiquidIds(country.getLiquids().stream().map(Liquid::getId).collect(Collectors.toList()));
        countryDto.setMechmodIds(country.getMechmods().stream().map(Mechmod::getId).collect(Collectors.toList()));
        countryDto.setRdaIds(country.getRdas().stream().map(RDA::getId).collect(Collectors.toList()));
        countryDto.setRdtaIds(country.getRdtas().stream().map(RDTA::getId).collect(Collectors.toList()));
        countryDto.setRtaIds(country.getRtas().stream().map(RTA::getId).collect(Collectors.toList()));
    }
}
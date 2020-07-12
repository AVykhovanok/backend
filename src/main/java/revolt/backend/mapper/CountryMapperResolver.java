package revolt.backend.mapper;

import lombok.AllArgsConstructor;
import org.mapstruct.ObjectFactory;
import org.springframework.stereotype.Component;
import revolt.backend.dto.CountryDto;
import revolt.backend.entity.Country;
import revolt.backend.service.*;

import java.util.Objects;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class CountryMapperResolver {

    final AccessoriesMapper accessoriesMapper;
    final BatteryMapper batteryMapper;
    final BoxmodMapper boxmodMapper;
    final ChargerMapper chargerMapper;
    final ComplectsMapper complectsMapper;
    final ComponentsMapper componentsMapper;
    final ConsumablesMapper consumablesMapper;
    final LiquidMapper liquidMapper;
    final MechmodMapper mechmodMapper;
    final RDAMapper rdaMapper;
    final RDTAMapper rdtaMapper;
    final RTAMapper rtaMapper;

    final AccessoriesService accessoriesService;
    final BatteryService batteryService;
    final BoxmodService boxmodService;
    final ChargerService chargerService;
    final ComplectsService complectsService;
    final ComponentsService componentsService;
    final ConsumablesService consumablesService;
    final LiquidService liquidService;
    final MechmodService mechmodService;
    final RDAService rdaService;
    final RDTAService rdtaService;
    final RTAService rtaService;

    @ObjectFactory
    Country resolve(CountryDto countryDto) {
        Country country = new Country();
        if (Objects.nonNull(countryDto) && Objects.nonNull(countryDto.getAccessoriesIds())) {
            country.setAccessories(countryDto.getAccessoriesIds().stream()
                    .map(accessoriesService::getAccessories)
                    .map(accessoriesMapper::toEntity)
                    .collect(Collectors.toList()));
        }
        if (Objects.nonNull(countryDto) && Objects.nonNull(countryDto.getBatteryIds())) {
            country.setBatteries(countryDto.getBatteryIds().stream()
                    .map(batteryService::getBattery)
                    .map(batteryMapper::toEntity)
                    .collect(Collectors.toList()));
        }
        if (Objects.nonNull(countryDto) && Objects.nonNull(countryDto.getBoxmodIds())) {
            country.setBoxmods(countryDto.getBoxmodIds().stream()
                    .map(boxmodService::getBoxmod)
                    .map(boxmodMapper::toEntity)
                    .collect(Collectors.toList()));
        }
        if (Objects.nonNull(countryDto) && Objects.nonNull(countryDto.getChargerIds())) {
            country.setChargers(countryDto.getChargerIds().stream()
                    .map(chargerService::getCharger)
                    .map(chargerMapper::toEntity)
                    .collect(Collectors.toList()));
        }
        if (Objects.nonNull(countryDto) && Objects.nonNull(countryDto.getComplectsIds())) {
            country.setComplects(countryDto.getComplectsIds().stream()
                    .map(complectsService::getComplects)
                    .map(complectsMapper::toEntity)
                    .collect(Collectors.toList()));
        }
        if (Objects.nonNull(countryDto) && Objects.nonNull(countryDto.getComponentsIds())) {
            country.setComponents(countryDto.getComponentsIds().stream()
                    .map(componentsService::getComponents)
                    .map(componentsMapper::toEntity)
                    .collect(Collectors.toList()));
        }
        if (Objects.nonNull(countryDto) && Objects.nonNull(countryDto.getConsumablesIds())) {
            country.setConsumables(countryDto.getConsumablesIds().stream()
                    .map(consumablesService::getConsumables)
                    .map(consumablesMapper::toEntity)
                    .collect(Collectors.toList()));
        }
        if (Objects.nonNull(countryDto) && Objects.nonNull(countryDto.getLiquidIds())) {
            country.setLiquids(countryDto.getLiquidIds().stream()
                    .map(liquidService::getLiquid)
                    .map(liquidMapper::toEntity)
                    .collect(Collectors.toList()));
        }
        if (Objects.nonNull(countryDto) && Objects.nonNull(countryDto.getMechmodIds())) {
            country.setMechmods(countryDto.getMechmodIds().stream()
                    .map(mechmodService::getMechmod)
                    .map(mechmodMapper::toEntity)
                    .collect(Collectors.toList()));
        }
        if (Objects.nonNull(countryDto) && Objects.nonNull(countryDto.getRdaIds())) {
            country.setRdas(countryDto.getRdaIds().stream()
                    .map(rdaService::getRDA)
                    .map(rdaMapper::toEntity)
                    .collect(Collectors.toList()));
        }
        if (Objects.nonNull(countryDto) && Objects.nonNull(countryDto.getRdtaIds())) {
            country.setRdtas(countryDto.getRdtaIds().stream()
                    .map(rdtaService::getRDTA)
                    .map(rdtaMapper::toEntity)
                    .collect(Collectors.toList()));
        }
        if (Objects.nonNull(countryDto) && Objects.nonNull(countryDto.getRtaIds())) {
            country.setRtas(countryDto.getRtaIds().stream()
                    .map(rtaService::getRTA)
                    .map(rtaMapper::toEntity)
                    .collect(Collectors.toList()));
        }
        return country;
    }
}
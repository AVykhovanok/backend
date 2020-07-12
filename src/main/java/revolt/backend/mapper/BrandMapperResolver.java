package revolt.backend.mapper;

import lombok.AllArgsConstructor;
import org.mapstruct.ObjectFactory;
import org.springframework.stereotype.Component;
import revolt.backend.dto.AccessoriesDto;
import revolt.backend.dto.BrandDto;
import revolt.backend.entity.Accessories;
import revolt.backend.entity.Brand;
import revolt.backend.service.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class BrandMapperResolver {

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
    Brand resolve(BrandDto brandDto) {
        Brand brand = new Brand();
        if (Objects.nonNull(brandDto) && Objects.nonNull(brandDto.getAccessoriesIds())) {
            List<Accessories> list = brandDto.getAccessoriesIds().stream()
                    .map(accessoriesService::getAccessories)
                    .map(accessoriesMapper::toEntity)
                    .collect(Collectors.toList());
            brand.setAccessories(list);
        }
        if (Objects.nonNull(brandDto) && Objects.nonNull(brandDto.getBatteryIds())) {
            brand.setBatteries(brandDto.getBatteryIds().stream()
                    .map(batteryService::getBattery)
                    .map(batteryMapper::toEntity)
                    .collect(Collectors.toList()));
        }
        if (Objects.nonNull(brandDto) && Objects.nonNull(brandDto.getBoxmodIds())) {
            brand.setBoxmods(brandDto.getBoxmodIds().stream()
                    .map(boxmodService::getBoxmod)
                    .map(boxmodMapper::toEntity)
                    .collect(Collectors.toList()));
        }
        if (Objects.nonNull(brandDto) && Objects.nonNull(brandDto.getChargerIds())) {
            brand.setChargers(brandDto.getChargerIds().stream()
                    .map(chargerService::getCharger)
                    .map(chargerMapper::toEntity)
                    .collect(Collectors.toList()));
        }
        if (Objects.nonNull(brandDto) && Objects.nonNull(brandDto.getComplectsIds())) {
            brand.setComplects(brandDto.getComplectsIds().stream()
                    .map(complectsService::getComplects)
                    .map(complectsMapper::toEntity)
                    .collect(Collectors.toList()));
        }
        if (Objects.nonNull(brandDto) && Objects.nonNull(brandDto.getComponentsIds())) {
            brand.setComponents(brandDto.getComponentsIds().stream()
                    .map(componentsService::getComponents)
                    .map(componentsMapper::toEntity)
                    .collect(Collectors.toList()));
        }
        if (Objects.nonNull(brandDto) && Objects.nonNull(brandDto.getConsumablesIds())) {
            brand.setConsumables(brandDto.getConsumablesIds().stream()
                    .map(consumablesService::getConsumables)
                    .map(consumablesMapper::toEntity)
                    .collect(Collectors.toList()));
        }
        if (Objects.nonNull(brandDto) && Objects.nonNull(brandDto.getLiquidIds())) {
            brand.setLiquids(brandDto.getLiquidIds().stream()
                    .map(liquidService::getLiquid)
                    .map(liquidMapper::toEntity)
                    .collect(Collectors.toList()));
        }
        if (Objects.nonNull(brandDto) && Objects.nonNull(brandDto.getMechmodIds())) {
            brand.setMechmods(brandDto.getMechmodIds().stream()
                    .map(mechmodService::getMechmod)
                    .map(mechmodMapper::toEntity)
                    .collect(Collectors.toList()));
        }
        if (Objects.nonNull(brandDto) && Objects.nonNull(brandDto.getRdaIds())) {
            brand.setRdas(brandDto.getRdaIds().stream()
                    .map(rdaService::getRDA)
                    .map(rdaMapper::toEntity)
                    .collect(Collectors.toList()));
        }
        if (Objects.nonNull(brandDto) && Objects.nonNull(brandDto.getRdtaIds())) {
            brand.setRdtas(brandDto.getRdtaIds().stream()
                    .map(rdtaService::getRDTA)
                    .map(rdtaMapper::toEntity)
                    .collect(Collectors.toList()));
        }
        if (Objects.nonNull(brandDto) && Objects.nonNull(brandDto.getRtaIds())) {
            brand.setRtas(brandDto.getRtaIds().stream()
                    .map(rtaService::getRTA)
                    .map(rtaMapper::toEntity)
                    .collect(Collectors.toList()));
        }
        return brand;
    }
}

package revolt.backend.service.serviceImpl;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import revolt.backend.dto.BatteryDto;
import revolt.backend.entity.Battery;
import revolt.backend.mapper.BatteryMapper;
import revolt.backend.repository.BatteryRepository;
import revolt.backend.service.BatteryService;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BatteryServiceImpl implements BatteryService {

    final BatteryRepository batteryRepository;
    final BatteryMapper batteryMapper;

    @Override
    public List<BatteryDto> getAllBatteries() {
        return batteryMapper.toDtoList(batteryRepository.findAll()).stream()
                .sorted(Comparator.comparing(BatteryDto::getName))
                .collect(Collectors.toList());
    }

    @Override
    public BatteryDto createBattery(BatteryDto batteryDto) {
        return batteryMapper.toDto(batteryRepository.save(batteryMapper.toEntity(batteryDto)));
    }

    @Override
    public BatteryDto getBattery(Long id) {
        return batteryMapper.toDto(batteryRepository.getOne(id));
    }

    @Override
    public BatteryDto updateBattery(BatteryDto batteryDto, Long batteryId) {
        batteryDto.setId(batteryId);
        return  batteryMapper.toDto(batteryRepository.save(batteryMapper.toEntity(batteryDto)));
    }

    @Override
    public void deleteBattery(Long id) {
        batteryRepository.deleteById(id);
    }
}

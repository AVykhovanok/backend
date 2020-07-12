package revolt.backend.service.serviceImpl;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import revolt.backend.dto.ConsumablesDto;
import revolt.backend.entity.Consumables;
import revolt.backend.mapper.ConsumablesMapper;
import revolt.backend.repository.ConsumablesRepository;
import revolt.backend.service.ConsumablesService;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ConsumablesServiceImpl implements ConsumablesService {

    final ConsumablesRepository consumablesRepository;
    final ConsumablesMapper consumablesMapper;

    @Override
    public List<ConsumablesDto> getConsumabless() {
        return consumablesMapper.toDtoList(consumablesRepository.findAll()).stream()
                .sorted(Comparator.comparing(ConsumablesDto::getName))
                .collect(Collectors.toList());
    }

    @Override
    public ConsumablesDto createConsumables(ConsumablesDto consumablesDto) {
        return consumablesMapper.toDto(
                consumablesRepository.save(consumablesMapper.toEntity(consumablesDto)));
    }

    @Override
    public ConsumablesDto getConsumables(Long id) {
        return consumablesMapper.toDto(consumablesRepository.getOne(id));
    }

    @Override
    public ConsumablesDto updateConsumables(ConsumablesDto consumablesDto, Long consumablesId) {
        consumablesDto.setId(consumablesId);
        return consumablesMapper.toDto(
                consumablesRepository.save(consumablesMapper.toEntity(consumablesDto)));
    }

    @Override
    public void deleteConsumables(Long id) {
        consumablesRepository.deleteById(id);
    }
}

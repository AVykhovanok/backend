package revolt.backend.service.serviceImpl;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import revolt.backend.dto.ChargerDto;
import revolt.backend.entity.Charger;
import revolt.backend.mapper.ChargerMapper;
import revolt.backend.repository.ChargerRepository;
import revolt.backend.service.ChargerService;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ChargerServiceImpl implements ChargerService {

    final ChargerRepository chargerRepository;
    final ChargerMapper chargerMapper;

    @Override
    public List<ChargerDto> getChargers() {
        return chargerMapper.toDtoList(chargerRepository.findAll()).stream()
                .sorted(Comparator.comparing(ChargerDto::getName))
                .collect(Collectors.toList());
    }

    @Override
    public ChargerDto createCharger(ChargerDto chargerDto) {
        return chargerMapper.toDto(chargerRepository.save(chargerMapper.toEntity(chargerDto)));
    }

    @Override
    public ChargerDto getCharger(Long id) {
        return chargerMapper.toDto(chargerRepository.getOne(id));
    }

    @Override
    public ChargerDto updateCharger(ChargerDto chargerDto, Long chargerId) {
        chargerDto.setId(chargerId);
        return chargerMapper.toDto(chargerRepository.save(chargerMapper.toEntity(chargerDto)));
    }

    @Override
    public void deleteCharger(Long id) {
        chargerRepository.deleteById(id);
    }
}

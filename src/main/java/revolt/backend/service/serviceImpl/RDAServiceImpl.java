package revolt.backend.service.serviceImpl;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import revolt.backend.dto.RDADto;
import revolt.backend.entity.RDA;
import revolt.backend.mapper.RDAMapper;
import revolt.backend.repository.RDARepository;
import revolt.backend.service.RDAService;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RDAServiceImpl implements RDAService {

    final RDARepository rdaRepository;
    final RDAMapper rdaMapper;

    @Override
    public List<RDADto> getRDAs() {
        return rdaMapper.toDtoList(rdaRepository.findAll()).stream()
                .sorted(Comparator.comparing(RDADto::getName))
                .collect(Collectors.toList());
    }

    @Override
    public RDADto createRDA(RDADto rdaDto) {
        return rdaMapper.toDto(rdaRepository.save(rdaMapper.toEntity(rdaDto)));
    }

    @Override
    public RDADto getRDA(Long id) {
        return rdaMapper.toDto(rdaRepository.getOne(id));
    }

    @Override
    public RDADto updateRDA(RDADto rdaDto, Long rdaId) {
        rdaDto.setId(rdaId);
        return rdaMapper.toDto(rdaRepository.save(rdaMapper.toEntity(rdaDto)));
    }

    @Override
    public void deleteRDA(Long id) {
        rdaRepository.deleteById(id);
    }
}

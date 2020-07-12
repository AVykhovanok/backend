package revolt.backend.service.serviceImpl;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import revolt.backend.dto.RDTADto;
import revolt.backend.entity.RDTA;
import revolt.backend.mapper.RDTAMapper;
import revolt.backend.repository.RDTARepository;
import revolt.backend.service.RDTAService;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RDTAServiceImpl implements RDTAService {

    final RDTARepository rdtaRepository;
    final RDTAMapper rdtaMapper;

    @Override
    public List<RDTADto> getRDTAs() {
        return rdtaMapper.toDtoList(rdtaRepository.findAll()).stream()
                .sorted(Comparator.comparing(RDTADto::getName))
                .collect(Collectors.toList());
    }

    @Override
    public RDTADto createRDTA(RDTADto rdtaDto) {
        return rdtaMapper.toDto(rdtaRepository.save(rdtaMapper.toEntity(rdtaDto)));
    }

    @Override
    public RDTADto getRDTA(Long id) {
        return rdtaMapper.toDto(rdtaRepository.getOne(id));
    }

    @Override
    public RDTADto updateRDTA(RDTADto rdtaDto, Long rdtaId) {
        rdtaDto.setId(rdtaId);
        return rdtaMapper.toDto(rdtaRepository.save(rdtaMapper.toEntity(rdtaDto)));
    }

    @Override
    public void deleteRDTA(Long id) {
        rdtaRepository.deleteById(id);
    }
}

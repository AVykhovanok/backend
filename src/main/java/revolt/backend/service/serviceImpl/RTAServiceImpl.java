package revolt.backend.service.serviceImpl;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import revolt.backend.dto.RTADto;
import revolt.backend.entity.RTA;
import revolt.backend.mapper.RTAMapper;
import revolt.backend.repository.RTARepository;
import revolt.backend.service.RTAService;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RTAServiceImpl implements RTAService {

    final RTARepository rtaRepository;
    final RTAMapper rtaMapper;

    @Override
    public List<RTADto> getRTAs() {
        return rtaMapper.toDtoList(rtaRepository.findAll()).stream()
                .sorted(Comparator.comparing(RTADto::getName))
                .collect(Collectors.toList());
    }

    @Override
    public RTADto createRTA(RTADto rtaDto) {
        return rtaMapper.toDto(rtaRepository.save(rtaMapper.toEntity(rtaDto)));
    }

    @Override
    public RTADto getRTA(Long id) {
        return rtaMapper.toDto(rtaRepository.getOne(id));
    }

    @Override
    public RTADto updateRTA(RTADto rtaDto, Long rtaId) {
        rtaDto.setId(rtaId);
        return rtaMapper.toDto(rtaRepository.save(rtaMapper.toEntity(rtaDto)));
    }

    @Override
    public void deleteRTA(Long id) {
        rtaRepository.deleteById(id);
    }
}

package revolt.backend.service.serviceImpl;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import revolt.backend.dto.ComplectsDto;
import revolt.backend.entity.Complects;
import revolt.backend.mapper.ComplectsMapper;
import revolt.backend.repository.ComplectsRepository;
import revolt.backend.service.ComplectsService;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ComplectsServiceImpl implements ComplectsService {

    final ComplectsRepository complectsRepository;
    final ComplectsMapper complectsMapper;

    @Override
    public List<ComplectsDto> getComplectss() {
        return complectsMapper.toDtoList(complectsRepository.findAll()).stream()
                .sorted(Comparator.comparing(ComplectsDto::getName))
                .collect(Collectors.toList());
    }

    @Override
    public ComplectsDto createComplects(ComplectsDto complectsDto){
        return complectsMapper.toDto(complectsRepository.save(complectsMapper.toEntity(complectsDto)));
    }

    @Override
    public ComplectsDto getComplects(Long id) {
        return complectsMapper.toDto(complectsRepository.getOne(id));
    }

    @Override
    public ComplectsDto updateComplects(ComplectsDto complectsDto, Long complectsId) {
        complectsDto.setId(complectsId);
        return complectsMapper.toDto(complectsRepository.save(complectsMapper.toEntity(complectsDto)));
    }

    @Override
    public void deleteComplects(Long id) {
        complectsRepository.deleteById(id);
    }
}

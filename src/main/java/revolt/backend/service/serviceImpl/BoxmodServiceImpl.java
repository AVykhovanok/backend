package revolt.backend.service.serviceImpl;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import revolt.backend.dto.BoxmodDto;
import revolt.backend.entity.Boxmod;
import revolt.backend.mapper.BoxmodMapper;
import revolt.backend.repository.BoxmodRepository;
import revolt.backend.service.BoxmodService;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BoxmodServiceImpl implements BoxmodService {

    final BoxmodRepository boxmodRepository;
    final BoxmodMapper boxmodMapper;

    @Override
    public List<BoxmodDto> getBoxmods() {
        return boxmodMapper.toDtoList(boxmodRepository.findAll()).stream()
                .sorted(Comparator.comparing(BoxmodDto::getName))
                .collect(Collectors.toList());
    }

    @Override
    public BoxmodDto createBoxmod(BoxmodDto boxmodDto) {
        return boxmodMapper.toDto(boxmodRepository.save(boxmodMapper.toEntity(boxmodDto)));
    }

    @Override
    public BoxmodDto getBoxmod(Long id) {
        return boxmodMapper.toDto(boxmodRepository.getOne(id));
    }

    @Override
    public BoxmodDto updateBoxmod(BoxmodDto boxmodDto, Long boxmodId) {
        boxmodDto.setId(boxmodId);
        return boxmodMapper.toDto(boxmodRepository.save(boxmodMapper.toEntity(boxmodDto)));
    }

    @Override
    public void deleteBoxmod(Long id) {
        boxmodRepository.deleteById(id);
    }
}

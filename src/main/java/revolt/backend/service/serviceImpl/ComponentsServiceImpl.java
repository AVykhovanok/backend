package revolt.backend.service.serviceImpl;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import revolt.backend.dto.ComponentsDto;
import revolt.backend.entity.Components;
import revolt.backend.mapper.ComponentsMapper;
import revolt.backend.repository.ComponentsRepository;
import revolt.backend.service.ComponentsService;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ComponentsServiceImpl implements ComponentsService {

    final ComponentsRepository componentsRepository;
    final ComponentsMapper componentsMapper;

    @Override
    public List<ComponentsDto> getAllComponents() {
        return componentsMapper.toDtoList(componentsRepository.findAll()).stream()
                .sorted(Comparator.comparing(ComponentsDto::getName))
                .collect(Collectors.toList());
    }

    @Override
    public ComponentsDto createComponents(ComponentsDto componentsDto) {
        return componentsMapper.toDto(
                componentsRepository.save(componentsMapper.toEntity(componentsDto)));
    }

    @Override
    public ComponentsDto getComponents(Long id) {
        return componentsMapper.toDto(componentsRepository.getOne(id));
    }

    @Override
    public ComponentsDto updateComponents(ComponentsDto componentsDto, Long componentsId) {
        componentsDto.setId(componentsId);
        return componentsMapper.toDto(
                componentsRepository.save(componentsMapper.toEntity(componentsDto)));
    }

    @Override
    public void deleteComponents(Long id) {
        componentsRepository.deleteById(id);
    }
}

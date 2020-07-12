package revolt.backend.service;

import revolt.backend.dto.ComponentsDto;
import revolt.backend.entity.Components;

import java.util.List;

public interface ComponentsService {

    List<ComponentsDto> getAllComponents();

    ComponentsDto createComponents(ComponentsDto componentsDto);

    ComponentsDto getComponents(Long id);

    ComponentsDto updateComponents(ComponentsDto componentsDto, Long componentsId);

    void deleteComponents(Long id);
}

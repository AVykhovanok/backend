package revolt.backend.service;

import revolt.backend.dto.BoxmodDto;
import revolt.backend.entity.Boxmod;

import java.util.List;

public interface BoxmodService {

    List<BoxmodDto> getBoxmods();

    BoxmodDto createBoxmod(BoxmodDto boxmodDto);

    BoxmodDto getBoxmod(Long id);

    BoxmodDto updateBoxmod(BoxmodDto boxmodDto, Long boxmodId);

    void deleteBoxmod(Long id);

}

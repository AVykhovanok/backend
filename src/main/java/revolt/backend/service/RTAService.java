package revolt.backend.service;

import revolt.backend.dto.RTADto;

import java.util.List;

public interface RTAService {

    List<RTADto> getRTAs();

    RTADto createRTA(RTADto rtaDto);

    RTADto getRTA(Long id);

    RTADto updateRTA(RTADto rtaDto, Long rtaId);

    void deleteRTA(Long id);
}

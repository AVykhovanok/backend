package revolt.backend.service;

import revolt.backend.dto.RDADto;

import java.util.List;

public interface RDAService {

    List<RDADto> getRDAs();

    RDADto createRDA(RDADto rdaDto);

    RDADto getRDA(Long id);

    RDADto updateRDA(RDADto rdaDto, Long rdaId);

    void deleteRDA(Long id);
}
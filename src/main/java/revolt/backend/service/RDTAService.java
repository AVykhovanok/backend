package revolt.backend.service;

import revolt.backend.dto.RDTADto;

import java.util.List;

public interface RDTAService {

    List<RDTADto> getRDTAs();

    RDTADto createRDTA(RDTADto rdtaDto);

    RDTADto getRDTA(Long id);

    RDTADto updateRDTA(RDTADto rdtaDto, Long rdtaId);

    void deleteRDTA(Long id);
}
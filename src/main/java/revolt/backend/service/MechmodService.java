package revolt.backend.service;

import revolt.backend.dto.MechmodDto;

import java.util.List;

public interface MechmodService {

    List<MechmodDto> getMechmods();

    MechmodDto createMechmod(MechmodDto mechmodDto);

    MechmodDto getMechmod(Long id);

    MechmodDto updateMechmod(MechmodDto mechmodDto, Long mechmodId);

    void deleteMechmod(Long id);
}

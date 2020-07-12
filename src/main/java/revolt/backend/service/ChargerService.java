package revolt.backend.service;

import revolt.backend.dto.ChargerDto;
import revolt.backend.entity.Charger;

import java.util.List;

public interface ChargerService {

    List<ChargerDto> getChargers();

    ChargerDto createCharger(ChargerDto chargerDto);

    ChargerDto getCharger(Long id);

    ChargerDto updateCharger(ChargerDto chargerDto, Long chargerId);

    void deleteCharger(Long id);
}

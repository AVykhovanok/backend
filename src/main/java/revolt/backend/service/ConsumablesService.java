package revolt.backend.service;

import revolt.backend.dto.ConsumablesDto;

import java.util.List;

public interface ConsumablesService {

    List<ConsumablesDto> getConsumabless();

    ConsumablesDto createConsumables(ConsumablesDto consumablesDto);

    ConsumablesDto getConsumables(Long id);

    ConsumablesDto updateConsumables(ConsumablesDto consumablesDto, Long consumablesId);

    void deleteConsumables(Long id);
}

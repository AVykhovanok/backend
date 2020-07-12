package revolt.backend.service;

import revolt.backend.dto.LiquidDto;

import java.util.List;

public interface LiquidService {

    List<LiquidDto> getLiquids();

    LiquidDto createLiquid(LiquidDto liquidDto);

    LiquidDto getLiquid(Long id);

    LiquidDto updateLiquid(LiquidDto liquidDto, Long liquidId);

    void deleteLiquid(Long id);
}

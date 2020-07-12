package revolt.backend.service.serviceImpl;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import revolt.backend.dto.LiquidDto;
import revolt.backend.entity.Liquid;
import revolt.backend.mapper.LiquidMapper;
import revolt.backend.repository.LiquidRepository;
import revolt.backend.service.LiquidService;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LiquidServiceImpl implements LiquidService {

    final LiquidRepository liquidRepository;
    final LiquidMapper liquidMapper;

    @Override
    public List<LiquidDto> getLiquids() {
        return liquidMapper.toDtoList(liquidRepository.findAll()).stream()
                .sorted(Comparator.comparing(LiquidDto::getName))
                .collect(Collectors.toList());
    }

    @Override
    public LiquidDto createLiquid(LiquidDto liquidDto) {
        return liquidMapper.toDto(liquidRepository.save(liquidMapper.toEntity(liquidDto)));
    }

    @Override
    public LiquidDto getLiquid(Long id) {
        return liquidMapper.toDto(liquidRepository.getOne(id));
    }

    @Override
    public LiquidDto updateLiquid(LiquidDto liquidDto, Long liquidId) {
        liquidDto.setId(liquidId);
        return liquidMapper.toDto(liquidRepository.save(liquidMapper.toEntity(liquidDto)));
    }

    @Override
    public void deleteLiquid(Long id) {
        liquidRepository.deleteById(id);
    }
}

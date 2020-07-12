package revolt.backend.service.serviceImpl;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import revolt.backend.dto.MechmodDto;
import revolt.backend.entity.Mechmod;
import revolt.backend.mapper.MechmodMapper;
import revolt.backend.repository.MechmodRepository;
import revolt.backend.service.MechmodService;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MechmodServiceImpl implements MechmodService {

    final MechmodRepository mechmodRepository;
    final MechmodMapper mechmodMapper;

    @Override
    public List<MechmodDto> getMechmods() {
        return mechmodMapper.toDtoList(mechmodRepository.findAll()).stream()
                .sorted(Comparator.comparing(MechmodDto::getName))
                .collect(Collectors.toList());
    }

    @Override
    public MechmodDto createMechmod(MechmodDto mechmodDto) {
        return mechmodMapper.toDto(mechmodRepository.save(mechmodMapper.toEntity(mechmodDto)));
    }

    @Override
    public MechmodDto getMechmod(Long id) {
        return mechmodMapper.toDto(mechmodRepository.getOne(id));
    }

    @Override
    public MechmodDto updateMechmod(MechmodDto mechmodDto, Long mechmodId) {
        mechmodDto.setId(mechmodId);
        return mechmodMapper.toDto(mechmodRepository.save(mechmodMapper.toEntity(mechmodDto)));
    }

    @Override
    public void deleteMechmod(Long id) {
        mechmodRepository.deleteById(id);
    }
}

package revolt.backend.service.serviceImpl;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import revolt.backend.dto.AccessoriesDto;
import revolt.backend.entity.Accessories;
import revolt.backend.mapper.AccessoriesMapper;
import revolt.backend.repository.AccessoriesRepository;
import revolt.backend.service.AccessoriesService;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AccessoriesServiceImpl implements AccessoriesService {

    final AccessoriesRepository accessoriesRepository;
    final AccessoriesMapper accessoriesMapper;

    @Override
    public List<AccessoriesDto> getAllAccessories() {
        return accessoriesMapper.toDtoList(accessoriesRepository.findAll()).stream()
                .sorted(Comparator.comparing(AccessoriesDto::getName))
                .collect(Collectors.toList());
    }

    @Override
    public AccessoriesDto createAccessories(AccessoriesDto accessoriesDto) {
        return accessoriesMapper.toDto(
                accessoriesRepository.save(accessoriesMapper.toEntity(accessoriesDto)));
    }

    @Override
    public AccessoriesDto getAccessories(Long id) {
        return accessoriesMapper.toDto(accessoriesRepository.getOne(id));
    }

    @Override
    public AccessoriesDto updateAccessories(AccessoriesDto accessoriesDto, Long accessoriesId) {
        accessoriesDto.setId(accessoriesId);
        return accessoriesMapper.toDto(
                accessoriesRepository.save(accessoriesMapper.toEntity(accessoriesDto)));
    }

    @Override
    public void deleteAccessories(Long id) {
        accessoriesRepository.deleteById(id);
    }
}
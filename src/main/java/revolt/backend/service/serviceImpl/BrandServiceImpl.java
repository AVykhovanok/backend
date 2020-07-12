package revolt.backend.service.serviceImpl;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import revolt.backend.dto.BrandDto;
import revolt.backend.entity.Brand;
import revolt.backend.mapper.BrandMapper;
import revolt.backend.repository.BrandRepository;
import revolt.backend.service.BrandService;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BrandServiceImpl implements BrandService {

    final BrandRepository brandRepository;
    final BrandMapper brandMapper;

    @Override
    public List<BrandDto> getBrands() {
        return brandMapper.toDtoList(brandRepository.findAll()).stream()
                .sorted(Comparator.comparing(BrandDto::getName))
                .collect(Collectors.toList());
    }

    @Override
    public BrandDto createBrand(BrandDto brandDto) {
        return brandMapper.toDto(brandRepository.save(brandMapper.toEntity(brandDto)));
    }

    @Override
    public BrandDto getBrand(Long id) {
        return brandMapper.toDto(brandRepository.getOne(id));
    }

    @Override
    public BrandDto updateBrand(BrandDto brandDto, Long brandId) {
        brandDto.setId(brandId);
        return brandMapper.toDto(brandRepository.save(brandMapper.toEntity(brandDto)));
    }

    @Override
    public void deleteBrand(Long id) {
        brandRepository.deleteById(id);
    }
}

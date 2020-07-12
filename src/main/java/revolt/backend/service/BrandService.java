package revolt.backend.service;

import revolt.backend.dto.BrandDto;

import java.util.List;

public interface BrandService {

    List<BrandDto> getBrands();

    BrandDto createBrand(BrandDto brandDto);

    BrandDto getBrand(Long id);

    BrandDto updateBrand(BrandDto brandDto, Long brandId);

    void deleteBrand(Long id);
}

package revolt.backend.mapper;

import lombok.AllArgsConstructor;
import org.mapstruct.ObjectFactory;
import org.springframework.stereotype.Component;
import revolt.backend.dto.LiquidDto;
import revolt.backend.entity.Liquid;
import revolt.backend.repository.BrandRepository;
import revolt.backend.repository.CountryRepository;
import revolt.backend.service.BrandService;

import java.util.Objects;

@Component
@AllArgsConstructor
public class LiquidMapperResolver {

    final BrandRepository brandRepository;
    final CountryRepository countryRepository;

    @ObjectFactory
    Liquid resolve(LiquidDto liquidDto) {
        Liquid liquid = new Liquid();
        if (Objects.nonNull(liquidDto) && Objects.nonNull(liquidDto.getBrandId())) {
            liquid.setBrand(brandRepository.getOne(liquidDto.getBrandId()));
        }
        if (Objects.nonNull(liquidDto) && Objects.nonNull(liquidDto.getCountryId())){
            liquid.setCountry(countryRepository.getOne(liquidDto.getCountryId()));
        }
        return liquid;
    }
}

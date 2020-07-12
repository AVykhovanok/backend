package revolt.backend.mapper;

import lombok.AllArgsConstructor;
import org.mapstruct.ObjectFactory;
import org.springframework.stereotype.Component;
import revolt.backend.dto.RDADto;
import revolt.backend.entity.RDA;
import revolt.backend.repository.BrandRepository;
import revolt.backend.repository.CountryRepository;
import revolt.backend.service.BrandService;

import java.util.Objects;

@Component
@AllArgsConstructor
public class RDAMapperResolver {

    final BrandRepository brandRepository;
    final CountryRepository countryRepository;

    @ObjectFactory
    RDA resolve(RDADto rdaDto) {
        RDA rda = new RDA();
        if (Objects.nonNull(rdaDto) && Objects.nonNull(rdaDto.getBrandId())) {
            rda.setBrand(brandRepository.getOne(rdaDto.getBrandId()));
        }
        if (Objects.nonNull(rdaDto) && Objects.nonNull(rdaDto.getCountryId())){
            rda.setCountry(countryRepository.getOne(rdaDto.getCountryId()));
        }
        return rda;
    }
}

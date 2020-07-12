package revolt.backend.mapper;

import lombok.AllArgsConstructor;
import org.mapstruct.ObjectFactory;
import org.springframework.stereotype.Component;
import revolt.backend.dto.ChargerDto;
import revolt.backend.entity.Charger;
import revolt.backend.repository.BrandRepository;
import revolt.backend.repository.CountryRepository;
import revolt.backend.service.BrandService;

import java.util.Objects;

@Component
@AllArgsConstructor
public class ChargerMapperResolver {

    final BrandRepository brandRepository;
    final CountryRepository countryRepository;

    @ObjectFactory
    Charger resolve(ChargerDto chargerDto) {
        Charger charger = new Charger();
        if (Objects.nonNull(chargerDto) && Objects.nonNull(chargerDto.getBrandId())) {
            charger.setBrand(brandRepository.getOne(chargerDto.getBrandId()));
        }
        if (Objects.nonNull(chargerDto) && Objects.nonNull(chargerDto.getCountryId())){
            charger.setCountry(countryRepository.getOne(chargerDto.getCountryId()));
        }
        return charger;
    }
}

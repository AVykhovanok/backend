package revolt.backend.mapper;

import lombok.AllArgsConstructor;
import org.mapstruct.ObjectFactory;
import org.springframework.stereotype.Component;
import revolt.backend.dto.BoxmodDto;
import revolt.backend.entity.Boxmod;
import revolt.backend.repository.BrandRepository;
import revolt.backend.repository.CountryRepository;
import revolt.backend.service.BrandService;

import java.util.Objects;

@Component
@AllArgsConstructor
public class BoxmodMapperResolver {

    final BrandRepository brandRepository;
    final CountryRepository countryRepository;

    @ObjectFactory
    Boxmod resolve(BoxmodDto boxmodDto) {
        Boxmod boxmod = new Boxmod();
        if (Objects.nonNull(boxmodDto) && Objects.nonNull(boxmodDto.getBrandId())) {
            boxmod.setBrand(brandRepository.getOne(boxmodDto.getBrandId()));
        }
        if (Objects.nonNull(boxmodDto) && Objects.nonNull(boxmodDto.getCountryId())){
            boxmod.setCountry(countryRepository.getOne(boxmodDto.getCountryId()));
        }
        return boxmod;
    }
}

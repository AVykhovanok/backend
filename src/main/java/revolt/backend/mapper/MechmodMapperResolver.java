package revolt.backend.mapper;

import lombok.AllArgsConstructor;
import org.mapstruct.ObjectFactory;
import org.springframework.stereotype.Component;
import revolt.backend.dto.MechmodDto;
import revolt.backend.entity.Mechmod;
import revolt.backend.repository.BrandRepository;
import revolt.backend.repository.CountryRepository;
import revolt.backend.service.BrandService;

import java.util.Objects;

@Component
@AllArgsConstructor
public class MechmodMapperResolver {

    final BrandRepository brandRepository;
    final CountryRepository countryRepository;

    @ObjectFactory
    Mechmod resolve(MechmodDto mechmodDto) {
        Mechmod mechmod = new Mechmod();
        if (Objects.nonNull(mechmodDto) && Objects.nonNull(mechmodDto.getBrandId())) {
            mechmod.setBrand(brandRepository.getOne(mechmodDto.getBrandId()));
        }
        if (Objects.nonNull(mechmodDto) && Objects.nonNull(mechmodDto.getCountryId())){
            mechmod.setCountry(countryRepository.getOne(mechmodDto.getCountryId()));
        }
        return mechmod;
    }
}

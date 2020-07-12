package revolt.backend.mapper;

import lombok.AllArgsConstructor;
import org.mapstruct.ObjectFactory;
import org.springframework.stereotype.Component;
import revolt.backend.dto.RTADto;
import revolt.backend.entity.RTA;
import revolt.backend.repository.BrandRepository;
import revolt.backend.repository.CountryRepository;
import revolt.backend.service.BrandService;

import java.util.Objects;

@Component
@AllArgsConstructor
public class RTAMapperResolver {

    final BrandRepository brandRepository;
    final CountryRepository countryRepository;

    @ObjectFactory
    RTA resolve(RTADto rtaDto) {
        RTA rta = new RTA();
        if (Objects.nonNull(rtaDto) && Objects.nonNull(rtaDto.getBrandId())) {
            rta.setBrand(brandRepository.getOne(rtaDto.getBrandId()));
        }
        if (Objects.nonNull(rtaDto) && Objects.nonNull(rtaDto.getCountryId())){
            rta.setCountry(countryRepository.getOne(rtaDto.getCountryId()));
        }
        return rta;
    }
}

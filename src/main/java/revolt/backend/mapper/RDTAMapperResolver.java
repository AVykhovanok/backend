package revolt.backend.mapper;

import lombok.AllArgsConstructor;
import org.mapstruct.ObjectFactory;
import org.springframework.stereotype.Component;
import revolt.backend.dto.RDTADto;
import revolt.backend.entity.RDTA;
import revolt.backend.repository.BrandRepository;
import revolt.backend.repository.CountryRepository;
import revolt.backend.service.BrandService;

import java.util.Objects;

@Component
@AllArgsConstructor
public class RDTAMapperResolver {

    final BrandRepository brandRepository;
    final CountryRepository countryRepository;

    @ObjectFactory
    RDTA resolve(RDTADto rdtaDto) {
        RDTA rdta = new RDTA();
        if (Objects.nonNull(rdtaDto) && Objects.nonNull(rdtaDto.getBrandId())) {
            rdta.setBrand(brandRepository.getOne(rdtaDto.getBrandId()));
        }
        if (Objects.nonNull(rdtaDto) && Objects.nonNull(rdtaDto.getCountryId())){
            rdta.setCountry(countryRepository.getOne(rdtaDto.getCountryId()));
        }
        return rdta;
    }
}

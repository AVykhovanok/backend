package revolt.backend.mapper;

import lombok.AllArgsConstructor;
import org.mapstruct.ObjectFactory;
import org.springframework.stereotype.Component;
import revolt.backend.dto.ComplectsDto;
import revolt.backend.entity.Complects;
import revolt.backend.repository.BrandRepository;
import revolt.backend.repository.CountryRepository;
import revolt.backend.service.BrandService;

import java.util.Objects;

@Component
@AllArgsConstructor
public class ComplectsMapperResolver {

    final BrandRepository brandRepository;
    final CountryRepository countryRepository;

    @ObjectFactory
    Complects resolve(ComplectsDto complectsDto) {
        Complects complects = new Complects();
        if (Objects.nonNull(complectsDto) && Objects.nonNull(complectsDto.getBrandId())) {
            complects.setBrand(brandRepository.getOne(complectsDto.getBrandId()));
        }
        if (Objects.nonNull(complectsDto) && Objects.nonNull(complectsDto.getCountryId())){
            complects.setCountry(countryRepository.getOne(complectsDto.getCountryId()));
        }
        return complects;
    }
}

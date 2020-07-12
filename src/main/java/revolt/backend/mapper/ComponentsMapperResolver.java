package revolt.backend.mapper;

import lombok.AllArgsConstructor;
import org.mapstruct.ObjectFactory;
import org.springframework.stereotype.Component;
import revolt.backend.dto.ComponentsDto;
import revolt.backend.entity.Components;
import revolt.backend.repository.BrandRepository;
import revolt.backend.repository.CountryRepository;
import revolt.backend.service.BrandService;

import java.util.Objects;

@Component
@AllArgsConstructor
public class ComponentsMapperResolver {

    final BrandRepository brandRepository;
    final CountryRepository countryRepository;

    @ObjectFactory
    Components resolve(ComponentsDto componentsDto) {
        Components components = new Components();
        if (Objects.nonNull(componentsDto) && Objects.nonNull(componentsDto.getBrandId())) {
            components.setBrand(brandRepository.getOne(componentsDto.getBrandId()));
        }
        if (Objects.nonNull(componentsDto) && Objects.nonNull(componentsDto.getCountryId())){
            components.setCountry(countryRepository.getOne(componentsDto.getCountryId()));
        }

        return components;
    }
}

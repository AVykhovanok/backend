package revolt.backend.mapper;

import lombok.AllArgsConstructor;
import org.mapstruct.ObjectFactory;
import org.springframework.stereotype.Component;
import revolt.backend.dto.ConsumablesDto;
import revolt.backend.entity.Consumables;
import revolt.backend.repository.BrandRepository;
import revolt.backend.repository.CountryRepository;
import revolt.backend.service.BrandService;

import java.util.Objects;

@Component
@AllArgsConstructor
public class ConsumablesMapperResolver {

    final BrandRepository brandRepository;
    final CountryRepository countryRepository;

    @ObjectFactory
    Consumables resolve(ConsumablesDto consumablesDto) {
        Consumables consumables = new Consumables();
        if (Objects.nonNull(consumablesDto) && Objects.nonNull(consumablesDto.getBrandId())) {
            consumables.setBrand(brandRepository.getOne(consumablesDto.getBrandId()));
        }
        if (Objects.nonNull(consumablesDto) && Objects.nonNull(consumablesDto.getCountryId())){
            consumables.setCountry(countryRepository.getOne(consumablesDto.getCountryId()));
        }
        return consumables;
    }
}

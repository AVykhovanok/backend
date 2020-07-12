package revolt.backend.mapper;

import lombok.AllArgsConstructor;
import org.mapstruct.ObjectFactory;
import org.springframework.stereotype.Component;
import revolt.backend.dto.BatteryDto;
import revolt.backend.entity.Battery;
import revolt.backend.repository.BrandRepository;
import revolt.backend.repository.CountryRepository;
import revolt.backend.service.BrandService;

import java.util.Objects;

@Component
@AllArgsConstructor
public class BatteryMapperResolver {

    final BrandRepository brandRepository;
    final CountryRepository countryRepository;

    @ObjectFactory
    Battery resolve(BatteryDto batteryDto) {
        Battery battery = new Battery();
        if (Objects.nonNull(batteryDto) && Objects.nonNull(batteryDto.getBrandId())) {
            battery.setBrand(brandRepository.getOne(batteryDto.getBrandId()));
        }
        if (Objects.nonNull(batteryDto) && Objects.nonNull(batteryDto.getCountryId())){
            battery.setCountry(countryRepository.getOne(batteryDto.getCountryId()));
        }
        return battery;
    }
}

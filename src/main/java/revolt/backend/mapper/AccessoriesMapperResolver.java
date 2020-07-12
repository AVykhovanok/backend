package revolt.backend.mapper;

import lombok.AllArgsConstructor;
import org.mapstruct.ObjectFactory;
import org.springframework.stereotype.Component;
import revolt.backend.dto.AccessoriesDto;
import revolt.backend.entity.Accessories;
import revolt.backend.entity.Country;
import revolt.backend.repository.BrandRepository;
import revolt.backend.repository.CountryRepository;
import revolt.backend.service.BrandService;

import java.util.Objects;

@Component
@AllArgsConstructor
public class AccessoriesMapperResolver {

    final BrandRepository brandRepository;
    final CountryRepository countryRepository;

    @ObjectFactory
    Accessories resolve(AccessoriesDto accessoriesDto) {
        Accessories accessories = new Accessories();
        if (Objects.nonNull(accessoriesDto) && Objects.nonNull(accessoriesDto.getBrandId())) {
            accessories.setBrand(brandRepository.getOne(accessoriesDto.getBrandId()));
        }
        if (Objects.nonNull(accessoriesDto) && Objects.nonNull(accessoriesDto.getCountryId())){
            accessories.setCountry(countryRepository.getOne(accessoriesDto.getCountryId()));
        }
        return accessories;
    }
}

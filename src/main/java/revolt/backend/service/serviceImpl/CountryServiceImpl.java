package revolt.backend.service.serviceImpl;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import revolt.backend.dto.CountryDto;
import revolt.backend.entity.Country;
import revolt.backend.mapper.CountryMapper;
import revolt.backend.repository.CountryRepository;
import revolt.backend.service.CountryService;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CountryServiceImpl implements CountryService {

    final CountryRepository countryRepository;
    final CountryMapper countryMapper;

    @Override
    public List<CountryDto> getCountries() {
        return countryMapper.toDtoList(countryRepository.findAll()).stream()
                .sorted(Comparator.comparing(CountryDto::getName))
                .collect(Collectors.toList());
    }

    @Override
    public CountryDto createCountry(CountryDto countryDto) {
        return countryMapper.toDto(countryRepository.save(countryMapper.toEntity(countryDto)));
    }

    @Override
    public CountryDto getCountry(Long id) {
        return countryMapper.toDto(countryRepository.getOne(id));
    }

    @Override
    public CountryDto updateCountry(CountryDto countryDto, Long countryId) {
        countryDto.setId(countryId);
        return countryMapper.toDto(countryRepository.save(countryMapper.toEntity(countryDto)));
    }

    @Override
    public void deleteCountry(Long id) {
        countryRepository.deleteById(id);
    }
}

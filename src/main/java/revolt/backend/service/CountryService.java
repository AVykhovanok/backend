package revolt.backend.service;

import revolt.backend.dto.CountryDto;

import java.util.List;

public interface CountryService {

    List<CountryDto> getCountries();

    CountryDto createCountry(CountryDto countryDto);

    CountryDto getCountry(Long id);

    CountryDto updateCountry(CountryDto countryDto, Long countryId);

    void deleteCountry(Long id);
}

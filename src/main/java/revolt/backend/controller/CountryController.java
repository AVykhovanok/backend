package revolt.backend.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import revolt.backend.dto.CountryDto;
import revolt.backend.service.CountryService;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/country")
@AllArgsConstructor
public class CountryController {

    private CountryService countryService;

    @GetMapping("/all")
    public ResponseEntity<List<CountryDto>> getAllCountries() {
        return new ResponseEntity<>(countryService.getCountries(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CountryDto> getCountryById(@PathVariable Long id) {
        return new ResponseEntity<>(countryService.getCountry(id), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<CountryDto> createCountry(@RequestBody CountryDto countryDto) {
        return new ResponseEntity<>(countryService.createCountry(countryDto), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<CountryDto> updateCountry(@RequestBody CountryDto countryDto,
                                                    @RequestParam Long countryId) {
        return new ResponseEntity<>(countryService.updateCountry(countryDto, countryId), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCountryById(@PathVariable Long id) {
        countryService.deleteCountry(id);
    }
}

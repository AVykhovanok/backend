package revolt.backend.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import revolt.backend.dto.ChargerDto;
import revolt.backend.entity.Charger;
import revolt.backend.service.ChargerService;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/charger")
@AllArgsConstructor
public class ChargerController {

    private ChargerService chargerService;

    @GetMapping("/all")
    public ResponseEntity<List<ChargerDto>> getAllChargers() {
        return new ResponseEntity<>(chargerService.getChargers(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ChargerDto> getChargerById(@PathVariable Long id) {
        return new ResponseEntity<>(chargerService.getCharger(id), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<ChargerDto> createCharger(@RequestBody ChargerDto chargerDto) {
        return new ResponseEntity<>(chargerService.createCharger(chargerDto), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<ChargerDto> updateCharger(@RequestBody ChargerDto chargerDto,
                                                    @RequestParam Long chargerId) {
        return new ResponseEntity<>(chargerService.updateCharger(chargerDto, chargerId), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteChargerById(@PathVariable Long id) {
        chargerService.deleteCharger(id);
    }
}



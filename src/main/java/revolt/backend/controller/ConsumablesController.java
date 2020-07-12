package revolt.backend.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import revolt.backend.dto.ConsumablesDto;
import revolt.backend.service.ConsumablesService;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/consumables")
@AllArgsConstructor
public class ConsumablesController {

    private ConsumablesService consumablesService;

    @GetMapping("/all")
    public ResponseEntity<List<ConsumablesDto>> getAllConsumables() {
        return new ResponseEntity<>(consumablesService.getConsumabless(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConsumablesDto> getConsumablesById(@PathVariable Long id) {
        return new ResponseEntity<>(consumablesService.getConsumables(id), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<ConsumablesDto> createConsumables(@RequestBody ConsumablesDto consumablesDto) {
        return new ResponseEntity<>(consumablesService.createConsumables(consumablesDto), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<ConsumablesDto> updateConsumables(@RequestBody ConsumablesDto consumablesDto,
                                                            @RequestParam Long consumablesId) {
        return new ResponseEntity<>(consumablesService.updateConsumables(consumablesDto, consumablesId), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteConsumablesById(@PathVariable Long id) {
        consumablesService.deleteConsumables(id);
    }
}

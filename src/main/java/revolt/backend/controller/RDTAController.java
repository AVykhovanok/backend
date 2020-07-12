package revolt.backend.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import revolt.backend.dto.RDTADto;
import revolt.backend.service.RDTAService;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/rdta")
@AllArgsConstructor
public class RDTAController {

    private RDTAService rdtaService;

    @GetMapping("/all")
    public ResponseEntity<List<RDTADto>> getAllRDTAs() {
        return new ResponseEntity<>(rdtaService.getRDTAs(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RDTADto> getRDTAById(@PathVariable Long id) {
        return new ResponseEntity<>(rdtaService.getRDTA(id), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<RDTADto> createRDTA(@RequestBody RDTADto rdtaDto) {
        return new ResponseEntity<>(rdtaService.createRDTA(rdtaDto), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<RDTADto> updateRDTA(@RequestBody RDTADto rdtaDto,
                                              @RequestParam Long rdtaId) {
        return new ResponseEntity<>(rdtaService.updateRDTA(rdtaDto, rdtaId), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteRDTAById(@PathVariable Long id) {
        rdtaService.deleteRDTA(id);
    }
}


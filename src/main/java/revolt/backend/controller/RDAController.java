package revolt.backend.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import revolt.backend.dto.RDADto;
import revolt.backend.entity.RDA;
import revolt.backend.mapper.RDAMapper;
import revolt.backend.service.RDAService;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/rda")
@AllArgsConstructor
public class RDAController {

    private RDAService rdaService;

    @GetMapping("/all")
    public ResponseEntity<List<RDADto>> getAllRDAs() {
        return new ResponseEntity<>(rdaService.getRDAs(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RDADto> getRDAById(@PathVariable Long id) {
        return new ResponseEntity<>(rdaService.getRDA(id), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<RDADto> createRDA(@RequestBody RDADto rdaDto) {
        return new ResponseEntity<>(rdaService.createRDA(rdaDto), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<RDADto> updateRDA(@RequestBody RDADto rdaDto,
                                            @RequestParam Long rdaId) {
        return new ResponseEntity<>(rdaService.updateRDA(rdaDto, rdaId), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteRDAById(@PathVariable Long id) {
        rdaService.deleteRDA(id);
    }
}


package revolt.backend.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import revolt.backend.dto.RTADto;
import revolt.backend.entity.RTA;
import revolt.backend.service.RTAService;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/rta")
@AllArgsConstructor
public class RTAController {

    private RTAService rtaService;

    @GetMapping("/all")
    public ResponseEntity<List<RTADto>> getAllRTAs() {
        return new ResponseEntity<>(rtaService.getRTAs(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RTADto> getRTAById(@PathVariable Long id) {
        return new ResponseEntity<>(rtaService.getRTA(id), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<RTADto> createRTA(@RequestBody RTADto rtaDto) {
        return new ResponseEntity<>(rtaService.createRTA(rtaDto), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<RTADto> updateRTA(@RequestBody RTADto rtaDto,
                                            @RequestParam Long rtaId) {
        return new ResponseEntity<>(rtaService.updateRTA(rtaDto, rtaId), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteRTAById(@PathVariable Long id) {
        rtaService.deleteRTA(id);
    }
}

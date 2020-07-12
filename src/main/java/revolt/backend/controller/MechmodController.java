package revolt.backend.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import revolt.backend.dto.MechmodDto;
import revolt.backend.service.MechmodService;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/mechmod")
@AllArgsConstructor
public class MechmodController {

    private MechmodService mechmodService;

    @GetMapping("/all")
    public ResponseEntity<List<MechmodDto>> getAllMechmods() {
        return new ResponseEntity<>(mechmodService.getMechmods(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MechmodDto> getMechmodById(@PathVariable Long id) {
        return new ResponseEntity<>(mechmodService.getMechmod(id), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<MechmodDto> createMechmod(@RequestBody MechmodDto mechmodDto) {
        return new ResponseEntity<>(mechmodService.createMechmod(mechmodDto), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<MechmodDto> updateMechmod(@RequestBody MechmodDto mechmodDto,
                                                    @RequestParam Long mechmodId) {
        return new ResponseEntity<>(mechmodService.updateMechmod(mechmodDto, mechmodId), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteMechmodById(@PathVariable Long id) {
        mechmodService.deleteMechmod(id);
    }
}

package revolt.backend.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import revolt.backend.dto.BoxmodDto;
import revolt.backend.service.BoxmodService;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/boxmod")
@AllArgsConstructor
public class BoxmodController {

    private BoxmodService boxmodService;

    @GetMapping("/all")
    public ResponseEntity<List<BoxmodDto>> getAllBoxmods() {
        return new ResponseEntity<>(boxmodService.getBoxmods(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BoxmodDto> getBoxmodById(@PathVariable Long id) {
        return new ResponseEntity<>(boxmodService.getBoxmod(id), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<BoxmodDto> createBoxmod(@RequestBody BoxmodDto boxmodDto) {
        return new ResponseEntity<>(boxmodService.createBoxmod(boxmodDto), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<BoxmodDto> updateBoxmod(@RequestBody BoxmodDto boxmodDto,
                                                  @RequestParam Long boxmodId) {
        return new ResponseEntity<>(boxmodService.updateBoxmod(boxmodDto, boxmodId), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteBoxmodById(@PathVariable Long id) {
        boxmodService.deleteBoxmod(id);
    }
}



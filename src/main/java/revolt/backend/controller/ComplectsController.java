package revolt.backend.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import revolt.backend.dto.ComplectsDto;
import revolt.backend.service.ComplectsService;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/complects")
@AllArgsConstructor
public class ComplectsController {

    private ComplectsService complectsService;

    @GetMapping("/all")
    public ResponseEntity<List<ComplectsDto>> getAllComplects() {
        return new ResponseEntity<>(complectsService.getComplectss(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ComplectsDto> getComplectsById(@PathVariable Long id) {
        return new ResponseEntity<>(complectsService.getComplects(id), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<ComplectsDto> createComplects(@RequestBody ComplectsDto complectsDto) {
        return new ResponseEntity<>(complectsService.createComplects(complectsDto), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<ComplectsDto> updateComplects(@RequestBody ComplectsDto complectsDto,
                                                        @RequestParam Long complectsId) {
        return new ResponseEntity<>(complectsService.updateComplects(complectsDto, complectsId), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteComplectsById(@PathVariable Long id) {
        complectsService.deleteComplects(id);
    }
}




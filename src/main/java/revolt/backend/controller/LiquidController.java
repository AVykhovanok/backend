package revolt.backend.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import revolt.backend.dto.LiquidDto;
import revolt.backend.service.LiquidService;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/liquid")
@AllArgsConstructor
public class LiquidController {

    private LiquidService liquidService;

    @GetMapping("/all")
    public ResponseEntity<List<LiquidDto>> getAllLiquids() {
        return new ResponseEntity<>(liquidService.getLiquids(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LiquidDto> getLiquidById(@PathVariable Long id) {
        return new ResponseEntity<>(liquidService.getLiquid(id), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<LiquidDto> createLiquid(@RequestBody LiquidDto liquidDto) {
        return new ResponseEntity<>(liquidService.createLiquid(liquidDto), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<LiquidDto> updateLiquid(@RequestBody LiquidDto liquidDto,
                                                  @RequestParam Long liquidId) {
        return new ResponseEntity<>(liquidService.updateLiquid(liquidDto, liquidId), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteLiquidById(@PathVariable Long id) {
        liquidService.deleteLiquid(id);
    }
}

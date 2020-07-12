package revolt.backend.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import revolt.backend.dto.BatteryDto;
import revolt.backend.entity.Battery;
import revolt.backend.mapper.BatteryMapper;
import revolt.backend.service.BatteryService;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/battery")
@AllArgsConstructor
public class BatteryController {

    private BatteryService batteryService;

    @GetMapping("/all")
    public ResponseEntity<List<BatteryDto>> getAllBatteries() {
        return new ResponseEntity<>(batteryService.getAllBatteries(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BatteryDto> getBatteryById(@PathVariable Long id) {
        return new ResponseEntity<>(batteryService.getBattery(id), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<BatteryDto> createBattery(@RequestBody BatteryDto batteryDto) {
        return new ResponseEntity<>(batteryService.createBattery(batteryDto), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<BatteryDto> updateBattery(@RequestBody BatteryDto batteryDto,
                                                    @RequestParam Long batteryId) {
        return new ResponseEntity<>(batteryService.updateBattery(batteryDto,batteryId), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteBatteryById(@PathVariable Long id) {
        batteryService.deleteBattery(id);
    }
}
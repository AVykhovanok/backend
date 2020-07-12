package revolt.backend.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import revolt.backend.dto.AccessoriesDto;
import revolt.backend.entity.Accessories;
import revolt.backend.mapper.AccessoriesMapper;
import revolt.backend.service.AccessoriesService;

import java.util.List;

@Slf4j
@CrossOrigin("*")
@RestController
@AllArgsConstructor
@RequestMapping("/accessories")
public class AccessoriesController {

    private final AccessoriesService accessoriesService;

    @GetMapping("/all")
    public ResponseEntity<List<AccessoriesDto>> getAllAccessories() {
        return new ResponseEntity<>((accessoriesService.getAllAccessories()), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccessoriesDto> getAccessoriesById(@PathVariable Long id) {
        return new ResponseEntity<>(accessoriesService.getAccessories(id), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<AccessoriesDto> createAccessories(@RequestBody AccessoriesDto accessoriesDto) {
        return new ResponseEntity<>(accessoriesService.createAccessories(accessoriesDto), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<AccessoriesDto> updateAccessories(@RequestBody AccessoriesDto accessoriesDto,
                                                            @RequestParam Long accessoriesId) {
        return new ResponseEntity<>(accessoriesService.updateAccessories(accessoriesDto, accessoriesId), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteAccessoriesById(@PathVariable Long id) {
        accessoriesService.deleteAccessories(id);
    }
}


package revolt.backend.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import revolt.backend.dto.ComponentsDto;
import revolt.backend.entity.Components;
import revolt.backend.service.ComponentsService;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/components")
@AllArgsConstructor
public class ComponentsController {

    private ComponentsService componentsService;

    @GetMapping("/all")
    public ResponseEntity<List<ComponentsDto>> getAllComponents() {
        return new ResponseEntity<>(componentsService.getAllComponents(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ComponentsDto> getComponentsById(@PathVariable Long id) {
        return new ResponseEntity<>(componentsService.getComponents(id), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<ComponentsDto> createComponents(@RequestBody ComponentsDto componentsDto) {
        return new ResponseEntity<>(componentsService.createComponents(componentsDto), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<ComponentsDto> updateComponents(@RequestBody ComponentsDto componentsDto,
                                                          @RequestParam Long componentsId) {
        return new ResponseEntity<>(componentsService.updateComponents(componentsDto,componentsId), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteComponentsById(@PathVariable Long id) {
        componentsService.deleteComponents(id);
    }
}






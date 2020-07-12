package revolt.backend.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import revolt.backend.dto.BrandDto;
import revolt.backend.service.BrandService;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/brand")
@AllArgsConstructor
public class BrandController {

    private BrandService brandService;

    @GetMapping("/all")
    public ResponseEntity<List<BrandDto>> getAllBrands() {
        return new ResponseEntity<>(brandService.getBrands(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BrandDto> getBrandsById(@PathVariable Long id) {
        return new ResponseEntity<>(brandService.getBrand(id), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<BrandDto> createBrands(@RequestBody BrandDto brandDto) {
        return new ResponseEntity<>(brandService.createBrand(brandDto), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<BrandDto> updateBrands(@RequestBody BrandDto brandDto,
                                                 @RequestParam Long brandId) {
        return new ResponseEntity<>(brandService.updateBrand(brandDto, brandId), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteBrandsById(@PathVariable Long id) {
        brandService.deleteBrand(id);
    }
}


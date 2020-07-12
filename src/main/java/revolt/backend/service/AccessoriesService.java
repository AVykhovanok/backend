package revolt.backend.service;

import revolt.backend.dto.AccessoriesDto;

import java.util.List;

public interface AccessoriesService {

    List<AccessoriesDto> getAllAccessories();

    AccessoriesDto createAccessories(AccessoriesDto accessoriesDto);

    AccessoriesDto getAccessories(Long id);

    AccessoriesDto updateAccessories(AccessoriesDto accessoriesDto, Long accessoriesId);

    void deleteAccessories(Long id);

}

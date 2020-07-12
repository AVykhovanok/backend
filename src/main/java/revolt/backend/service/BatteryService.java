
package revolt.backend.service;

import revolt.backend.dto.BatteryDto;

import java.util.List;

public interface BatteryService {

    List<BatteryDto> getAllBatteries();

    BatteryDto createBattery(BatteryDto batteryDto);

    BatteryDto getBattery(Long id);

    BatteryDto updateBattery(BatteryDto batteryDto, Long batteryId);

    void deleteBattery(Long id);

}
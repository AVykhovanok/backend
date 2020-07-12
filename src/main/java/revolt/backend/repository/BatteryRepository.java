package revolt.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import revolt.backend.entity.Battery;

@Repository
public interface BatteryRepository extends JpaRepository<Battery, Long> {
}

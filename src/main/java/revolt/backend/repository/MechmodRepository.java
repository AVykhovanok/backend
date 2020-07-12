package revolt.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import revolt.backend.entity.Mechmod;

@Repository
public interface MechmodRepository extends JpaRepository<Mechmod, Long> {
}

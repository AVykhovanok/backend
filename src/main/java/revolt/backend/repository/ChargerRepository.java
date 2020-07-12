package revolt.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import revolt.backend.entity.Charger;

@Repository
public interface ChargerRepository extends JpaRepository<Charger, Long> {
}

package revolt.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import revolt.backend.entity.Consumables;

@Repository
public interface ConsumablesRepository extends JpaRepository<Consumables, Long> {
}

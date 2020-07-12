package revolt.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import revolt.backend.entity.RDA;


@Repository
public interface RDARepository extends JpaRepository<RDA, Long> {
}

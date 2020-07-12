package revolt.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import revolt.backend.entity.Boxmod;

@Repository
public interface BoxmodRepository extends JpaRepository<Boxmod, Long> {
}

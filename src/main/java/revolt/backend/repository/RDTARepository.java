package revolt.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import revolt.backend.entity.RDTA;

@Repository
public interface RDTARepository extends JpaRepository<RDTA, Long> {
}


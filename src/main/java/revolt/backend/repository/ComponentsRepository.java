package revolt.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import revolt.backend.entity.Components;

@Repository
public interface ComponentsRepository extends JpaRepository<Components, Long> {
}

package revolt.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import revolt.backend.entity.Liquid;

@Repository
public interface LiquidRepository  extends JpaRepository<Liquid, Long> {
}

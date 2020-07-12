package revolt.backend.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import revolt.backend.entity.Accessories;

@Repository
public interface AccessoriesRepository extends JpaRepository<Accessories, Long> {
}

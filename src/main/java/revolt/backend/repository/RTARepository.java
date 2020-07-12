package revolt.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import revolt.backend.entity.RTA;

@Repository
public interface RTARepository extends JpaRepository<RTA, Long> {

//    List<RTA> findAllByActive(Boolean b);

}

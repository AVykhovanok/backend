package revolt.backend.repository;
//місце де зберігаются данні ... зєднуя ентіті з базою(формує запит в базу данних)
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import revolt.backend.entity.Complects;

@Repository
public interface ComplectsRepository extends JpaRepository<Complects, Long> {
}

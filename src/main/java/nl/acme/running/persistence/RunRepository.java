package nl.acme.running.persistence;

import nl.acme.running.domain.Run;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface RunRepository extends CrudRepository<Run, Long> {

}

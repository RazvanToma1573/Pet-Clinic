package razvan.toma.petclinic.Repository;

import org.springframework.data.repository.CrudRepository;
import razvan.toma.petclinic.Model.Visit;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}

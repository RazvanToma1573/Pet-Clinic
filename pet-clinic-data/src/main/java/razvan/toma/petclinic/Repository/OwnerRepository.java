package razvan.toma.petclinic.Repository;

import org.springframework.data.repository.CrudRepository;
import razvan.toma.petclinic.Model.Owner;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
}

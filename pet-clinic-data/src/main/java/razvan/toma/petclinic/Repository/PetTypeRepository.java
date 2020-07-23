package razvan.toma.petclinic.Repository;

import org.springframework.data.repository.CrudRepository;
import razvan.toma.petclinic.Model.PetType;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}

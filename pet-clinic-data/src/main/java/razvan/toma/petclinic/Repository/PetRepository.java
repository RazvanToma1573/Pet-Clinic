package razvan.toma.petclinic.Repository;

import org.springframework.data.repository.CrudRepository;
import razvan.toma.petclinic.Model.Pet;

public interface PetRepository extends CrudRepository<Pet, Long> {
}

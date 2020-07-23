package razvan.toma.petclinic.Repository;

import org.springframework.data.repository.CrudRepository;
import razvan.toma.petclinic.Model.Vet;

public interface VetRepository extends CrudRepository<Vet, Long> {
}

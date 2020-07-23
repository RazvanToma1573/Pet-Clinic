package razvan.toma.petclinic.Repository;

import org.springframework.data.repository.CrudRepository;
import razvan.toma.petclinic.Model.Speciality;

public interface SpecialityRepository extends CrudRepository<Speciality, Long> {
}

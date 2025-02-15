package razvan.toma.petclinic.Service.Map;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import razvan.toma.petclinic.Model.Pet;
import razvan.toma.petclinic.Service.PetService;

import java.util.Set;

@Service
@Profile({"default", "Map"})
public class PetServiceMap extends AbstractMapService<Pet, Long> implements PetService {

    @Override
    public Set<Pet> findAll() {
        return super.findAll();
    }

    @Override
    public Pet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Pet save(Pet object) {
        return super.save(object);
    }

    @Override
    public void delete(Pet object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}

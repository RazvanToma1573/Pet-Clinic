package razvan.toma.petclinic.Service.Map;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import razvan.toma.petclinic.Model.PetType;
import razvan.toma.petclinic.Service.PetTypeService;

import java.util.Set;

@Service
@Profile({"default", "Map"})
public class PetTypeServiceMap extends AbstractMapService<PetType, Long> implements PetTypeService {

    @Override
    public Set<PetType> findAll() {
        return super.findAll();
    }

    @Override
    public PetType findById(Long id) {
        return super.findById(id);
    }

    @Override
    public PetType save(PetType object) {
        return super.save(object);
    }

    @Override
    public void delete(PetType object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}

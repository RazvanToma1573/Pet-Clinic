package razvan.toma.petclinic.Service.Map;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import razvan.toma.petclinic.Model.Visit;
import razvan.toma.petclinic.Service.PetService;
import razvan.toma.petclinic.Service.VisitService;

import java.util.Set;

@Service
@Profile({"default", "Map"})
public class VisitServiceMap extends AbstractMapService<Visit, Long> implements VisitService {

    private final PetService petService;

    public VisitServiceMap(PetService petService) {
        this.petService = petService;
    }

    @Override
    public Set<Visit> findAll() {
        return super.findAll();
    }

    @Override
    public Visit findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Visit save(Visit object) {
        if (object == null || object.getPet() == null ||
        object.getPet().getOwner() == null || object.getPet().getOwner().getId() == null) {
            throw new RuntimeException("Invalid Visit !!!");
        }
        return super.save(object);
    }

    @Override
    public void delete(Visit object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}

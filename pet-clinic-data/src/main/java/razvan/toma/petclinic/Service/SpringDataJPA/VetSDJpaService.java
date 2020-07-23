package razvan.toma.petclinic.Service.SpringDataJPA;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import razvan.toma.petclinic.Model.Vet;
import razvan.toma.petclinic.Repository.VetRepository;
import razvan.toma.petclinic.Service.VetService;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Profile("SpringDataJPA")
public class VetSDJpaService implements VetService {

    private final VetRepository vetRepository;

    public VetSDJpaService(VetRepository vetRepository) {
        this.vetRepository = vetRepository;
    }

    @Override
    public Set<Vet> findAll() {
        Set<Vet> vets = new HashSet<>();
        vetRepository.findAll().forEach(vets::add);
        return vets;
    }

    @Override
    public Vet findById(Long aLong) {
        Optional<Vet> optionalVet = vetRepository.findById(aLong);
        return optionalVet.orElse(null);
    }

    @Override
    public Vet save(Vet object) {
        return vetRepository.save(object);
    }

    @Override
    public void delete(Vet object) {
        vetRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        vetRepository.deleteById(aLong);
    }
}

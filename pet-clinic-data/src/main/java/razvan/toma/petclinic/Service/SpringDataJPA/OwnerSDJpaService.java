package razvan.toma.petclinic.Service.SpringDataJPA;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import razvan.toma.petclinic.Model.Owner;
import razvan.toma.petclinic.Repository.OwnerRepository;
import razvan.toma.petclinic.Service.OwnerService;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Profile("SpringDataJPA")
public class OwnerSDJpaService implements OwnerService {

    private final OwnerRepository ownerRepository;

    public OwnerSDJpaService(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @Override
    public Owner findByLastName(String lastName) {
        Optional<Owner> optionalOwner = ownerRepository.findByLastName(lastName);
        return optionalOwner.orElse(null);
    }

    @Override
    public Set<Owner> findAll() {
        Set<Owner> owners = new HashSet<>();
        ownerRepository.findAll().forEach(owners::add);
        return owners;
    }

    @Override
    public Owner findById(Long aLong) {
        Optional<Owner> optionalOwner = ownerRepository.findById(aLong);
        return optionalOwner.orElse(null);
    }

    @Override
    public Owner save(Owner object) {
        return ownerRepository.save(object);
    }

    @Override
    public void delete(Owner object) {
        ownerRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        ownerRepository.deleteById(aLong);
    }
}

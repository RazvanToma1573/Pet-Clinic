package razvan.toma.petclinic.Service;

import razvan.toma.petclinic.Model.Vet;

import java.util.Set;

public interface VetService {

    Vet findById(Long id);

    Vet save(Vet vet);

    Set<Vet> findAll();
}

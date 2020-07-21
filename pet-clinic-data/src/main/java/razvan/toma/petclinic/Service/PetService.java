package razvan.toma.petclinic.Service;

import razvan.toma.petclinic.Model.Pet;

import java.util.Set;

public interface PetService {

    Pet findById(Long id);

    Pet save(Pet owner);

    Set<Pet> findAll();
}

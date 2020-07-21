package razvan.toma.petclinic.Service;

import razvan.toma.petclinic.Model.Owner;

import java.util.Set;

public interface OwnerService {

    Owner findByLastName(String lastName);

    Owner findById(Long id);

    Owner save(Owner owner);

    Set<Owner> findAll();

}

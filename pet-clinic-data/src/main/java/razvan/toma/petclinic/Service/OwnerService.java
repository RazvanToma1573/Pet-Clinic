package razvan.toma.petclinic.Service;

import razvan.toma.petclinic.Model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);

}

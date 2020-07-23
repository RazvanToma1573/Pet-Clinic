package razvan.toma.petclinic.Bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import razvan.toma.petclinic.Model.Owner;
import razvan.toma.petclinic.Model.PetType;
import razvan.toma.petclinic.Model.Vet;
import razvan.toma.petclinic.Service.OwnerService;
import razvan.toma.petclinic.Service.PetTypeService;
import razvan.toma.petclinic.Service.VetService;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        // Pet types
        PetType dog = new PetType();
        dog.setName("Dog");

        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");

        PetType savedCatPetType = petTypeService.save(dog);

        // Owners
        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");
        
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glenanne");

        ownerService.save(owner2);

        System.out.println("Loaded Owners ... ");

        // Vets
        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");

        vetService.save(vet2);

        System.out.println("Loaded Vets ... ");

    }
}

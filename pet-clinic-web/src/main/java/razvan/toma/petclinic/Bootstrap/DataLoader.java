package razvan.toma.petclinic.Bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import razvan.toma.petclinic.Model.Owner;
import razvan.toma.petclinic.Model.Vet;
import razvan.toma.petclinic.Service.Map.OwnerServiceMap;
import razvan.toma.petclinic.Service.Map.VetServiceMap;
import razvan.toma.petclinic.Service.OwnerService;
import razvan.toma.petclinic.Service.VetService;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader() {
        ownerService = new OwnerServiceMap();
        vetService = new VetServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");
        
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glenanne");

        ownerService.save(owner2);

        System.out.println("Loaded Owners ... ");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(1L);
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");

        vetService.save(vet2);

        System.out.println("Loaded Vets ... ");

    }
}

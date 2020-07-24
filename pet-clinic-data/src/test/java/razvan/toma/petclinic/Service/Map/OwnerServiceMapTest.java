package razvan.toma.petclinic.Service.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import razvan.toma.petclinic.Model.Owner;
import razvan.toma.petclinic.Service.OwnerService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class OwnerServiceMapTest {

    OwnerService ownerService;

    @BeforeEach
    void setUp() {
        ownerService = new OwnerServiceMap(new PetTypeServiceMap(), new PetServiceMap());

        ownerService.save(Owner.builder().id(1L).firstName("Mihai").lastName("Berechet").build());
    }

    @Test
    void findAll() {
        assertEquals(1, ownerService.findAll().size());
    }

    @Test
    void findById() {
        Long id = 1L;
        Owner owner = ownerService.findById(id);

        assertEquals("Mihai", owner.getFirstName());
    }

    @Test
    void save() {
        Owner newOwner = Owner.builder().id(2L).build();
        ownerService.save(newOwner);
        assertEquals(2, ownerService.findAll().size());
    }

    @Test
    void saveExistingId() {
        Long id = 2L;
        Owner newOwner = Owner.builder().id(id).build();
        ownerService.save(newOwner);
        assertEquals(id, ownerService.findById(id).getId());
    }

    @Test
    void saveNoId() {
        Owner newOwner = ownerService.save(Owner.builder().build());

        assertNotNull(newOwner);
        assertNotNull(newOwner.getId());
    }

    @Test
    void delete() {
        Owner newOwner = Owner.builder().id(2L).build();
        Owner returnedOwner = ownerService.save(newOwner);
        assertEquals(2, ownerService.findAll().size());
        ownerService.delete(returnedOwner);
        assertEquals(1, ownerService.findAll().size());
    }

    @Test
    void deleteById() {
        ownerService.deleteById(1L);
        assertEquals(0, ownerService.findAll().size());
    }

    @Test
    void findByLastName() {
        Owner owner = ownerService.findByLastName("Berechet");
        assertEquals("Berechet", owner.getLastName());
    }
}
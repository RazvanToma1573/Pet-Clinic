package razvan.toma.petclinic.Service.SpringDataJPA;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import razvan.toma.petclinic.Model.Owner;
import razvan.toma.petclinic.Repository.OwnerRepository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {

    @InjectMocks
    OwnerSDJpaService ownerSDJpaService;

    @Mock
    OwnerRepository ownerRepository;

    Owner returnOwner;

    @BeforeEach
    void setUp() {
        returnOwner = Owner.builder().id(1l).lastName("Caluian").build();
    }

    @Test
    void findByLastName() {
        Owner returnedOwner = Owner.builder().id(1L).firstName("Razvan").lastName("Toma").build();
        when(ownerRepository.findByLastName(any())).thenReturn(Optional.ofNullable(returnedOwner));
        Owner smith = ownerSDJpaService.findByLastName("Toma");
        assertEquals("Toma", smith.getLastName());
        verify(ownerRepository, times(1)).findByLastName(any());
    }

    @Test
    void findAll() {
        Set<Owner> owners = new HashSet<>();
        owners.add(Owner.builder().id(1L).build());
        owners.add(Owner.builder().id(2L).build());
        when(ownerRepository.findAll()).thenReturn(owners);
        Set<Owner> returnedOwners = ownerSDJpaService.findAll();
        assertEquals(2, returnedOwners.size());
        verify(ownerRepository, times(1)).findAll();
    }

    @Test
    void findById() {
        Owner owner = Owner.builder().id(1L).build();
        when(ownerRepository.findById(any())).thenReturn(Optional.ofNullable(owner));
        Owner owner1 = ownerSDJpaService.findById(1L);
        assertEquals(1L, owner1.getId());
        verify(ownerRepository, times(1)).findById(any());
    }

    @Test
    void save() {
        Owner owner = Owner.builder().id(1L).build();
        when(ownerRepository.save(any())).thenReturn(owner);
        Owner returnedOwner = ownerSDJpaService.save(owner);
        assertNotNull(returnedOwner);
        assertEquals(owner.getId(), returnedOwner.getId());
        verify(ownerRepository, times(1)).save(any());
    }

    @Test
    void delete() {
        ownerSDJpaService.delete(returnOwner);

        //default is 1 times
        verify(ownerRepository, times(1)).delete(any());
    }

    @Test
    void deleteById() {
        ownerSDJpaService.deleteById(1L);

        verify(ownerRepository).deleteById(anyLong());
    }
}
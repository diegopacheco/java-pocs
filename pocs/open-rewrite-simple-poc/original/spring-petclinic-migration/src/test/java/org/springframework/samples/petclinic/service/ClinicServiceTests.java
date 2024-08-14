package org.springframework.samples.petclinic.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.samples.petclinic.owner.*;
import org.springframework.samples.petclinic.vet.Vet;
import org.springframework.samples.petclinic.vet.VetRepository;
import org.springframework.samples.petclinic.visit.Visit;
import org.springframework.samples.petclinic.visit.VisitRepository;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Date;

import org.junit.Assert;

/**
 * Integration test of the Service and the Repository layer.
 * <p>
 * ClinicServiceSpringDataJpaTests subclasses benefit from the following services provided by the Spring
 * TestContext Framework: </p> <ul> <li><strong>Spring IoC container caching</strong> which spares us unnecessary set up
 * time between test execution.</li> <li><strong>Dependency Injection</strong> of test fixture instances, meaning that
 * we don't need to perform application context lookups. <li><strong>Transaction management</strong>, meaning each test method is executed in its own transaction,
 * which is automatically rolled back by default. Thus, even if tests insert or otherwise change database state, there
 * is no need for a teardown or cleanup script. <li> An {@link org.springframework.context.ApplicationContext
 * ApplicationContext} is also inherited and can be used for explicit bean lookup if necessary. </li> </ul>
 *
 * @author Ken Krebs
 * @author Rod Johnson
 * @author Juergen Hoeller
 * @author Sam Brannen
 * @author Michael Isvy
 * @author Dave Syer
 */

@RunWith(SpringRunner.class)
@DataJpaTest(includeFilters = @ComponentScan.Filter(Service.class))
public class ClinicServiceTests {

    @Autowired
    protected OwnerRepository owners;

    @Autowired
    protected PetRepository pets;

    @Autowired
    protected VisitRepository visits;

    @Autowired
    protected VetRepository vets;

    @Test
    public void shouldFindOwnersByLastName() {
        Collection<Owner> owners = this.owners.findByLastName("Davis");
        Assert.assertEquals(2, owners.size());

        owners = this.owners.findByLastName("Daviss");
        Assert.assertTrue(owners.isEmpty());
    }

    @Test
    public void shouldFindSingleOwnerWithPet() {
        Owner owner = this.owners.findById(1);
        Assert.assertTrue(owner.getLastName().startsWith("Franklin"));
        Assert.assertEquals(1, owner.getPets().size());
        Assert.assertNotNull(owner.getPets().get(0).getType());
        Assert.assertEquals("cat", owner.getPets().get(0).getType().getName());
    }

    @Test
    @Transactional
    public void shouldInsertOwner() {
        Collection<Owner> owners = this.owners.findByLastName("Schultz");
        int found = owners.size();

        Owner owner = new Owner();
        owner.setFirstName("Sam");
        owner.setLastName("Schultz");
        owner.setAddress("4, Evans Street");
        owner.setCity("Wollongong");
        owner.setTelephone("4444444444");
        this.owners.save(owner);
        Assert.assertNotEquals(0, owner.getId().longValue());

        owners = this.owners.findByLastName("Schultz");
        Assert.assertEquals(found + 1, owners.size());
    }

    @Test
    @Transactional
    public void shouldUpdateOwner() {
        Owner owner = this.owners.findById(1);
        String oldLastName = owner.getLastName();
        String newLastName = oldLastName + "X";

        owner.setLastName(newLastName);
        this.owners.save(owner);

        // retrieving new name from database
        owner = this.owners.findById(1);
        Assert.assertEquals(newLastName, owner.getLastName());
    }

    @Test
    public void shouldFindPetWithCorrectId() {
        Pet pet7 = this.pets.findById(7);
        Assert.assertTrue(pet7.getName().startsWith("Samantha"));
        Assert.assertEquals("Jean", pet7.getOwner().getFirstName());
    }

    @Test
    public void shouldFindAllPetTypes() {
        Collection<PetType> petTypes = this.pets.findPetTypes();

        PetType petType1 = EntityUtils.getById(petTypes, PetType.class, 1);
        Assert.assertEquals("cat", petType1.getName());
        PetType petType4 = EntityUtils.getById(petTypes, PetType.class, 4);
        Assert.assertEquals("snake", petType4.getName());
    }

    @Test
    @Transactional
    public void shouldInsertPetIntoDatabaseAndGenerateId() {
        Owner owner6 = this.owners.findById(6);
        int found = owner6.getPets().size();

        Pet pet = new Pet();
        pet.setName("bowser");
        Collection<PetType> types = this.pets.findPetTypes();
        pet.setType(EntityUtils.getById(types, PetType.class, 2));
        pet.setBirthDate(new Date());
        owner6.addPet(pet);
        Assert.assertEquals(found + 1, owner6.getPets().size());

        this.pets.save(pet);
        this.owners.save(owner6);

        owner6 = this.owners.findById(6);
        Assert.assertEquals(found + 1, owner6.getPets().size());
        // checks that id has been generated
        Assert.assertNotNull(pet.getId());
    }

    @Test
    @Transactional
    public void shouldUpdatePetName() throws Exception {
        Pet pet7 = this.pets.findById(7);
        String oldName = pet7.getName();

        String newName = oldName + "X";
        pet7.setName(newName);
        this.pets.save(pet7);

        pet7 = this.pets.findById(7);
        Assert.assertEquals(newName, pet7.getName());
    }

    @Test
    public void shouldFindVets() {
        Collection<Vet> vets = this.vets.findAll();

        Vet vet = EntityUtils.getById(vets, Vet.class, 3);
        Assert.assertEquals("Douglas", vet.getLastName());
        Assert.assertEquals(2, vet.getNrOfSpecialties());
        Assert.assertEquals("dentistry", vet.getSpecialties().get(0).getName());
        Assert.assertEquals("surgery", vet.getSpecialties().get(1).getName());
    }

    @Test
    @Transactional
    public void shouldAddNewVisitForPet() {
        Pet pet7 = this.pets.findById(7);
        int found = pet7.getVisits().size();
        Visit visit = new Visit();
        pet7.addVisit(visit);
        visit.setDescription("test");
        this.visits.save(visit);
        this.pets.save(pet7);

        pet7 = this.pets.findById(7);
        Assert.assertEquals(found + 1, pet7.getVisits().size());
        Assert.assertNotNull(visit.getId());
    }

    @Test
    public void shouldFindVisitsByPetId() throws Exception {
        Collection<Visit> visits = this.visits.findByPetId(7);
        Assert.assertEquals(2, visits.size());
        Visit[] visitArr = visits.toArray(new Visit[visits.size()]);
        Assert.assertNotNull(visitArr[0].getDate());
        Assert.assertEquals(7, visitArr[0].getPetId().longValue());
    }

}

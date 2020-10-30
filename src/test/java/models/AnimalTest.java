package models;

import org.junit.Rule;
import org.junit.Test;
import static org.junit.Assert.*;

public class AnimalTest {

    private Animal createNewAnimal(){
        return new Animal("Zebra");
    }

    @Rule
    public DatabaseRule database = new DatabaseRule();


    @Test
    public void animal_InstantiatesCorrectly_true() {
        Animal testAnimal = createNewAnimal();
        assertTrue(testAnimal instanceof Animal);
    }

    @Test
    public void animal_InstantiatesWithType_NonEndangered() {
        Animal testAnimal = createNewAnimal();
        assertEquals("Non-Endangered", testAnimal.getType());
    }

    @Test
    public void equals_ReturnsTrueIfNameAndTypeAreSame_true() {
        Animal testAnimal = createNewAnimal();
        Animal anotherAnimal = createNewAnimal();
        assertEquals(testAnimal, anotherAnimal);
        assertEquals(testAnimal.animalType, anotherAnimal.animalType);
    }

    @Test
    public void save_SuccessfullyAddsAnimalToDatabaseList() {
        Animal testAnimal =  createNewAnimal();
        testAnimal.save();
        assertTrue(Animal.getAll().get(0).equals(testAnimal));
    }

    @Test
    public void all_returnsAllInstancesOfPerson_true() {
        Animal firstAnimal = createNewAnimal();
        firstAnimal.save();
        Animal secondAnimal = new Animal("Rhino");
        secondAnimal.save();
        assertEquals(true, Animal.getAll().get(0).equals(firstAnimal));
        assertEquals(true, Animal.getAll().get(1).equals(secondAnimal));
    }

    @Test
    public void save_assignsIdToObject() {
        Animal testAnimal = createNewAnimal();
        testAnimal.save();
        Animal savedAnimal = Animal.getAll().get(0);
        assertEquals(testAnimal.getId(), savedAnimal.getId());
    }

    @Test
    public void find_returnsPersonWithSameId_secondPerson() {
        Animal firstAnimal = createNewAnimal();
        firstAnimal.save();
        Animal secondAnimal = new Animal("Rhino");
        secondAnimal.save();
        assertEquals(Animal.findById(secondAnimal.getId()), secondAnimal);
    }
}
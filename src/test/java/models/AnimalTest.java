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
}
package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class AnimalTest {

    public Animal createNewAnimal(){
        return new Animal("Zebra");
    }

    @Test
    public void animal_InstantiatesCorrectly_true() {
        Animal testAnimal = createNewAnimal();
        assertEquals(true, testAnimal instanceof Animal);
    }

    @Test
    public void Animal_instantiatesWithType_NonEndangered() {
        Animal testAnimal = createNewAnimal();
        assertEquals("Non-Endangered", testAnimal.getType());
    }

    @Test
    public void equals_returnsTrueIfNameAndTypeAreSame_true() {
        Animal testAnimal = createNewAnimal();
        Animal anotherAnimal = createNewAnimal();
        assertTrue(testAnimal.equals(anotherAnimal));
        assertTrue(testAnimal.animalType.equals(anotherAnimal.animalType));
    }
}
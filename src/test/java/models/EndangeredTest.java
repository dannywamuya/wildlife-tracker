package models;

import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class EndangeredTest {

    private Endangered createEndangeredAnimal(){
        return new Endangered("Koala","Okay", "Young");
    }

    @Rule
    public DatabaseRule database = new DatabaseRule();

    @Test
    public void endangeredAnimal_instantiatesCorrectly_true() {
        Endangered testEndangered = createEndangeredAnimal();
        assertTrue(testEndangered instanceof Endangered);
    }

    @Test
    public void endangeredAnimal_instantiatesWithAllProperties_true(){
        Endangered testEndangered = createEndangeredAnimal();
        assertEquals("Koala", testEndangered.getName());
        assertEquals("Okay", testEndangered.getHealth());
        assertEquals("Young", testEndangered.getAge());
        assertTrue(testEndangered.animalType.equals("Endangered"));
    }

    @Test
    public void equals_ReturnsTrueIfNameAndTypeAreSame_true() {
        Endangered testAnimal = createEndangeredAnimal();
        Endangered anotherAnimal = createEndangeredAnimal();
        assertEquals(testAnimal, anotherAnimal);
        assertEquals(testAnimal.animalType, anotherAnimal.animalType);
    }
}
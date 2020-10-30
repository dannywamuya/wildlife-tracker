package models;

import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class RangerTest {

    public Ranger createNewRanger(){ return new Ranger("John");}

    @Rule
    public DatabaseRule database = new DatabaseRule();

    @Test
    public void ranger_instantiatesCorrectly_true(){
        Ranger testRanger = createNewRanger();
        assertTrue(testRanger instanceof Ranger);
        assertEquals("John", testRanger.getName());
    }
}
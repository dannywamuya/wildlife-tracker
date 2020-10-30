package models;

import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class SightingTest {

    private Sighting createNewSighting(){
        return new Sighting(1,1,1);
    }

    @Rule
    public DatabaseRule database = new DatabaseRule();

    @Test
    public void sighting_instantiatesCorrectly_true() {
        Sighting testSighting = createNewSighting();
        assertEquals(true, testSighting instanceof Sighting);
    }

    @Test
    public void equals_ReturnsTrueIfNamesAreSame_true() {
        Sighting testSighting = createNewSighting();
        Sighting anotherSighting = createNewSighting();
        assertEquals(testSighting, anotherSighting);
    }

}
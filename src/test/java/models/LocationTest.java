package models;

import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class LocationTest {

    public Location createLocation(){
        return new Location("Zone A");
    }

    @Rule
    public DatabaseRule database = new DatabaseRule();

    @Test
    public void location_instantiatesCorrectlyWithName_true() {
        Location testLocation = createLocation();
        assertEquals(true, testLocation instanceof Location);
        assertEquals("Zone A", testLocation.getName());
    }

    @Test
    public void equals_ReturnsTrueIfNamesAreSame_true() {
        Location testLocation = createLocation();
        Location anotherLocation = createLocation();
        assertEquals(testLocation, anotherLocation);
    }

}
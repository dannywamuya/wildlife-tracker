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

    @Test
    public void save_SuccessfullyAddsLocationToDatabaseList() {
        Location testLocation =  createLocation();
        testLocation.save();
        assertTrue(Location.getAll().get(0).equals(testLocation));
    }

    @Test
    public void save_assignsIdToLocation() {
        Location testLocation = createLocation();
        testLocation.save();
        Location savedLocation = Location.getAll().get(0);
        assertEquals(testLocation.getId(), savedLocation.getId());
    }

    @Test
    public void all_returnsAllInstancesOfLocation_true() {
        Location firstLocation = createLocation();
        firstLocation.save();
        Location secondLocation = new Location("Zone B");
        secondLocation.save();
        assertTrue(Location.getAll().get(0).equals(firstLocation));
        assertTrue(Location.getAll().get(1).equals(secondLocation));
        assertEquals(2, Location.getAll().size());
    }

    @Test
    public void find_returnsLocationWithSameId_secondLocation() {
        Location firstLocation = createLocation();
        firstLocation.save();
        Location secondLocation = new Location("Zone B");
        secondLocation.save();
        assertEquals(Location.findById(secondLocation.getId()), secondLocation);
    }

    @Test
    public void update_changesExistingEndangeredLocation_ZoneB(){
        Location testLocation = createLocation();
        String oldLocation = testLocation.getName();
        testLocation.save();
        Location.update(testLocation.getId(), "Zone B");
        int sameId = testLocation.getId();
        assertEquals(sameId, Location.findById(testLocation.getId()).getId());
        assertEquals("Zone B", Location.findById(testLocation.getId()).getName());
        assertNotEquals(oldLocation, Location.findById(testLocation.getId()).getName());
    }

    @Test
    public void deleteLocation_removesLocationFromDatabase(){
        Location testLocation = createLocation();
        testLocation.save();
        Location otherLocation = createLocation();
        otherLocation.save();
        otherLocation.delete();
        assertEquals(1,Location.getAll().size());
    }
}
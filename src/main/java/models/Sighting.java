package models;

import java.util.Objects;

public class Sighting {
    private int id;
    private int animal_id;
    private int ranger_id;
    private int location_id;
    private int createdAt;

    public Sighting(int animal_id, int ranger_id, int location_id){
        this.animal_id = animal_id;
        this.ranger_id = ranger_id;
        this.location_id = location_id;
    }

    public int getId() { return id; }

    public int getAnimal_id() { return animal_id; }

    public int getRanger_id() { return ranger_id; }

    public int getLocation_id() { return location_id; }

    public int getCreatedAt() { return createdAt; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sighting sighting = (Sighting) o;
        return id == sighting.id &&
                animal_id == sighting.animal_id &&
                ranger_id == sighting.ranger_id &&
                location_id == sighting.location_id &&
                createdAt == sighting.createdAt;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, animal_id, ranger_id, location_id, createdAt);
    }
}

package models;

import org.sql2o.Connection;

import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

public class Sighting {
    private int id;
    private int animal_id;
    private int ranger_id;
    private int location_id;
    private Timestamp created_at;

    public Sighting(int animal_id, int ranger_id, int location_id){
        this.animal_id = animal_id;
        this.ranger_id = ranger_id;
        this.location_id = location_id;
    }

    public static List<Sighting> getAll() {
        String sql = "SELECT * FROM sightings;";
        try(Connection con = DB.sql2o.open()) {
            return con.createQuery(sql)
                    .throwOnMappingFailure(false)
                    .executeAndFetch(Sighting.class);
        }
    }

    public static Sighting findById(int id) {
        try(Connection con = DB.sql2o.open()) {
            String sql = "SELECT * FROM sightings WHERE id = :id";
            return con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Sighting.class);
        }
    }

    public void save() {
        try(Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO sightings (animal_id, ranger_id, location_id, created_at) VALUES (:animal_id, :ranger_id, :location_id, now())";
            this.id = (int) con.createQuery(sql, true)
                    .addParameter("animal_id", this.animal_id)
                    .addParameter("ranger_id", this.ranger_id)
                    .addParameter("location_id", this.location_id)
                    .executeUpdate()
                    .getKey();
        }
    }

    public int getId() { return id; }

    public int getAnimal_id() { return animal_id; }

    public int getRanger_id() { return ranger_id; }

    public int getLocation_id() { return location_id; }

    public Timestamp getCreated_At() { return created_at; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sighting sighting = (Sighting) o;
        return getId() == sighting.getId() &&
                getAnimal_id() == sighting.getAnimal_id() &&
                getRanger_id() == sighting.getRanger_id() &&
                getLocation_id() == sighting.getLocation_id();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getAnimal_id(), getRanger_id(), getLocation_id());
    }

}

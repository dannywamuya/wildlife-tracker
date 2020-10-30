package models;

import org.sql2o.Connection;

import java.util.List;

public class Endangered extends WildLife {
    public static final String animalType = "Endangered";

    public Endangered(String name, String health, String age){
        this.name = name;
        this.health = health;
        this.age = age;
        this.type = animalType;
    }

    public static List<Endangered> getAll() {
        String sql = "SELECT * FROM animals WHERE type = 'Endangered';";
        try(Connection con = DB.sql2o.open()) {
            return con.createQuery(sql)
                    .throwOnMappingFailure(false)
                    .executeAndFetch(Endangered.class);
        }
    }

    public void save() {
        try(Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO animals (name, type, health, age) VALUES (:name, :type, :health, :age)";
            this.id = (int) con.createQuery(sql, true)
                    .addParameter("name", this.name)
                    .addParameter("type", this.type)
                    .addParameter("health", this.health)
                    .addParameter("age", this.age)
                    .throwOnMappingFailure(false)
                    .executeUpdate()
                    .getKey();
        }
    }

}

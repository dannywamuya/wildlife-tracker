package models;

import java.util.Objects;

public class Endangered extends WildLife{

    public String health;
    public String age;
    public static final String animalType = "Endangered";

    public Endangered(String name, String health, String age){
        this.name = name;
        this.health = health;
        this.age = age;
        this.type = animalType;
    }

    @Override
    public String getHealth() {
        return health;
    }

    @Override
    public String getAge() {
        return age;
    }

    public static String getAnimalType() {
        return animalType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Endangered that = (Endangered) o;
        return Objects.equals(getHealth(), that.getHealth()) &&
                Objects.equals(getAge(), that.getAge());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getHealth(), getAge());
    }
}

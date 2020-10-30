package models;

public class Animal extends WildLife {
    public static final String animalType = "Non-Endangered";

    public Animal(String name){
        this.name = name;
        this.type = animalType;
    }
}

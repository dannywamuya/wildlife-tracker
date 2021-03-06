package models;

import org.sql2o.Connection;

import java.util.Objects;

public class WildLife {
    public int id;
    public String name;
    public String age;
    public String health;
    public String type;

    public void delete() {
        try(Connection con = DB.sql2o.open()) {
            String sql = "DELETE FROM animals WHERE id = :id;";
            con.createQuery(sql)
                    .addParameter("id", this.id)
                    .executeUpdate();
        }
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public String getHealth() {
        return health;
    }

    public String getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WildLife wildLife = (WildLife) o;
        return Objects.equals(getId(), wildLife.getId()) &&
                Objects.equals(getName(), wildLife.getName()) &&
                Objects.equals(getAge(), wildLife.getAge()) &&
                Objects.equals(getHealth(), wildLife.getHealth()) &&
                Objects.equals(getType(), wildLife.getType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getAge(), getHealth(), getType());
    }
}

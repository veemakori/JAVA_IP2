package org.safmoring.dao;

import org.sql2o.Connection;
import org.sql2o.Sql2o;

import org.safmoring.model.Hero;

import java.util.ArrayList;
import java.util.List;

public class Hero_Dao {
    private final Sql2o sql2o;

    public Hero_Dao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    public void addHero(Hero hero) {
        try (Connection connection = sql2o.open()) {
            String query = "INSERT INTO heroes (name, age, power, weakness) VALUES (:name, :age, :power, :weakness)";
            connection.createQuery(query)
                    .addParameter("name", hero.getName())
                    .addParameter("age", hero.getAge())
                    .addParameter("power", hero.getPower())
                    .addParameter("weakness", hero.getWeakness())
                    .executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Hero> getAllHeroes() {
        List<Hero> heroes = new ArrayList<>();
        try (Connection connection = sql2o.open()) {
            String query = "SELECT * FROM heroes";
            heroes = connection.createQuery(query).executeAndFetch(Hero.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return heroes;
    }

    public void updateHero(Hero hero) {
        try (Connection connection = sql2o.open()) {
            String query = "UPDATE heroes SET name = :name, age = :age, power = :power, weakness = :weakness WHERE id = :id";
            connection.createQuery(query)
                    .addParameter("name", hero.getName())
                    .addParameter("age", hero.getAge())
                    .addParameter("power", hero.getPower())
                    .addParameter("weakness", hero.getWeakness())
                    .addParameter("id", hero.getId())
                    .executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteHero(int id) {
        try (Connection connection = sql2o.open()) {
            String query = "DELETE FROM heroes WHERE id = :id";
            connection.createQuery(query)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

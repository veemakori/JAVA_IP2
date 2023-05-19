package org.safmoring.dao;

import org.sql2o.Connection;

public class Hero_Dao {
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
}

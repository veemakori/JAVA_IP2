package org.safmoring.dao;

import org.safmoring.model.Squad;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

public class Squad_Dao {
    private final Sql2o sql2o;

    public Squad_Dao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    public void addSquad(Squad squad) {
        String sql = "INSERT INTO squads (name, max_size, cause) VALUES (:name, :maxSize, :cause)";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("name", squad.getName())
                    .addParameter("maxSize", squad.getMaxSize())
                    .addParameter("cause", squad.getCause())
                    .executeUpdate();
        }
    }

    public List<Squad> getAllSquads() {
        String sql = "SELECT * FROM squads";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .executeAndFetch(Squad.class);
        }
    }
}

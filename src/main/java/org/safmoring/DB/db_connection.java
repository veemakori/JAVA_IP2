package org.safmoring.DB;

import org.sql2o.Sql2o;

public class db_connection {
    String url;
    String username;
    String password;
    private Sql2o sql2o;

    public db_connection(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public void init() {
        sql2o = new Sql2o(url, username, password);
    }

    public Sql2o getSql2o() {
        return sql2o;
    }
}

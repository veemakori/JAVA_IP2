package org.safmoring.controllers;

import spark.Request;
import spark.Response;
import spark.Route;
import org.safmoring.dao.Hero_Dao;
import org.safmoring.model.Hero;
public class Hero_controller {
    private final Hero_Dao heroDao;
    public Hero_controller(Hero_Dao heroDao) {
        this.heroDao = heroDao;
    }
    public Route addHero() {
        return (Request req, Response res) -> {
            String name = req.queryParams("name");
            int age = Integer.parseInt(req.queryParams("age"));
            String power = req.queryParams("power");
            String weakness = req.queryParams("weakness");

            Hero hero = new Hero(name, age, power, weakness);
            heroDao.addHero(hero);

            res.status(201);
            return "Hero added successfully";
        };
    }
}
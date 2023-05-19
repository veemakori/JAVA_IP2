package org.safmoring.controllers;

import spark.Request;
import spark.Response;
import spark.Route;

public class Hero_controller {

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
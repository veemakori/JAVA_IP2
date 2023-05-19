package org.safmoring.controllers;

import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.get;

public class Squad_controller {
    private final SquadDao squadDao;
    private final HeroDao heroDao;

    public Squad_controller(SquadDao squadDao, HeroDao heroDao) {
        this.squadDao = squadDao;
        this.heroDao = heroDao;
    }

    public void setupRoutes() {
        // Home page route
        get("/", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("squads", squadDao.getAllSquads());
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());
    }

}

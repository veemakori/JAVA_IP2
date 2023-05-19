package org.safmoring.controllers;

import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.get;
import org.safmoring.dao.Hero_Dao;
import org.safmoring.dao.Squad_Dao;
import org.safmoring.model.Squad;
public class Squad_controller {
    private final Squad_Dao squadDao;
    private final Hero_Dao heroDao;

    public Squad_controller(Squad_Dao squadDao, Hero_Dao heroDao) {
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

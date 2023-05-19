package org.safmoring;
import org.safmoring.dao.Hero_Dao;
import org.safmoring.dao.Squad_Dao;
import org.safmoring.model.Hero;
import org.safmoring.model.Squad;
import org.safmoring.DB.db_connection;

import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.staticFiles;

public class Main {

    public static void main(String[] args) {
        staticFiles.location("/public");

        // Set up the Handlebars template engine
        HandlebarsTemplateEngine templateEngine = new HandlebarsTemplateEngine();

        // Set up the database connector
        db_connection databaseConnector = new db_connection("jdbc:postgresql://localhost:5432/superhero_recruitment", "postgres", "Nyangau92");
        databaseConnector.init();

        // Set up the HeroDao and SquadDao
        Hero_Dao heroDao = new Hero_Dao(databaseConnector.getSql2o());
//        Squad_Dao squadDao = new Squad_Dao(databaseConnector.getSql2o());

        // Home page route
        get("/", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("heroes", heroDao.getAllHeroes());
//            model.put("squads", squadDao.getAllSquads());
            return new ModelAndView(model, "index.hbs");
        }, templateEngine);

        get("/new_hero", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "heroes.hbs");
        }, templateEngine);
    }
}
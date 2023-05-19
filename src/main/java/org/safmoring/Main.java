package org.safmoring;

import spark.template.handlebars.HandlebarsTemplateEngine;

public class Main {
    staticFiles.location("/public");

    // Set up the Handlebars template engine
    HandlebarsTemplateEngine templateEngine = new HandlebarsTemplateEngine();

    // Set up the database connector
    DatabaseConnector databaseConnector = new DatabaseConnector("jdbc:postgresql://localhost:5432/superhero_recruitment", "postgres", "Nyangau92");
        databaseConnector.init();

    // Set up the HeroDao and SquadDao
    HeroDao heroDao = new HeroDao(databaseConnector.getSql2o());
    SquadDao squadDao = new SquadDao(databaseConnector.getSql2o());
    }
}
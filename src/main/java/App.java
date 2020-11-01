import models.Animal;
import models.Endangered;
import models.WildLife;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");

        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model,"index.hbs");
        }, new HandlebarsTemplateEngine());

        //get: form to create a sighting
        get("/sightings/new", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model,"sighting-form.hbs");
        }, new HandlebarsTemplateEngine());

        //post: process new sighting form
        post("/sightings/new", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            String eName = request.queryParams("eName");
            String eAge = request.queryParams("eAge");
            String eHealth = request.queryParams("eHealth");

            Endangered newEndangered = new Endangered(eName, eHealth, eAge);
            if (eName != null && eAge != null && eHealth != null){
                newEndangered.save();
            }

            String name = request.queryParams("name");

            Animal newAnimal = new Animal(name);
            if (name != null){
                newAnimal.save();
            }

            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());

    }
}

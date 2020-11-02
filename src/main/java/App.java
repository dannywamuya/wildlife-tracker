import models.*;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        ProcessBuilder process = new ProcessBuilder();
        Integer port;
        if (process.environment().get("PORT") != null) {
            port = Integer.parseInt(process.environment().get("PORT"));
        } else {
            port = 4567;
        }
        port(port);

        staticFileLocation("/public");

        //get: homepage
        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model,"index.hbs");
        }, new HandlebarsTemplateEngine());

        //get: form to create a sighting
        get("/sightings/new", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            List<Ranger> rangers = Ranger.getAll();
            model.put("rangers", rangers);
            return new ModelAndView(model,"sighting-form.hbs");
        }, new HandlebarsTemplateEngine());

        //post: process new sighting form
        post("/sightings/new", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();

            //endangered animal
            String eName = request.queryParams("eName");
            String eAge = request.queryParams("eAge");
            String eHealth = request.queryParams("eHealth");

            Endangered newEndangered = new Endangered(eName, eHealth, eAge);
            if (eName != null && eAge != null && eHealth != null){
                newEndangered.save();

                //location
                String lName = request.queryParams("lName");

                Location newLocation =  new Location(lName);
                if (lName != null){
                    newLocation.save();
                }

                //sighting
                int animalId = newEndangered.getId();
                int rangerId = Integer.parseInt(request.queryParams("rangerId"));
                int locationId = newLocation.getId();

                Sighting newSighting = new Sighting(animalId, rangerId, locationId);
                newSighting.save();
            }

            //thriving animal
            String name = request.queryParams("name");

            Animal newAnimal = new Animal(name);
            if (name != null){
                newAnimal.save();

                //location
                String lName = request.queryParams("lName");

                Location newLocation =  new Location(lName);
                if (lName != null){
                    newLocation.save();
                }

                //sighting
                int animalId = newAnimal.getId();
                int rangerId = Integer.parseInt(request.queryParams("rangerId"));
                int locationId = newLocation.getId();

                Sighting newSighting = new Sighting(animalId, rangerId, locationId);
                newSighting.save();
            }

            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());

        //get: all animals
        get("/animals", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            List<Animal> allThriving = Animal.getAll();
            List<Endangered> allEndangered = Endangered.getAll();
            model.put("thriving", allThriving);
            model.put("endangered", allEndangered);
            return new ModelAndView(model, "animals.hbs");
        }, new HandlebarsTemplateEngine());

        //get: all sightings
        get("/sightings", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            List<Sighting> allSightings = Sighting.getAll();

            for(int i = 0; i < allSightings.size(); i++){
            Sighting j = allSightings.get(i);
            int sightingId = j.getId();
            Timestamp created_at = Sighting.findById(sightingId).getCreated_At();
            model.put("created_at", created_at);
            int animal_id = Sighting.findById(sightingId).getAnimal_id();
            String animalName =  Animal.findById(animal_id).getName();
            model.put("animalName", animalName);
            }

            model.put("sightings", allSightings);
            return new ModelAndView(model,"sightings.hbs");
        }, new HandlebarsTemplateEngine());

        //get: show a form to create a new ranger
        get("/rangers/new", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "ranger-form.hbs"); //new
        }, new HandlebarsTemplateEngine());

        //post: process a new ranger form
        post("/rangers/new", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();

            //ranger
            String rName = request.queryParams("rName");
            Ranger newRanger = new Ranger(rName);
            if (rName != null){
                newRanger.save();
            }

            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());


    }
}

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");
        String layout = "templates/layout.vtl";

        get("/" ,(request, response) -> {
           Map<String,Object> model = new HashMap<String,Object>();
            model.put("template", "templates/index.vtl");
           return  new ModelAndView(model, layout);
        },new VelocityTemplateEngine());


        get("/hero", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("template","templates/heroform.vtl");
            return new ModelAndView(model,layout );
        }, new VelocityTemplateEngine());


        post("/done", (request, respsonse) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            ArrayList<Hero> hero =  request.session().attribute("hero");
            if (hero==null) {
                hero= new ArrayList<Hero>();
                request.session().attribute("hero",hero);
            }
            String inputtedHero = request.queryParams("hero");
            String inputtedAge = request.queryParams("age");
            int age = Integer.parseInt(inputtedAge);
            String inputtedPower = request.queryParams("power");
            String inputtedWeakness = request.queryParams("weakness");
            Hero herol = new Hero(inputtedHero,age,inputtedPower,inputtedWeakness);
            hero.add(herol);
            model.put("hero", hero);
            model.put("template", "templates/success.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());


               get("/squad", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("template","templates/squadform.vtl");
            return new ModelAndView(model,layout );
        }, new VelocityTemplateEngine());

        post("/squad", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            ArrayList<Squad> squad =  request.session().attribute("squad");
            if (squad==null) {
                squad= new ArrayList<Squad>();
                request.session().attribute("squad",squad);
            }
            String inputtedName = request.queryParams("name");
            String inputtedNumber = request.queryParams("number");
            int number = Integer.parseInt(inputtedNumber);
            String inputtedMission = request.queryParams("mission");

            Squad squads = new Squad(inputtedName,number,inputtedMission);
            squad.add(squads);
            model.put("squad", squad);
            model.put("template", "templates/squadform.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());



    }
}
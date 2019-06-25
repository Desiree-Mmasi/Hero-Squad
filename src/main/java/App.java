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
            String inputtedpower = request.queryParams("power");
            String inputtedweakness = request.queryParams("weakness");
            Hero herol = new Hero(inputtedHero,age,inputtedpower,inputtedweakness);
            hero.add(herol);
            request.session().attribute("hero", hero);
            model.put("hero", hero);
            model.put("template", "templates/success.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());


        get("/hero", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("template","templates/heroform.vtl");
            return new ModelAndView(model,layout );
        }, new VelocityTemplateEngine());


        get("/view", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("template","templates/hero.vtl");
            return new ModelAndView(model,layout );
        },new VelocityTemplateEngine());
    }
}
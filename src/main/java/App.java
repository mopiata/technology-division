import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import models.Department;
import models.Staff;

import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");

        get("/",(request, response) -> {
           Map<String,Object> model = new HashMap<String,Object>();
           ArrayList<Staff> staff = Staff.getmInstances();
           model.put("staff",staff);
           return new ModelAndView(model,"index.hbs");
        }, new HandlebarsTemplateEngine());

    }
}

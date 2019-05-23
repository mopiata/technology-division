import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import models.Department;
import models.Section;
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

        get("staff/new",(request, response) -> {
            Map<String, Object> model=new HashMap<String, Object>();
            return new ModelAndView(model,"staffForm.hbs");
        },new HandlebarsTemplateEngine());

        post("staff/new",(request, response) -> {
            Map<String, Object> model=new HashMap<String, Object>();

            String name=request.queryParams("staff-name");
            String stringEkNumber=request.queryParams("staff-number");
            int ekNumber=Integer.parseInt(stringEkNumber);
            String department=request.queryParams("department");
            String section=request.queryParams("section");
            String role=request.queryParams("role");
            String responsibilities=request.queryParams("responsibilities");

            Staff newStaff=new Staff(name,ekNumber,department,section,role,responsibilities);

            model.put("staff", newStaff);

            return new ModelAndView(model,"successStaff.hbs");
        }, new HandlebarsTemplateEngine());

        post("dept/new",(request, response) -> {
            Map<String, Object> model=new HashMap<String, Object>();

            String name=request.queryParams("dept-name");
            Department newDepartment=new Department(name);
            model.put("departments",newDepartment);
            return new ModelAndView(model,"successDept.hbs");
        }, new HandlebarsTemplateEngine());

        get("dept/new",(request, response) -> {
            Map<String, Object> model=new HashMap<String, Object>();
            ArrayList<Department> departments=Department.getmInstances();
            if(!departments.isEmpty()){
                System.out.println(departments.get(0).getName());
                model.put("dep",departments.get(0));
            }
            model.put("departments",departments);
            return new ModelAndView(model,"departmentForm.hbs");
        }, new HandlebarsTemplateEngine());



//        post("dept/new",(request, response) -> {
//            Map<String, Object> model=new HashMap<String, Object>();
//
//            String name=request.queryParams("dept-name");
//            Section section=new Section(request.queryParams("sections"));
//            int id=Department.getmInstances().size();
//            ArrayList<Section> sections=new ArrayList<Section>();
//
//            sections.add(section);
//
//            Department newDepartment=new Department(name);
//            return new ModelAndView(model,"successDept.hbs");
//        }, new HandlebarsTemplateEngine());
    }
}

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

        ProcessBuilder process=new ProcessBuilder();
        Integer port;
        if(process.environment().get("PORT")!=null){
            port=Integer.parseInt(process.environment().get("PORT"));
        }else{
            port=4567;
        }

        setPort(port);

        get("/",(request, response) -> {
           Map<String,Object> model = new HashMap<String,Object>();
           ArrayList<Staff> staff = Staff.getmInstances();
           model.put("staff",staff);
           return new ModelAndView(model,"index.hbs");
        }, new HandlebarsTemplateEngine());

        get("staff/new",(request, response) -> {
            Map<String, Object> model=new HashMap<String, Object>();
            ArrayList<Department> departments=Department.getmInstances();
            ArrayList<Section> sections=Section.getInstances();
            System.out.println(sections);

            model.put("departments", departments);
            model.put("sections", sections);

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
            model.put("departments",departments);
            return new ModelAndView(model,"departmentForm.hbs");
        }, new HandlebarsTemplateEngine());

        get("/dept/:id", (request, response) -> {
            Map<String, Object> model=new HashMap<>();

            int deptId=Integer.parseInt(request.params("id"));//pull id - must match route segment

            Department foundDepartment=Department.findById(deptId);//used to find department
            ArrayList<Section> sections = foundDepartment.getSections();

            model.put("department",foundDepartment);
            model.put("sections",sections);

            return new ModelAndView(model,"department-detail.hbs");
        }, new HandlebarsTemplateEngine());

        post("/dept/:id",(request, response) -> {
            Map<String, Object> model=new HashMap<String, Object>();

            String section=request.queryParams("section");
            Section newSection=new Section(section);

            ArrayList<Department> departments=Department.getmInstances();
            int deptId=Integer.parseInt(request.params("id"));

            Department foundDepartment=Department.findById(deptId);//used to find department
            foundDepartment.setSection(newSection);

            model.put("sections",newSection);

            return new ModelAndView(model,"successSection.hbs");
        }, new HandlebarsTemplateEngine());
    }
}

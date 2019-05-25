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
            ArrayList<Staff> staff=Staff.getmInstances();

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

        get("/staff/:id",(request, response) -> {
            Map<String, Object> model=new HashMap<>();
            int staffId=Integer.parseInt(request.params("id"));

            Staff foundStaff=Staff.findById(staffId);
            model.put("staff",foundStaff);

            return new ModelAndView(model,"staff-detail.hbs");
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

        get("/section/new", (request, response) -> {
            Map<String, Object> model=new HashMap<String, Object>();
            ArrayList<Department> departments=Department.getmInstances();
            model.put("departments",departments);
            return new ModelAndView(model,"sectionForm.hbs");
        }, new HandlebarsTemplateEngine());

        post("/section/new",(request, response) -> {
            Map<String, Object> model=new HashMap<String, Object>();

            String department=request.queryParams("department");
            String section=request.queryParams("section");
            ArrayList<Department> departments=Department.getmInstances();
            Section newSection=new Section(section);

            for(Department singleDepartment:departments){
                if(singleDepartment.getName().equals(department)){
                    singleDepartment.setSection(newSection);
                }
            }
            model.put("sections",newSection);

            return new ModelAndView(model,"successSection.hbs");
        }, new HandlebarsTemplateEngine());

        get("/section/:id",(request, response) -> {
            Map<String, Object> model=new HashMap<>();
            int sectionId=Integer.parseInt(request.params("id"));

            Section foundSection=Section.findById(sectionId);
            model.put("section",foundSection);

            return new ModelAndView(model,"section-detail.hbs");
        }, new HandlebarsTemplateEngine());

        //get: show a form to update a department
        get("/dept/:id/update",(request, response) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfDeptToEdit=Integer.parseInt(request.params("id"));

            Department editDepartment=Department.findById(idOfDeptToEdit);

            model.put("editDepartment", editDepartment);

            return new ModelAndView(model,"departmentForm.hbs");
        }, new HandlebarsTemplateEngine());

        post("/dept/:id/update",(request, response) -> {
            Map<String, Object> model = new HashMap<>();

            String newName=request.queryParams("dept-name");
            int idOfDeptToEdit=Integer.parseInt(request.params("id"));

            Department editDepartment=Department.findById(idOfDeptToEdit);
            editDepartment.update(newName);

            return new ModelAndView(model, "successDept.hbs");
        }, new HandlebarsTemplateEngine());

        //get: delete a department

        get("/dept/:id/delete", (request, response) -> {
            Map<String, Object> model=new HashMap<>();
            int idOfDeptToDelete=Integer.parseInt(request.params("id"));

            Department deleteDepartment=Department.findById(idOfDeptToDelete);

            deleteDepartment.deleteDepartment();

            return new ModelAndView(model,"deleteSuccess.hbs");
        }, new HandlebarsTemplateEngine());

        //get: show a form to update a section
        get("/section/:id/update",(request, response) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfSectionToEdit=Integer.parseInt(request.params("id"));

            Section editSection=Section.findById(idOfSectionToEdit);

            model.put("editSection", editSection);

            return new ModelAndView(model,"sectionForm.hbs");
        }, new HandlebarsTemplateEngine());

        post("/section/:id/update",(request, response) -> {
            Map<String, Object> model = new HashMap<>();

            String newName=request.queryParams("section");
            int idOfSectionToEdit=Integer.parseInt(request.params("id"));

            Section editSection=Section.findById(idOfSectionToEdit);
            editSection.update(newName);

            return new ModelAndView(model, "successSection.hbs");
        }, new HandlebarsTemplateEngine());

        //get: delete a section
        get("/section/:id/delete", (request, response) -> {
            Map<String, Object> model=new HashMap<>();
            int idOfSectionToDelete=Integer.parseInt(request.params("id"));

            Section deleteSection=Section.findById(idOfSectionToDelete);

            deleteSection.deleteSection();

            return new ModelAndView(model,"deleteSuccess.hbs");
        }, new HandlebarsTemplateEngine());

        //get: show a form to update a staff
        get("/staff/:id/update", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfStaffToEdit=Integer.parseInt(request.params("id"));

            Staff editStaff=Staff.findById(idOfStaffToEdit);
            ArrayList<Department> departments=Department.getmInstances();
            ArrayList<Section> sections=Section.getInstances();

            model.put("editStaff",editStaff);
            model.put("departments",departments);
            model.put("sections",sections);

            return new ModelAndView(model, "staffForm.hbs");
        }, new HandlebarsTemplateEngine());

        post("/staff/:id/update",(request, response) -> {
            Map<String, Object> model = new HashMap<>();

            String name=request.queryParams("staff-name");
            String stringEkNumber=request.queryParams("staff-number");
            int ekNumber=Integer.parseInt(stringEkNumber);
            String department=request.queryParams("department");
            String section=request.queryParams("section");
            String role=request.queryParams("role");
            String responsibilities=request.queryParams("responsibilities");
            int idOfStaffToEdit=Integer.parseInt(request.params("id"));

            Staff editStaff=Staff.findById(idOfStaffToEdit);

            editStaff.update(name,ekNumber,department,section,role,responsibilities);

            return new ModelAndView(model,"successStaff.hbs");
        },new HandlebarsTemplateEngine());

        //get: delete a staff
        get("/staff/:id/delete", (request, response) -> {
            Map<String, Object> model=new HashMap<>();
            int idOfStaffToDelete=Integer.parseInt(request.params("id"));

            Staff deleteStaff=Staff.findById(idOfStaffToDelete);

            deleteStaff.deleteStaff();

            return new ModelAndView(model,"deleteSuccess.hbs");
        }, new HandlebarsTemplateEngine());

    }
}

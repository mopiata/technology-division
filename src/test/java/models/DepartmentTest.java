package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class DepartmentTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
        Department.clearAllDepartments();
    }

    public Department addNewDepartment(){
        ArrayList<String> sections=new ArrayList<>();
        sections.add("Core Network Planning");
        sections.add("Radio Planning and Optimization");
        return new Department(1,"NPD",sections);
    }

    public Department addOtherDepartment(){
        ArrayList<String> sections=new ArrayList<>();
        sections.add("Digital Engineering");
        sections.add("CBS");
        return new Department(1,"Digital IT",sections);
    }

    @Test
    public void newDepartmentIsCorrectlyCreated_true() throws Exception{
        Department department=addNewDepartment();
        assertTrue(department instanceof Department);
    }

    @Test
    public void departmentInstantiatesCorrectly_true() throws Exception{
        Department department=addNewDepartment();
        assertEquals("NPD",department.getmDeptName());
    }

    @Test
    public void allDepartmentAreReturnedCorrectly_true() {
        Department department=addNewDepartment();
        Department otherDepartment=addOtherDepartment();

        assertEquals(2,Department.getmInstances().size());
    }

    @Test
    public void arrayContainsAllDepartment() {
        Department department=addNewDepartment();
        Department otherDepartment=addOtherDepartment();

        assertTrue(Department.getmInstances().contains(department));
        assertTrue(Department.getmInstances().contains(otherDepartment));
    }
}
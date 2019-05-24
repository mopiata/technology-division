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
        return new Department("NPD");
    }

    public Department addOtherDepartment(){
        return new Department("Digital IT");
    }

    @Test
    public void newDepartmentIsCorrectlyCreated_true() throws Exception{
        Department department=addNewDepartment();
        assertTrue(department instanceof Department);
    }

    @Test
    public void departmentInstantiatesCorrectly_true() throws Exception{
        Department department=addNewDepartment();
        assertEquals("NPD",department.getName());
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

    @Test
    public void idSetCorrectly_true() {
        Department department=addNewDepartment();
        Department otherDepartment=addOtherDepartment();

        assertEquals(2,otherDepartment.getId());
    }

    @Test
    public void setName_nameSettingWorksCorrectly_true() {
        Department department=addNewDepartment();

        department.setName("Security");

        assertEquals("Security",department.getName());
    }

    @Test
    public void setSection_createsSectionCorrectly_true() {
        Department department=addNewDepartment();
        ArrayList<Section> sections=new ArrayList<>();
        Section section=new Section("CNE");
        Section otherSection=new Section("RNO");

        sections.add(section);
        sections.add(otherSection);

        department.setSections(sections);

        assertEquals(sections,department.getSections());
    }

    @Test
    public void readSectionCorrectly_true() {
        Department department=addNewDepartment();
        ArrayList<Section> sections=new ArrayList<>();
        Section section=new Section("CNE");
        Section otherSection=new Section("RNO");

        sections.add(section);
        sections.add(otherSection);

        department.setSections(sections);

        assertEquals("CNE",department.getSections().get(0).getSection());
    }


}
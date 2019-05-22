package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StaffTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
        Staff.clearAllStaff();
    }

    public Staff addNewStaff(){
        return new Staff("Margaret Opiata",6454,"NPD","Core Network Planning",
                "PS Core Engineer","Plan for the data network");
    }

    public Staff addOtherStaff(){
        return new Staff("Kelvin Gikonyo",5554,"NPD","Core Network Planning",
                "PS Core Engineer","Plan for the data network");
    }

    @Test
    public void newStaffIsCorrectlyCreated_true() throws Exception{
        Staff staff=addNewStaff();
        assertTrue(staff instanceof Staff);
    }

    @Test
    public void staffInstantiatesCorrectly_true() throws Exception{
        Staff staff=addNewStaff();
        assertEquals("Margaret Opiata",staff.getmStaffName());
    }

    @Test
    public void allStaffAreReturnedCorrectly_true() {
        Staff staff=addNewStaff();
        Staff otherStaff=addOtherStaff();

        assertEquals(2,Staff.getmInstances().size());
    }

    @Test
    public void arrayContainsAllStaff() {
        Staff staff=addNewStaff();
        Staff otherStaff=addOtherStaff();

        assertTrue(Staff.getmInstances().contains(staff));
        assertTrue(Staff.getmInstances().contains(otherStaff));
    }

//    @Test
//    public void findReturnsCorrectStaff_int() {
//        Staff staff=addNewStaff();
//        assertEquals(6454,Staff.findById(staff.getmStaffNumber()).getmStaffNumber());
//    }

}
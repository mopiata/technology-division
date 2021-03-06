package models;

import java.util.ArrayList;

public class Staff {
    private int id;
    private String mStaffName;
    private int mStaffNumber;
    private String mRole;
    private String mResponsibilities;
    private String mDepartment;
    private String mSection;
    private static ArrayList<Staff> mInstances = new ArrayList<Staff>();

    public Staff(String name, int number, String department, String section,
                 String role, String responsibilities){
        this.mStaffName=name;
        this.mStaffNumber=number;
        this.mRole=role;
        this.mResponsibilities=responsibilities;
        this.mDepartment=department;
        this.mSection=section;
        this.mInstances.add(this);
        this.id=mInstances.size();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSection() {
        return mSection;
    }

    public void setmSection(String mSection) {
        this.mSection = mSection;
    }

    public String getName() {
        return mStaffName;
    }

    public void setmStaffName(String mStaffName) {
        this.mStaffName = mStaffName;
    }

    public int getNumber() {
        return mStaffNumber;
    }

    public void setmStaffNumber(int mStaffNumber) {
        this.mStaffNumber = mStaffNumber;
    }

    public String getRole() {
        return mRole;
    }

    public void setmRole(String mRole) {
        this.mRole = mRole;
    }

    public String getResponsibilities() {
        return mResponsibilities;
    }

    public void setmResponsibilities(String mResponsibilities) {
        this.mResponsibilities = mResponsibilities;
    }

    public String getDepartment() {
        return mDepartment;
    }

    public void setmDepartmentId(String mDepartment) {
        this.mDepartment = mDepartment;
    }

    public static ArrayList<Staff> getmInstances() {
        return mInstances;
    }

    public static void setmInstances(ArrayList<Staff> mInstances) {
        Staff.mInstances = mInstances;
    }

    public static void clearAllStaff(){
        mInstances.clear();
    }

    public static Staff findById(int id){
        return mInstances.get(id-1);
    }

    public void update(String name, int number, String department, String section,
                       String role, String responsibilities) {
        this.mStaffName=name;
        this.mStaffNumber=number;
        this.mRole=role;
        this.mResponsibilities=responsibilities;
        this.mDepartment=department;
        this.mSection=section;
    }

    public void deleteStaff(){
        mInstances.remove(id-1);
    }
}

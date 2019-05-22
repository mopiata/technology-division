package models;

import java.util.ArrayList;

public class Staff {
    private String mStaffName;
    private int mStaffNumber;
    private String mRole;
    private String mResponsibilities;
    private String mDepartment;
    private String mSection;
    private static ArrayList<Staff> mInstances = new ArrayList<Staff>();

    public Staff(String name, int id, String department, String section, String role, String responsibilities){
        this.mStaffName=name;
        this.mStaffNumber=id;
        this.mRole=role;
        this.mResponsibilities=responsibilities;
        this.mDepartment=department;
        this.mSection=section;
        this.mInstances.add(this);
    }

    public String getmStaffName() {
        return mStaffName;
    }

    public void setmStaffName(String mStaffName) {
        this.mStaffName = mStaffName;
    }

    public int getmStaffNumber() {
        return mStaffNumber;
    }

    public void setmStaffNumber(int mStaffNumber) {
        this.mStaffNumber = mStaffNumber;
    }

    public String getmRole() {
        return mRole;
    }

    public void setmRole(String mRole) {
        this.mRole = mRole;
    }

    public String getmResponsibilities() {
        return mResponsibilities;
    }

    public void setmResponsibilities(String mResponsibilities) {
        this.mResponsibilities = mResponsibilities;
    }

    public String getmDepartmentId() {
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
}

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

    public Staff(String name, int id, String department, String section,
                 String role, String responsibilities){
        this.mStaffName=name;
        this.mStaffNumber=id;
        this.mRole=role;
        this.mResponsibilities=responsibilities;
        this.mDepartment=department;
        this.mSection=section;
        this.mInstances.add(this);
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

//    public static Staff findById(int id){
//        return mInstances.get(id);
//    }

}

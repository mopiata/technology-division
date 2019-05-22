package models;


import java.util.ArrayList;
import java.util.List;

public class Department {
    private int mDeptId;
    private String mDeptName;
    private List<String> mSections=new ArrayList<String>();
    private static ArrayList<Department> mInstances = new ArrayList<Department>();

    public Department(int id, String name, ArrayList<String> sections){
        this.mDeptId=id;
        this.mDeptName=name;
        this.mSections=sections;
        this.mInstances.add(this);
    }

    public int getmDeptId() {
        return mDeptId;
    }

    public void setmDeptId(int mDeptId) {
        this.mDeptId = mDeptId;
    }

    public String getmDeptName() {
        return mDeptName;
    }

    public void setmDeptName(String mDeptName) {
        this.mDeptName = mDeptName;
    }

    public List<String> getmSections() {
        return mSections;
    }

    public void setmSections(List<String> mSections) {
        this.mSections = mSections;
    }

    public static ArrayList<Department> getmInstances() {
        return mInstances;
    }

    public static void setmInstances(ArrayList<Department> mInstances) {
        Department.mInstances = mInstances;
    }
}

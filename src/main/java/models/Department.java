package models;


import java.util.ArrayList;
import java.util.List;

public class Department {
    private int mDeptId;
    private String mDeptName;
    private ArrayList<Section> mSections=new ArrayList<Section>();
    private static ArrayList<Department> mInstances = new ArrayList<Department>();

    public Department(String name, ArrayList<Section> sections){
        this.mDeptName=name;
        this.mSections=sections;
        this.mInstances.add(this);
        this.mDeptId=mInstances.size();
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

    public ArrayList<Section> getmSections() {
        return mSections;
    }

    public void setmSections(ArrayList<Section> mSections) {
        this.mSections = mSections;
    }

    public static ArrayList<Department> getmInstances() {
        return mInstances;
    }

    public static void clearAllDepartments(){
        mInstances.clear();
    }

    public static Department findById(int id){
        return mInstances.get(id-1);
    }


}

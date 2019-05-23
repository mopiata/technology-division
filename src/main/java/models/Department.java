package models;


import java.util.ArrayList;
import java.util.List;

public class Department {
    private int mDeptId;
    private String mDeptName;
    private String sectionName;
    private Section section=new Section(sectionName);
    private static ArrayList<Section> mSections=new ArrayList<Section>();
    private static ArrayList<Department> mInstances = new ArrayList<Department>();

    public Department(String name){
        this.mDeptName=name;
        this.mSections.add(this.section);
        this.mInstances.add(this);
        this.mDeptId=mInstances.size();
    }

    public String getName(){
        return mDeptName;
    }

    public void setName(String mDeptName){
        this.mDeptName = mDeptName;
    }

    public static ArrayList<Section> getmSections() {
        return mSections;
    }

    public static void setmSections(ArrayList<Section> mSections) {
        Department.mSections = mSections;
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

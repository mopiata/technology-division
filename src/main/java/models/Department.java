package models;


import java.util.ArrayList;
import java.util.List;

public class Department {
    private int mDeptId;
    private String mDeptName;
    private String sectionName;
    private Section section=new Section(sectionName);
    private ArrayList<Section> mSections=new ArrayList<Section>();
    private static ArrayList<Department> mInstances = new ArrayList<Department>();

    public Department(String name){
        this.mDeptName=name;

        this.mInstances.add(this);
        this.mDeptId=mInstances.size();
    }

    public String getName(){
        return mDeptName;
    }

    public void setName(String mDeptName){
        this.mDeptName = mDeptName;
    }

    public int getId() {
        return mDeptId;
    }

    public void setId(int mDeptId) {
        this.mDeptId = mDeptId;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
        this.mSections.add(this.section);
    }

    public ArrayList<Section> getSections() {
        return mSections;
    }

    public void setSections(ArrayList<Section> mSections) {
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

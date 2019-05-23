package models;

import java.util.ArrayList;

public class Section {
    private int sectionId;
    private String sectionName;
    private static ArrayList<Section> instances=new ArrayList<Section>();

    public Section(String name){
        this.sectionName=name;
        this.sectionId=instances.size();
        this.instances.add(this);
    }

    public int getId() {
        return sectionId;
    }

    public void setSectionId(int sectionId) {
        this.sectionId = sectionId;
    }

    public String getSection() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public static ArrayList<Section> getInstances() {
        return instances;
    }

}

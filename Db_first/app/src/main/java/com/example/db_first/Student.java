package com.example.db_first;

public class Student {
    private int id;
    private String name;
    private String course;
    private int semester;

    public Student(){

    }
    public void setId(int id){
        this.id=id;
    }
    public int getId(){
        return id;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getName(){
        return name;
    }
    public void setCourse(String course){
        this.course=course;
    }
    public String getCourse(){
        return course;
    }
    public void setSemester(int semester){
        this.semester=semester;
    }
    public int getSemester(){
        return semester;
    }
}

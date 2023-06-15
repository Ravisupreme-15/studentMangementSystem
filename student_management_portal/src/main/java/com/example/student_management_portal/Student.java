package com.example.student_management_portal;

public class Student {

    private String name;
    private int age;
    private String course;
    private int admissionNo;

    public Student() {
    }

    public Student(String name, int age, String course, int admissionNo) {
        this.name = name;
        this.age = age;
        this.course = course;
        this.admissionNo = admissionNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public int getAdmissionNo() {
        return admissionNo;
    }

    public void setAdmissionNo(int admissionNo) {
        this.admissionNo = admissionNo;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", course='" + course + '\'' +
                ", admissionNo=" + admissionNo +
                '}';
    }
}

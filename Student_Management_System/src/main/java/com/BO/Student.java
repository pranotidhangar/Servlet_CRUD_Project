package com.BO;

public class Student {
    private int id;
    private String name;
    private int age;
    private String studentClass;
    private String address;

    public Student(int id, String name, int age, String studentClass, String address) {
    	super();
        this.id = id;
        this.name = name;
        this.age = age;
        this.studentClass = studentClass;
        this.address = address;
    }

    public Student(String name, int age, String studentClass, String address) {
    	super();
        this.name = name;
        this.age = age;
        this.studentClass = studentClass;
        this.address = address;
    }

    public Student() {
    	super();
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
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

    public String getStudentClass() {
        return studentClass;
    }
    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass;
    }

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
}

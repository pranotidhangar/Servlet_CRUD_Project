package com.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.BO.Student;

public class StudentData {
    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/servlet_data", "root", "Prante@02"
            );
        } catch(Exception e) {
            System.out.println(e);
        }
        return con;
    }

    public static int insertStudent(Student s) {
        int status = 0;
        try {
            Connection con = StudentData.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO students(Name, Age, Student_class, Address) VALUES (?, ?, ?, ?)"
            );
            ps.setString(1, s.getName());
            ps.setInt(2, s.getAge());
            ps.setString(3, s.getStudentClass());
            ps.setString(4, s.getAddress());
            System.out.println("Inserting student with class: " + s.getStudentClass());
            status = ps.executeUpdate();
        } catch(Exception e) {
            System.out.println(e);
        }
        return status;
    }

    public static List<Student> viewStudent() {
        List<Student> list = new ArrayList<>();
        try {
            Connection con = StudentData.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM students");
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                Student s1 = new Student();
                s1.setId(rs.getInt("Id"));
                s1.setName(rs.getString("Name"));
                s1.setAge(rs.getInt("Age"));
                s1.setStudentClass(rs.getString("Student_class"));
                s1.setAddress(rs.getString("Address"));
                list.add(s1);
            }
        } catch(Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public static Student searchStudent(String name) {
        Student s = null;
        try {
            Connection con = StudentData.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM students WHERE Name = ?");
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                s = new Student();
                s.setId(rs.getInt("Id"));
                s.setName(rs.getString("Name"));
                s.setAge(rs.getInt("Age"));
                s.setStudentClass(rs.getString("Student_class"));
                s.setAddress(rs.getString("Address"));
            }
        } catch(Exception e) {
            System.out.println(e);
        }
        return s;
    }

    public static Student getById(int id) {
        Student e = null;
        try {
            Connection con = StudentData.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM students WHERE Id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                e = new Student();
                e.setId(rs.getInt("Id"));
                e.setName(rs.getString("Name"));
                e.setAge(rs.getInt("Age"));
                e.setStudentClass(rs.getString("Student_class"));
                e.setAddress(rs.getString("Address"));
            }
            con.close();
        } catch (Exception e4) {
            System.out.println(e4);
        }
        return e;
    }

    public static int updateStudent(Student s) {
        int status = 0;
        try {
            Connection con = StudentData.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "UPDATE students SET Name=?, Age=?, Student_class=?, Address=? WHERE Id=?"
            );
            ps.setString(1, s.getName());
            ps.setInt(2, s.getAge());
            ps.setString(3, s.getStudentClass());
            ps.setString(4, s.getAddress());
            ps.setInt(5, s.getId());
            System.out.println("Debug: Executing update with class: " + s.getStudentClass());
            status = ps.executeUpdate();
        } catch(Exception e) {
        	System.out.println("Error in updateStudent: " + e);
        }
        return status;
    }

    public static int DeleteData(int id) {
        int status = 0;
        try {
            Connection con = StudentData.getConnection();
            PreparedStatement ps = con.prepareStatement("DELETE FROM students WHERE Id = ?");
            ps.setInt(1, id);
            status = ps.executeUpdate();
        } catch(Exception e6) {
            System.out.println(e6);
        }
        return status;
    }
}

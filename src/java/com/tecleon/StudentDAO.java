package com.tecleon;

import java.util.*;
import java.sql.*;

public class StudentDAO {

    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tecleon", "java", "J4v4pass");
        } catch (Exception e) {
            System.out.println("Failed to connect"+e);
        }
        return con;
    }

    public static int save(Student s) {
        int status = 0;
        try {
            Connection con = StudentDAO.getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "insert into student(controlNum, nameStudent,carrer,semester,email) values (?,?,?,?,?)");
            ps.setInt(1, s.getControlNum());
            ps.setString(2, s.getStudentName());
            ps.setString(3, s.getCarrer());
            ps.setInt(4, s.getSemester());
            ps.setString(5, s.getEmail());
            

            status = ps.executeUpdate();

            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return status;
    }

    public static int update(Student s) {
        int status = 0;
        try {
            Connection con = StudentDAO.getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "update student set nameStudent=?,email=?,carrer=?, semester=? where controlNum=?");
            ps.setString(1, s.getStudentName());
            ps.setString(2, s.getCarrer());
            ps.setString(3, s.getEmail());
            ps.setInt(4, s.getSemester());
            ps.setInt(5, s.getControlNum());
            status = ps.executeUpdate();

            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return status;
    }

    public static int delete(int controlNum) {
        int status = 0;
        try {
            Connection con = StudentDAO.getConnection();
            PreparedStatement ps = con.prepareStatement("delete from student where controlNum=?");
            ps.setInt(1, controlNum);
            status = ps.executeUpdate();

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }

    public static Student getStudentById(int controlNum) {
        Student s = new Student();

        try {
            Connection con = StudentDAO.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from student where controlNum=?");
            ps.setInt(1, controlNum);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                s.setControlNum(rs.getInt(1));
                s.setStudentName(rs.getString(2));
                s.setCarrer(rs.getString(3));
                s.setSemester(rs.getInt(4));
                s.setEmail(rs.getString(5));
                
            }
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return s;
    }

    public static List<Student> getAllStudents
        () {
        List<Student> list = new ArrayList<Student>();

        try {
            Connection con = StudentDAO.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from student");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Student e = new Student();
                e.setControlNum(rs.getInt(1));
                e.setStudentName(rs.getString(2));
                e.setCarrer(rs.getString(3));
                e.setSemester(rs.getInt(4));
                e.setEmail(rs.getString(5));
                
                list.add(e);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}

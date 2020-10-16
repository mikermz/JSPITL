package com.tecleon;

import java.util.*;
import java.sql.*;

public class UserDAO {

    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tecleon", "java", "J4v4pass");
        } catch (Exception e) {
            System.out.println("Failed to connect" + e);
        }
        return con;
    }

    public String login(String user, String pass) {
        String type="";

        try {
            Connection con = UserDAO.getConnection();
            PreparedStatement ps = con.prepareStatement("select typeUser from user where userName=? and userPassword=?");
            ps.setString(1, user);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                type=rs.getString(1);
            }
            System.out.println(type);
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return type;
    }

    public static int saveUser(User u) {
        int status = 0;
        try {
            Connection con = UserDAO.getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "insert into user(userName, userPassword,typeUser) values (?,?,?)");
            ps.setString(1, u.getUserName());
            ps.setString(2, u.getUserPassword());
            if (u.getType() != "") {
                ps.setString(3, u.getType());
            } else {
                ps.setString(3, "user");
            }

            status = ps.executeUpdate();

            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return status;
    }

    public static int update(User u) {
        int status = 0;
        try {
            Connection con = UserDAO.getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "update user set userName=?,userPassword=? where userId=?");
            ps.setString(1, u.getUserName());
            ps.setString(2, u.getUserPassword());
            ps.setInt(3, u.getId());

            status = ps.executeUpdate();

            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return status;
    }

    public static int delete(int userId) {
        int status = 0;
        try {
            Connection con = StudentDAO.getConnection();
            PreparedStatement ps = con.prepareStatement("delete from user where userId=?");
            ps.setInt(1, userId);
            status = ps.executeUpdate();

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }

    public static User getUserById(int userId) {
        User u = new User();

        try {
            Connection con = UserDAO.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from user where userId=?");
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                u.setId(rs.getInt(1));
                u.setUserName(rs.getString(2));
                u.setUserPassword(rs.getString(3));
                u.setType(rs.getString(3));

            }
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return u;
    }

    public static List<User> getAllUsers() {
        List<User> list = new ArrayList<User>();

        try {
            Connection con = UserDAO.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from user");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                User e = new User();
                e.setId(rs.getInt(1));
                e.setUserName(rs.getString(2));
                e.setUserPassword(rs.getString(3));
                e.setType(rs.getString(4));

                list.add(e);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public ResultSet query(String sql) {
        ResultSet resultado;
        try {
            Statement sentencia = getConnection().createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            resultado = sentencia.executeQuery(sql);
        } catch (SQLException e) {
            System.out.println("The query couldn´t be done");
            e.printStackTrace();
            return null;
        }
        return resultado;
    }
}

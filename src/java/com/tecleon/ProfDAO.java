package com.tecleon;

import java.util.*;
import java.sql.*;

public class ProfDAO {

    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tecleon", "root", "mypass");
        } catch (Exception e) {
            System.out.println("Failed to connect" + e);
        }
        return con;
    }

    public String login(String user, String pass) {
        String puesto = "";

        try {
            Connection con = ProfDAO.getConnection();
            PreparedStatement ps = con.prepareStatement("select puesto from profe where emailProf=? and passProf=?");
            ps.setString(1, user);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                puesto = rs.getString(1);
            }
            System.out.println(puesto);
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return puesto;
    }

    public static int saveProf(Prof pp) {
        int status = 0;
        try {
            Connection con = ProfDAO.getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "insert into profe(nombreProf, apellidoProf,emailProf,passProf,puesto) values (?,?,?,?,?)");
            ps.setString(1, pp.getNombreProf());
            ps.setString(2, pp.getApellidoProf());
            ps.setString(3, pp.getEmailProf());
            ps.setString(4, pp.getPassProf());
            ps.setString(5, pp.getPuesto());
            

            status = ps.executeUpdate();

            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return status;
    }

    public static int update(Prof pp) {
        int status = 0;
        try {
            Connection con = UserDAO.getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "update user set nombreProf=?,apellidoProf=?,passProf=?,puesto=? where email=?");
            ps.setString(1, pp.getNombreProf());
            ps.setString(2, pp.getApellidoProf());
            ps.setString(3, pp.getPassProf());
            ps.setString(4, pp.getPuesto());
            ps.setString(5, pp.getEmailProf());
            status = ps.executeUpdate();

            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return status;
    }

    public static int delete(String email) {
        int status = 0;
        try {
            Connection con = StudentDAO.getConnection();
            PreparedStatement ps = con.prepareStatement("delete from profe where email=?");
            ps.setString(1, email);
            status = ps.executeUpdate();

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }

    public static Prof getProfByEmail(String email) {
        Prof pp = new Prof();

        try {
            Connection con = ProfDAO.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from profe where emailProf=?");
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                pp.setIdProf(rs.getInt("idProf"));
                pp.setNombreProf(rs.getString("nombreProf"));
                pp.setApellidoProf(rs.getString("apellidoProf"));
                pp.setEmailProf(rs.getString("emailProf"));
                pp.setPassProf(rs.getString("passProf"));
                pp.setPuesto(rs.getString("puesto"));
            }
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return pp;
    }

    public static List<Prof> getAllProf() {
        List<Prof> list = new ArrayList<Prof>();

        try {
            Connection con = ProfDAO.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from profe");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Prof pp = new Prof();
                pp.setIdProf(rs.getInt("idProf"));
                pp.setNombreProf(rs.getString("nombreProf"));
                pp.setApellidoProf(rs.getString("apellidoProf"));
                pp.setEmailProf(rs.getString("emailProf"));
                pp.setPassProf(rs.getString("passProf"));
                pp.setPuesto(rs.getString("puesto"));

                list.add(pp);
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

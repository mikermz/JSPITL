package com.tecleon;

import java.util.*;
import java.sql.*;

public class ClaseDAO {

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


    public static int saveClase(Clase pp) {
        int status = 0;
        try {
            Connection con = ClaseDAO.getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "insert into clase(idClase, idProf, idMateria,grupo, numAlumnos) values (?,?,?,?,?)");
           ps.setString(1, pp.getIdClase());
            ps.setInt(2, pp.getIdProfe());
            ps.setString(3, pp.getIdMateria());
            ps.setString(4, pp.getGrupo());
            ps.setInt(5, pp.getNumAlumnos());

            status = ps.executeUpdate();

            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return status;
    }

    public static int update(Clase pp) {
        int status = 0;
        try {
            Connection con = ClaseDAO.getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "update clase set idProfe=?,idMateria=?,grupo=? where idClase=?");
             ps.setInt(1, pp.getIdProfe());
            ps.setString(2, pp.getIdMateria());
            ps.setInt(3, pp.getNumAlumnos());
            ps.setString(4, pp.getIdClase());
            status = ps.executeUpdate();

            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return status;
    }

    public static int delete(String idClase) {
        int status = 0;
        try {
            Connection con = ClaseDAO.getConnection();
            PreparedStatement ps = con.prepareStatement("delete from clase where idClase=?");
            ps.setString(1, idClase);
            status = ps.executeUpdate();

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }

    public static Clase getClasebyId (int id) {
        Clase pp = new Clase();

        try {
            Connection con = ClaseDAO.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from clase where idClase=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                pp.setIdClase(rs.getString("idCLase"));
                pp.setIdProfe(rs.getInt("idProf"));
                pp.setIdMateria(rs.getString("idMateria"));
                pp.setGrupo(rs.getString("grupo"));
                pp.setNumAlumnos(rs.getInt("numAlumnos"));
            }
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return pp;
    }

    public static List<Clase> getAllClases() {
        List<Clase> list = new ArrayList<Clase>();

        try {
            Connection con = ClaseDAO.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from Clase");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Clase pp = new Clase();
                pp.setIdClase(rs.getString("idCLase"));
                pp.setIdProfe(rs.getInt("idProf"));
                pp.setIdMateria(rs.getString("idMateria"));
                pp.setGrupo(rs.getString("grupo"));
                pp.setNumAlumnos(rs.getInt("numAlumnos"));

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
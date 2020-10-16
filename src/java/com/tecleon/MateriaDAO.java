package com.tecleon;

import java.util.*;
import java.sql.*;

public class MateriaDAO {

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


    public static int saveMateria(Materia pp) {
        int status = 0;
        try {
            Connection con = MateriaDAO.getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "insert into materia(nombreMateria, creditos,hp,ht,semestre) values (?,?,?,?,?)");
            ps.setString(1, pp.getNombreMateria());
            ps.setInt(2, pp.getCreditos());
            ps.setInt(3, pp.getHp());
            ps.setInt(4, pp.getHt());
            ps.setInt(5, pp.getSemestre());
            

            status = ps.executeUpdate();

            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return status;
    }

    public static int update(Materia pp) {
        int status = 0;
        try {
            Connection con = MateriaDAO.getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "update user set nombreMateria=?,creditos=?,hp=?,ht=?, semestre=? where nombreMateria=?");
            ps.setString(1, pp.getNombreMateria());
            ps.setInt(2, pp.getCreditos());
            ps.setInt(3, pp.getHp());
            ps.setInt(4, pp.getHt());
            ps.setInt(5, pp.getSemestre());
            ps.setString(6, pp.getNombreMateria());
            
            status = ps.executeUpdate();

            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return status;
    }

    public static int delete(String name) {
        int status = 0;
        try {
            Connection con = MateriaDAO.getConnection();
            PreparedStatement ps = con.prepareStatement("delete from materia where nombreMateria=?");
            ps.setString(1, name);
            status = ps.executeUpdate();

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }

    public static Materia getMateriaByName(String Name) {
        Materia pp = new Materia();

        try {
            Connection con = MateriaDAO.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from materia where nombreMateria=?");
            ps.setString(1, Name);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                pp.setIdMateria(rs.getString("idMateria"));
                pp.setNombreMateria(rs.getString("nombreMateria"));
                pp.setCreditos(rs.getInt("creditos"));
                pp.setHp(rs.getInt("hp"));
                pp.setHt(rs.getInt("ht"));
                pp.setSemestre(rs.getInt("semestre"));
            }
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return pp;
    }

    public static List<Materia> getAllMaterias() {
        List<Materia> list = new ArrayList<Materia>();

        try {
            Connection con = MateriaDAO.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from materia");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Materia pp = new Materia();
                pp.setIdMateria(rs.getString("idMateria"));
                pp.setNombreMateria(rs.getString("nombreMateria"));
                pp.setCreditos(rs.getInt("creditos"));
                pp.setHp(rs.getInt("hp"));
                pp.setHt(rs.getInt("ht"));
                pp.setSemestre(rs.getInt("semestre"));

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
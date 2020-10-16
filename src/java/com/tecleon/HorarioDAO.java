package com.tecleon;

import java.util.*;
import java.sql.*;

public class HorarioDAO {

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


    public static int saveHorario(Horario pp) {
        int status = 0;
        try {
            Connection con = HorarioDAO.getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "insert into horario(idClase, horLunes,salLunes,horMartes,salMartes,horMiercoles,salMiercoles,horJueves,salJueves,horViernes,salViernes,periodo) values (?,?,?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1, pp.getIdClase());
            ps.setString(2, pp.getHorLunes());
            ps.setString(3, pp.getSalLunes());
            ps.setString(4, pp.getHorMartes());
            ps.setString(5, pp.getSalMartes());
            ps.setString(6, pp.getHorMiercoles());
            ps.setString(7, pp.getSalMiercoles());
            ps.setString(8, pp.getHorJueves());
            ps.setString(9, pp.getSalJueves());
            ps.setString(10, pp.getHorViernes());
            ps.setString(11, pp.getSalViernes());
            ps.setString(12,pp.getPeriodo());
           
            status = ps.executeUpdate();

            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return status;
    }

    public static int update(Horario pp) {
        int status = 0;
        try {
            Connection con = HorarioDAO.getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "update user set idClase=?horLunes=?,salLunes=?,horMartes=?,salMartes=?,horMiercoles=?,salMiercoles=?,horJueves=?,salJueves=?,horViernes=?,periodo=? where idHorario=?");
            ps.setString(1, pp.getIdClase());
            ps.setString(2, pp.getHorLunes());
            ps.setString(3, pp.getSalLunes());
            ps.setString(4, pp.getHorMartes());
            ps.setString(5, pp.getSalMartes());
            ps.setString(6, pp.getHorMiercoles());
            ps.setString(7, pp.getSalMiercoles());
            ps.setString(8, pp.getHorJueves());
            ps.setString(9, pp.getSalJueves());
            ps.setString(10, pp.getHorViernes());
            ps.setString(11, pp.getSalViernes());
            ps.setString(12,pp.getPeriodo());
            ps.setInt(13, pp.getIdHorario());
            
            status = ps.executeUpdate();

            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return status;
    }

    public static int delete(int idHorario) {
        int status = 0;
        try {
            Connection con = HorarioDAO.getConnection();
            PreparedStatement ps = con.prepareStatement("delete from horario where idHorario=?");
            ps.setInt(1, idHorario);
            status = ps.executeUpdate();

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }

    public static Horario getHorarioByIdClase(int idClase) {
        Horario pp = new Horario();

        try {
            Connection con = HorarioDAO.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from horario where idClase=?");
            ps.setInt(1, idClase);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                pp.setIdHorario(rs.getInt("idHorario"));
                pp.setIdClase(rs.getString("idClase"));
                pp.setHorLunes(rs.getString("horLunes"));
                pp.setSalLunes(rs.getString("salLunes"));
                pp.setHorMartes(rs.getString("horMartes"));
                pp.setSalMartes(rs.getString("salMartes"));
                pp.setHorMiercoles(rs.getString("horMiercoles"));
                pp.setSalMiercoles(rs.getString("salMiercoles"));
                pp.setHorJueves(rs.getString("horJueves"));
                pp.setSalJueves(rs.getString("salJueves"));
                pp.setHorViernes(rs.getString("horViernes"));
                pp.setSalViernes(rs.getString("salViernes"));
                pp.setPeriodo(rs.getString("periodo"));
              
            }
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return pp;
    }

    public static List<Horario> getAllHorarios() {
        List<Horario> list = new ArrayList<Horario>();

        try {
            Connection con = HorarioDAO.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from horario");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Horario pp = new Horario();
                pp.setIdHorario(rs.getInt("idHorario"));
                pp.setIdClase(rs.getString("idClase"));
                pp.setHorLunes(rs.getString("horLunes"));
                pp.setSalLunes(rs.getString("salLunes"));
                pp.setHorMartes(rs.getString("horMartes"));
                pp.setSalMartes(rs.getString("salMartes"));
                pp.setHorMiercoles(rs.getString("horMiercoles"));
                pp.setSalMiercoles(rs.getString("salMiercoles"));
                pp.setHorJueves(rs.getString("horJueves"));
                pp.setSalJueves(rs.getString("salJueves"));
                pp.setHorViernes(rs.getString("horViernes"));
                pp.setSalViernes(rs.getString("salViernes"));
                pp.setPeriodo(rs.getString("periodo"));
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
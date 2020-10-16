<%-- 
    Document   : classes
    Created on : 12/10/2020, 02:18:18 PM
    Author     : Miguel Ivan
--%>
<%@page import="com.tecleon.Prof"%>
<%@page import="java.sql.*"%>
<%@page import="com.tecleon.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="styles.css" media="screen">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <title>Classes</title>
    </head>
    <body>
        <%
           HttpSession ses = request.getSession();
           String user;
           user = ses.getAttribute("user").toString();
            
           Prof pro = ProfDAO.getProfByEmail(user);
            
        %>
        <div class="container">
            <hr>
            <h1>Classes  of <% out.println(pro.getNombreProf());%></h1>
            <hr>
            <a href="login.jsp">Login</a> |   
            <a href="profile.jsp">Profile</a>|
            <a href="classes.jsp">Classes</a>
            <hr>
            <a href="newClass.jsp">New Class</a>|
            <a href="classes.jsp">Edit Class</a>|
            <a href="classes.jsp">Delete Class</a>
            <hr>
            <br>
            <table>
                <thead>
                    <tr>
                        <td>ClaveHorario</td><td>ClaveMateria</td><td>claveCarrera</td><td>Materia</td><td>Carrera</td><td>Maestro</td><td>Periodo</td><td>Grupo</td><td>NoAlumnos</td><td>Semestre</td><td>Creditos</td><td>Lunes</td><td>Salon</td><td>Martes	</td><td>Salon	</td><td>Miercoles</td><td>Salon</td><td>Jueves	</td><td>Salon</td><td>Viernes<td>Salon</td>
                    </tr>
                </thead>
                <tbody>
                    <%
                        ProfDAO p= new ProfDAO();
                       try{
                        Connection con = ProfDAO.getConnection();
                        Statement stmt = con.createStatement();
                        ResultSet rs=stmt.executeQuery("Select  nombreMateria,  idCarrera,nombreProf,periodo, grupo, numAlumnos , semestre,creditos, horLunes,salLunes,horMartes,salMartes,horMiercoles,salMiercoles,horJueves,salJueves,horViernes ,salViernes from clase c join materia m on  m.idMateria = c.idMateria join horario h on c.idClase = h.idClase join profe p on c.idProf=p.idProf;"); 
                        while(rs.next()){
                    %>
                    <tr>
                        <td><%=rs.getString("nombreMateria") %></td>
                        <td><%=rs.getString("idCarrera") %></td>
                        <td><%=rs.getString("nombreProf") %></td>
                        <td><%=rs.getString("periodo") %></td>
                        <td><%=rs.getString("grupo") %></td>
                        <td><%=rs.getInt("numAlumnos") %></td>
                        <td><%=rs.getInt("semestre") %></td>
                        <td><%=rs.getInt("creditos") %></td>
                        <td><%=rs.getString("horLunes") %></td>
                        <td><%=rs.getString("salLunes") %></td>
                        <td><%=rs.getString("horMartes") %></td>
                        <td><%=rs.getString("salMartes") %></td>      
                        <td><%=rs.getString("horMiercoles") %></td>
                        <td><%=rs.getString("salMiercoles") %></td>
                        <td><%=rs.getString("horJueves") %></td>
                        <td><%=rs.getString("salJueves") %></td>
                        <td><%=rs.getString("horViernes") %></td>
                        <td><%=rs.getString("salViernes") %></td>
                    </tr>
                    <%}}catch(SQLException e){e.printStackTrace();}%>
                </tbody>
                <tbody>
            </table>
        </div>
    </body>
</html>

<%-- 
    Document   : profile
    Created on : 12/10/2020, 02:42:47 PM
    Author     : Miguel Ivan
--%>

<%@page import="com.tecleon.Prof"%>
<%@page import="java.sql.*"%>
<%@page import="com.tecleon.ProfDAO"%>
<%@page import="java.time.LocalDateTime"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>            
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Profile</title>
        <link rel="stylesheet" href="styles.css" media="screen">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="scripts.js"></script>
    </head>
    <body>
        <%
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            HttpSession ses = request.getSession();
            String user;
            int tHours=0,bacHours=0,posHours=0,totalHours=0,numClases=0;
            
            user = ses.getAttribute("user").toString();
            
            Prof pro = ProfDAO.getProfByEmail(user);
           
            
        %>
        <div class="container">
            <hr>
            <h1>Profile  <% out.println(pro.getNombreProf());%></h1>
            <hr>
            <a href="login.jsp">Login</a> |   
            <a href="profile.jsp">Profile</a>|
            <%
                if(ses.getAttribute("type").toString().equals("jefe"))
                    out.println("<a href='classes.jsp'>Classes</a>");
            %>
            <hr>
            <div class="profileInfo">
                <table >
                    <tr>
                        <td>Teacher Name:</td><td><% out.println(pro.getNombreProf());%></td>
                    </tr>
                    <tr>
                        <td>Teacher Id:</td><td><% out.println(pro.getIdProf());%></td>
                    </tr>
                    <tr>
                        <td>Teaching Hours:</td><td></td>
                    </tr>
                    <tr>
                        <td>Bachelor Hours Assigned:</td><td></td>
                    </tr>
                    <tr>
                        <td>Postgraduate Hours Assigned:</td><td></td>
                    </tr>
                    <tr>
                        <td>Total of assigned hours:</td><td></td>
                    </tr>
                </table>
            </div>
            <hr>
            <div class="showSubjects">
                <table >
                    <thead>
                        <tr>
                            <td>No.</td><td>Group Id</td><td>Subject Id </td>
                            <td>Subject Name</td><td>Group</td><td>Classroom</td>
                            <td>No. Students</td><td>Carrer</td>
                            <td>Semester</td><td>Monday</td>
                            <td>Tuesday</td><td>Wednesday</td>
                            <td>Thursday</td><td>Friday</td><td>TH</td><td>PH</td><td>Credits</td>
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
                </table>
                <hr>
                <div id="time"
                     <p ><% out.println(now);%></p>
                </div>
            </div>
        </div>
    </body>
</html>

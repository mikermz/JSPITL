<%@page import="com.tecleon.ProfDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin</title>
    </head>
    <body>
        <%
            HttpSession ses = request.getSession();
            ProfDAO pr= new ProfDAO();
            
            String user, type;

            if (ses.getAttribute("user") != null && ses.getAttribute("type") != null) {
                user = ses.getAttribute("user").toString();
                type = ses.getAttribute("type").toString();
                out.print("<a href='login.jsp?close='true'><h5>Logout  " + user + "</h5></a>");
            } else {
                out.print("<script>location.replace('login.jsp');</script>");
            }
        %>
        <hr>
        <h1>Admin Page</h1>
        <hr>
        <a href="login.jsp">Login</a> |   
        <a href="profile.jsp">Profile</a>|
        <a href="classes.jsp">Schedules</a>
        <hr> 

    </body>
</html>

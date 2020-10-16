<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Classes</title>
        <link rel="stylesheet" href="styles.css" media="screen">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="scripts.js"></script>
    </head>
    <body>
        <%
            HttpSession ses = request.getSession();
            String user,type;
            
            if(ses.getAttribute("user")!= null && ses.getAttribute("type")!= null){
                user=ses.getAttribute("user").toString();
                type=ses.getAttribute("type").toString();
                out.print("<a href='login.jsp?close='true'><h5>Logout  "+user+"</h5></a>");
            }else{
                out.print("<script>location.replace('login.jsp');</script>");
            }    
        %>
        <hr>
        <h1>Teacher Page</h1>
        <hr>
        <a href="login.jsp">Login</a> |   
        <a href="profile.jsp">Profile</a>
        <hr> 
    </body>
</html>

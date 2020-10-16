<%@page import="com.tecleon.ProfDAO"%>
<%@page import="com.tecleon.UserDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>login</title>
    </head>
    <body>
        <hr>
        <h1>Formulario de acceso</h1>
        <hr>
        <form action="login.jsp" method="post">
            <div class="input-group">
                <label>Username:</label>
                <input type="email" name="userName" id="userName">
            </div>
            <div class="input-group">
                <label>Password:</label>
                <input type="password" name="userPass" id="userPass">
            </div>
            <div class="input-group">
                <button type="submit" class="btn" name="loginBtn">Login</button>
            </div>
        </form>
        <%
            ProfDAO us = new ProfDAO();
            
            if (request.getParameter("loginBtn") != null) {
                String name = request.getParameter("userName");
                String pass = request.getParameter("userPass");
                HttpSession ses = request.getSession();
                
                out.print(us.login(name, pass));
                switch (us.login(name, pass)) {
                    case "jefe":
                        ses.setAttribute("user", name);
                        ses.setAttribute("type", "jefe");
                        response.sendRedirect("indexAdmin.jsp");
                        break;
                    case "docente":
                        ses.setAttribute("user", name);
                        ses.setAttribute("type", "profesor");
                        response.sendRedirect("indexTeacher.jsp");
                        break;
                    default:
                        out.write("Invalid user or password");
                        break;
                }
            }
            if(request.getParameter("close")!=null){
                session.invalidate();
            }
        %>
    </body>
</html>

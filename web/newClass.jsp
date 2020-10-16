<%@page import="java.util.*"%>
<%@page import="com.tecleon.Prof"%>
<%@page import="com.tecleon.ProfDAO"%>
<%@page import="com.tecleon.MateriaDAO"%>
<%@page import="com.tecleon.Materia"%>
<%@page import="com.tecleon.HorarioDAO"%>
<%@page import="com.tecleon.Horario"%>
<%@page import="com.tecleon.ClaseDAO"%>
<%@page import="com.tecleon.Clase"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>New Class</title>
    </head>
    <body>
        <%
            String[] grupos = {"A","B","C","D","E","F"};
            List<Prof> profes = ProfDAO.getAllProf(); 
           List<Materia> materias = MateriaDAO.getAllMaterias();
        %>
        <div class="container">
            <hr>
            <h1>New Class</h1>
            <hr>
            <a href="login.jsp">Login</a> |   
            <a href="profile.jsp">Profile</a>|
            <a href="classes.jsp">Classes</a>
            <hr>
            <br>
            <form method="post" action="newClass.jsp">
                
                Clave Grupo:<input type="text" name="claveClase" id="claveClase"><br>
                Professor:
                <select name="prof" id="prof">
                    <%
                        for(Prof c:profes ){
                            out.println("<option value='"+c.getIdProf()+"'>"+c.getNombreProf()+"</option>");
                        }
                    %>

                </select><br>
                
                Materia:
                <select name="mat" id="mat">
                    <%
                        for(Materia c:materias ){
                            out.println("<option value='"+c.getIdMateria()+"'>"+c.getNombreMateria()+"</option>");
                        }
                    %>
                </select><br>
                Grupo:
                <select name="grupo" id="grupo">
                    <%
                        for(String c:grupos ){
                            out.println("<option value='"+c+"'>"+c+"</option>");
                        }
                    %>
                </select><br>

                Salon:  <input type="text" name="salon" id="salon">
                <br>
                Horario:<br>

                <input type="checkbox" id="lunes" name="lunes" value="lunes">
                <label for="onMonday"> Lunes</label><br>
                <input type="checkbox" id="martes" name="martes" value="martes">
                <label for="onMonday"> Martes</label><br>
                <input type="checkbox" id="miercoles" name="miercoles" value="miercoles">
                <label for="onMonday"> Miercoles</label><br> 
                <input type="checkbox" id="jueves" name="jueves" value="jueves">
                <label for="onMonday"> Jueves</label><br>
                <input type="checkbox" id="viernes" name="viernes" value="viernes">
                <label for="onMonday"> Viernes</label><br><br>
                <input type="submit" value="Guardar" >
                <select name="horario" id="horario">
                    <option value="7:00-8:40">7:00-8:40</option>
                    <option value="8:40-10:30">8:40-10:30</option>
                    <option value="10:30-12:10">10:30-12:10</option>
                    <option value="12:10-1:50">12:10-1:50</option>
                </select>        
                
                
            </form>
                
                <%
                String idProf = request.getParameter("prof");
                String idMat = request.getParameter("mat");
                String grupo = request.getParameter("grupo");
                String idClase = request.getParameter("claveClase");
                Clase cl = new Clase();
                
                cl.setIdClase(idClase);
                cl.setIdProfe(Integer.parseInt(idProf));
                cl.setIdMateria(idMat);
                cl.setGrupo(grupo);
                cl.setNumAlumnos(0);
                
                int statusClase = ClaseDAO.saveClase(cl);
                
                String salon = request.getParameter("salon");
                String horario = request.getParameter("horario");
                String lunes = request.getParameter("lunes");
                String martes = request.getParameter("martes");
                String miercoles = request.getParameter("miercoles");
                String jueves = request.getParameter("jueves");
                String viernes = request.getParameter("viernes");

                Horario hor = new Horario();
                
                hor.setIdClase(idClase);
                if(lunes!=null){
                    hor.setHorLunes(horario);
                    hor.setSalLunes(salon);
                }else{
                    hor.setHorLunes("");
                    hor.setSalLunes("");
                }
                
                if(martes!=null){
                    hor.setHorMartes(horario);
                    hor.setSalMartes(salon);
                }else{
                    hor.setHorMartes("");
                    hor.setSalMartes("");
                }
                if(miercoles!=null){
                    hor.setHorMiercoles(horario);
                    hor.setSalMiercoles(salon);
                }else{
                    hor.setHorMiercoles("");
                    hor.setSalMiercoles("");
                }
                if(jueves!=null){
                    hor.setHorJueves(horario);
                    hor.setSalJueves(salon);
                }else{
                    hor.setHorJueves("");
                    hor.setSalJueves("");
                }
                if(viernes!=null){
                    hor.setHorViernes(horario);
                    hor.setSalViernes(salon);
                }else{
                    hor.setHorViernes("");
                    hor.setSalViernes("");
                }
                hor.setPeriodo("Agosto-Diciembre");
                
                int statusHor = HorarioDAO.saveHorario(hor);
                if (statusHor > 0 && statusClase >0) {
                    out.println("<p>Record saved successfully! </p>");
                    out.print("<script>location.replace('classes.jsp');</script>");
                } else {
                    out.println("Sorry! unable to save record");
                }
                %>
        </div>
    </body>
</html>

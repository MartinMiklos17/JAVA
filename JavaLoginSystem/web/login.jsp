<%-- 
    Document   : login
    Created on : 2018.04.22., 22:25:11
    Author     : Martin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body><p>Hey Friend! If You already a member, please login!</p><br>
        <p>If not, please registrate <a href="registrator.jsp">here</a></p>
        <form action="loginServlet" method="post">  
        Name:<input type="text" name="userName"/><br/><br/>  
        Password:<input type="password" name="userPass"/><br/><br/>  
        <input type="submit" value="login"/>  
        
        </form>  
    </body>
</html>

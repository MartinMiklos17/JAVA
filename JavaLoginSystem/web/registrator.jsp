<%-- 
    Document   : registrator
    Created on : 2018.04.22., 22:29:07
    Author     : Martin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <p>Please registrate.</p>
        <form action="registrationServlet" method="post">  
        Name:<input type="text" name="userName"/><br/><br/>  
        Password:<input type="password" name="userPass"/><br/><br/>  
        <input type="submit" value="submit"/>  
        </form>
    </body>
</html>

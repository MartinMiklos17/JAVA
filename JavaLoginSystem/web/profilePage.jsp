<%-- 
    Document   : profilePage
    Created on : 2018.04.22., 21:48:47
    Author     : Martin
--%>

<html>
<head><title>User profilePage</title></head>

<body>


<% HttpSession ses = request.getSession();
    String userName = (String)request.getAttribute("userName");
    Object sessionID = ses.getAttribute("sessionID");
    
%> 

<p>Hi ${userName}! This is your sessionID: ${sessionID} 
    This is Your profilePage, where You can change your informations, or upload a profile pic of yours.<br>
   


</p>
<form action="logOutServlet" method="POST">
    <input type="hidden" value="killSession" name ="wannaKillSession"> 
    <input type="submit" value="logOut" name="kill">
    
</form>


</body>
</html>

package loginPackage;

import java.io.IOException;  
import java.io.PrintWriter;  
  
import javax.servlet.RequestDispatcher;  
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
import javax.servlet.http.HttpSession;
  
  
public class loginServlet extends HttpServlet {  
public void doPost(HttpServletRequest request, HttpServletResponse response)  
        throws ServletException, IOException {  
  
    response.setContentType("text/html");  
    PrintWriter out = response.getWriter();  
          
    String n=request.getParameter("userName");  				//get data from form
    String p=request.getParameter("userPass");  
          
    if(LoginDAO.validate2(n, p)){  						//if login credentials are valid
	uniqIDCreator ccr = new uniqIDCreator();								
	HttpSession ses = request.getSession();					//create session
	request.setAttribute("userName", n);						// set attributes
	ses.setAttribute("sessionID", ccr.createUniqID());
	String sessionID = (String)ses.getAttribute("sessionID");
	RequestDispatcher rd=request.getRequestDispatcher("profilePage.jsp");  	//forwarding  
        rd.forward(request,response); 
        
    }  
    else{  
        out.print("Sorry username or password error with credentials:"+n+", password:"+p);  
        RequestDispatcher rd=request.getRequestDispatcher("index.html");  
        rd.include(request,response);  
    }  
          
    out.close();  
    }  
}  
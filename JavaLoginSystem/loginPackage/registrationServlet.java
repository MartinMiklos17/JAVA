package loginPackage;

import java.io.*;
import java.sql.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class registrationServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //set OUT
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            //Database connection
            Class.forName("com.mysql.jdbc.Driver");  			 
            String jdbcURL = "jdbc:mysql://localhost:3306/javadatabase?zeroDateTimeBehavior=convertToNull&characterEncoding=utf8";
            String dbUsername = "root";
            String dbPassword = "";
            Connection conn = DriverManager.getConnection(jdbcURL, dbUsername, dbPassword);
            //Get data from FORM
            String userName = request.getParameter("userName");  		
            String userPass = request.getParameter("userPass");
            //INSERT data to database
            String sql = ("INSERT INTO user (name, password)" + "VALUES ('" + userName + "', '" + userPass + "')");

            PreparedStatement statement = conn.prepareStatement(sql);								//INSERT values to DB
            statement.execute(sql);
            //check if data was inserted?
            String sqlForCheck = "SELECT name FROM user WHERE name=?"; //sql command
            PreparedStatement statementForCheck = conn.prepareStatement(sqlForCheck);								//INSERT values to DB
            statementForCheck.setString(1, userName);   //replace ? with string

            ResultSet rs = statementForCheck.executeQuery(); //execute
            String userNameForCheck = null;
            while (rs.next()) {
                userNameForCheck = rs.getString(1);
            }
            if (userNameForCheck.equals(userName)) {
                
                uniqIDCreator ccr = new uniqIDCreator();        //uniqID object      
                HttpSession ses = request.getSession();		//create session
                //set attributes for dispatcing
                ses.setAttribute("user", userName);
                ses.setAttribute("sessionID", ccr.createUniqID());
                request.setAttribute("userName", userName);
                //dispatch
                RequestDispatcher rd = request.getRequestDispatcher("profilePage.jsp");
                rd.forward(request, response);
            } else {
                System.out.println("registration was NOT successful. Please try again!");
            }

        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } catch (ClassNotFoundException ce) {
            ce.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace(out);
        }
    }
}

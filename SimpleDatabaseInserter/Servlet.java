/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Martin
 */
public class Servlet extends HttpServlet {

     @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        try {
            res.setContentType("text/html");  //response hangolása
            PrintWriter out = res.getWriter();  //Kiíró ojectum létrehozása
            try {
                /* creating DataBase Connection*/
                Class.forName("com.mysql.jdbc.Driver");  //set path for mysql Driver, this is the standart value, dont have to change
                String jdbcURL = "jdbc:mysql://localhost:3306/javadatabase?zeroDateTimeBehavior=convertToNull&characterEncoding=utf8";  //Database URL
                String dbUsername = "root";  // database username  
                String dbPassword = "";     //database password 

              Connection conn = DriverManager.getConnection(jdbcURL, dbUsername, dbPassword); // create connection, give parameters
              
              Statement statement = conn.createStatement(); // create statement of the connection

                /* Get Data from FORM*/
                String userName = req.getParameter("name"); // Post data from HTML
                String password = req.getParameter("password");

                /*INSERT INTO DATABASE*/
                String sql = ("INSERT INTO user (name, password) VALUES ('" + userName + "', '" + password + "')"); //solution if the insertable data is NOT variables "INSERT INTO user (name, password) VALUES ('martin', '456')";
                statement.executeUpdate(sql); // execute sql command

                /*OutPrinting to System*/
                out.println("Successfull");
                out.println(userName);

            } catch (ClassNotFoundException e) {
                out.println("class not found");
            }
        } catch (SQLException e) {
            System.out.println(e);
            throw new RuntimeException("cannnot connect the database", e);

        }
    }
}

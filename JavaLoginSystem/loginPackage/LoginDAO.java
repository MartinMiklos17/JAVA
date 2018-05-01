package loginPackage;

import java.sql.*;

public class LoginDAO {

    public static boolean isUser = false;

    public static boolean validate2(String userName, String userPass) {

        try {
            /* creating DataBase Connection*/
            Class.forName("com.mysql.jdbc.Driver");  //set path for mysql Driver, this is the standart value, dont have to change
            String jdbcURL = "jdbc:mysql://localhost:3306/javadatabase?zeroDateTimeBehavior=convertToNull&characterEncoding=utf8";  //Database URL
            String dbUsername = "root";  // database username  
            String dbPassword = "";     //database password 

            Connection conn = DriverManager.getConnection(jdbcURL, dbUsername, dbPassword); // create connection, give parameters
            
            String sql = "select * from user where name=? and password=?";
            PreparedStatement ps=conn.prepareStatement(sql);  
            ps.setString(1,userName);  
            ps.setString(2,userPass);   
            
            
            
            ResultSet results = ps.executeQuery();
            if (results.next()) {
                //System.out.println("You have logged in successfully!");
                isUser = true;
            } else {
                //System.out.println("Bitch fuck YOu!");
                isUser = false;

            }

        } catch (ClassNotFoundException ce) {
            ce.printStackTrace();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        return isUser;
    }

    public static boolean validate(String userName, String userPass) {
        boolean status = false;

        try {
            /* creating DataBase Connection*/
            Class.forName("com.mysql.jdbc.Driver");  //set path for mysql Driver, this is the standart value, dont have to change
            String jdbcURL = "jdbc:mysql://localhost:3306/javadatabase?zeroDateTimeBehavior=convertToNull&characterEncoding=utf8";  //Database URL
            String dbUsername = "root";  // database username  
            String dbPassword = "";     //database password 

            Connection conn = DriverManager.getConnection(jdbcURL, dbUsername, dbPassword); // create connection, give parameters

            Statement statement = conn.createStatement(); // create statement of the connection
            PreparedStatement ps = conn.prepareStatement(
                    "select * from user where name='" + userName + "' and password='" + userPass + "'");
            ps.setString(1, userName);
            ps.setString(2, userPass);

            ResultSet rs = ps.executeQuery();
            status = rs.next();

        } catch (Exception e) {
            System.out.println(e);
            return status;
        }
        return status;
    }
}

package exhibitionAdministrator;
import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.SQLException; 
public class exhibitionAdministratorOneTimeConnection 
{        //java file for connection with database
    static 
    {
           try
           { 
                Class.forName("com.mysql.jdbc.Driver");
           }
           catch(ClassNotFoundException e)
           {
                System.out.print("Error" +e);
           }
    }  
    public static Connection getConnection() throws SQLException    
    {
          return DriverManager.getConnection("jdbc:mysql://localhost:3306/exhibition?zeroDateTimeBehavior=convertToNull","root","12345");
    } 
}


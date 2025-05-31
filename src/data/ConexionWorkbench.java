package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionWorkbench {
   public static Connection Conectar() {
       try {
           Class.forName("com.mysql.cj.jdbc.Driver");
           Connection con = DriverManager.getConnection(
                   "jdbc:mysql://localhost:3306/kasumi", 
                    "root",
                    "your_password");
           return con;
       } catch(ClassNotFoundException | SQLException ex) {
           return null;
       }
   }
}
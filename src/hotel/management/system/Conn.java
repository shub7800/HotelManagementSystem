package hotel.management.system;

import java.sql.*;
//it is stablish a connection between java and data base
public class Conn {
    /*
        JDBC HAVE 5 STEP TO MAKE A CONNECTION 
    1-REGISTER the driver -- mysql driver 
    with thw hepl of class
     Class.forName("com.mysql.cj.jdbc.Driver");//my sql are external entity
    2- Creating the Connection --
        
        c= DriverManager.getConnection("jdbc://mysql//Localhost:3306/Class.forName(\"com.mysql.cj.jdbc.Driver\");//hotelbasemanagementsystem","root","shubham@7800");
    3- Creating statement ---
    s=c.createStatement();
    
    4-Execting mysql Quarry---
    
    5- closing the connection 
    
    */
    
    Connection c;
    Statement s;//mysql ki quary execute kar sakte ho 
    Conn(){
        //("com.mysql.cj.jdbc.Driver")-- ye hamara jaar file ke andar hota hai 
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");//my sql are external entity
            c= DriverManager.getConnection("jdbc:mysql://Localhost:3306/hotelmanagementsystem","root","Shubham@7800");//connection string
            //url ke andar sql string pass karna hota hai 
            s=c.createStatement();
        
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
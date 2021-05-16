/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package phr_dataseeker;
import java.sql.*;
//import com.mysql.jdbc.Connection;
//import com.mysql.jdbc.Statement;
/**
 *
 * @author Innovatus
 */
public class LoginChecker {


    public boolean checkLogin(String uid, String pass)
    {
        boolean flag=true;

        try
        {

            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/phr","root","root");
            Statement st=(Statement) con.createStatement();

            String query="Select * from registration where uname='"+uid+"'and pass='"+pass+"'";

            ResultSet rs=st.executeQuery(query);
            
            if(rs.next())
            {
             flag=true;   
            }
            
            else
            {
                flag=false;
            }
          

        }

        catch(Exception e)
        {
            System.out.println("Exeption in LogicChecker Class is: "+e);
            flag=false;
        }

        return flag;
    }

}

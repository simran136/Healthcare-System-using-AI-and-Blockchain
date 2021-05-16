/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package phr_dataseeker;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author 2491
 */
public class MobileNumberFetcher {
    
    
     public String getUserNumber(String uname)
    {
       
               String mob="";
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/phr","root","root");
            Statement st=conn.createStatement();

            String query="Select * from registration where uname ='"+uname+"'";
            ResultSet rs=st.executeQuery(query);

            if(rs.next())
            {
                
                //name, dob, add, email, client_for, mobile, username, password, key
            mob=rs.getString(1);
            
            
            
            //[tushar, 01:03:1993, pune, t@gmail.com, TELECOM, 234d, TUS0019, 1234]
            }
            
    
        }
           // int x=st.executeUpdate(query);
            
        catch(Exception e)
        {
            System.out.println("Exception at ClientDataFetcher"+e);
            
        }
       
      return mob;
    }
    
}

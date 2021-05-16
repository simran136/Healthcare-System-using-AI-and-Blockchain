/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package phr;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author pratiksha
 */
public class UserDataFetcher {
    
    public ArrayList getUserData(String uname)
    {
       
                ArrayList ar= new ArrayList();
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
            ar.add(rs.getString(1));
            ar.add(rs.getString(2));
            ar.add(rs.getString(3));
            ar.add(rs.getString(4));
            ar.add(rs.getString(5));

            
            
            //[tushar, 01:03:1993, pune, t@gmail.com, TELECOM, 234d, TUS0019, 1234]
            }
            
    
        }
           // int x=st.executeUpdate(query);
            
        catch(Exception e)
        {
            System.out.println("Exception at ClientDataFetcher"+e);
            
        }
       
      return ar;
    }
 


}

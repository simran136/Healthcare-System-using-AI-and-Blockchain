/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package accesscontrol;
import phr.*;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author pratiksha
 */
public class AccessDataFetcher {
    
    
    
    public ArrayList getAccessData(String ed)
    {
       
             ArrayList ar= new ArrayList();
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/phr","root","root");
            Statement st=conn.createStatement();
            String query="Select * from healthdatainfo where encounteid='"+ed+"'";
            ResultSet rs=st.executeQuery(query);

            if(rs.next())
            {
                
          
                //name, dob, add, email, client_for, mobile, username, password, key
            ar.add(rs.getString(1));
            ar.add(rs.getString(2));
            ar.add(rs.getString(3));
            ar.add(rs.getString(4));
            ar.add(rs.getString(5));
            ar.add(rs.getString(6));
            ar.add(rs.getString(7));
            ar.add(rs.getString(8));
             ar.add(rs.getString(9));
            ar.add(rs.getString(10));
            ar.add(rs.getString(11));
            ar.add(rs.getString(12));
            ar.add(rs.getString(13));
            ar.add(rs.getString(14));
            ar.add(rs.getString(15));
            ar.add(rs.getString(16));
            ar.add(rs.getString(17));
            ar.add(rs.getString(18));
            ar.add(rs.getString(19));
            ar.add(rs.getString(20));
            ar.add(rs.getString(21));
            ar.add(rs.getString(22));
            ar.add(rs.getString(23));
            ar.add(rs.getString(24));
            ar.add(rs.getString(25));
            ar.add(rs.getString(26));
            ar.add(rs.getString(27));
            

            
            
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

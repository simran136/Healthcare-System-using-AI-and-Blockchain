/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package preprocessing;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author pratiksha
 */
public class DataCCFetcher {
    
    public ArrayList getDetails()
    {
       
        ArrayList ar= new ArrayList();
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/phr","root","root");
            Statement st=conn.createStatement();

            String query="Select * from healthdatainfo";
            ResultSet rs=st.executeQuery(query);

            while(rs.next())
            {
                //name, dob, add, email, client_for, mobile, username, password, key
            
                String str=rs.getString("cc");
                
                
                ar.add(str);
           
            //[tushar, 01:03:1993, pune, t@gmail.com, TELECOM, 234d, TUS0019, 1234]
            }
            System.out.println("ar is  "+ar);
    
        }
           // int x=st.executeUpdate(query);
            
        catch(Exception e)
        {
            System.out.println("Exception at ClientDataFetcher"+e);
            
        }
       
      return ar;
    }
 


}

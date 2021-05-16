/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package accesscontrol;


 import java.sql.*;
public class TempInfoDeletor 
{
    public boolean deletedata()
    {
        
        boolean flag=false;
	try
        {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/phr","root","root");
            Statement st=con.createStatement();
//candidatename, age, sex, educationqualification, worth, profession, symbolname, partyname
            String query="delete from  tempinfo  ";
            int x=st.executeUpdate(query);
            if(x>0)
               flag=true;
            else
                flag=false;
            
            
                con.close();
        }
        catch(Exception e)
        {
           System.out.println(e);
           flag=false;
        }
        
        return flag;
    }
}

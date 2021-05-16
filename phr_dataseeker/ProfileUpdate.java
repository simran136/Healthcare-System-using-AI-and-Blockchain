/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package phr_dataseeker;
import java.sql.*;

/**
 *
 * @author Innovatus
 */
public class ProfileUpdate {
    
    
    public boolean updateData(String name, String emailid,String mobile ,String uname,String pass)
    {
        boolean flag=true;
     try
        {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/phr","root","root");
            Statement st=conn.createStatement();
     //name, emailid, mobile, uname, pass       
            String query="Update registration set name='"+name+"',emailid='"+emailid+"',mobile='"+mobile+"',pass='"+pass+"' where uname='"+uname+"'";
            int x=st.executeUpdate(query);
            if(x>0)
                flag=true;
            else
                flag=false;
        }
        catch(Exception e)
        {
            System.out.println("Exeption in AdminProfileUpdate Class is: "+e);
            flag=false;
        }
    
        return flag;
    }
    
}

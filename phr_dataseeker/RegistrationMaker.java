/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phr_dataseeker;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author DELL
 */
public class RegistrationMaker {
    
     public boolean doRegister(String name,String email,String mobile,String uname,String pass)
    {
        //name, dob, cadd, email, mobile, registerfor, uname, pass
        boolean flag=true;
        try
        {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/phr","root","root");
            Statement st=conn.createStatement();

            String query="Insert into registration values('"+name+"','"+email+"','"+mobile+"','"+uname+"','"+pass+"')";
            int x=st.executeUpdate(query);
            if(x>0)
                flag=true;
            else
                flag=false;



        }
        catch(Exception ex)
        {
            System.out.println("exception in inserter "+ex);
            flag=false;
        }

        return flag;
    }
    
}

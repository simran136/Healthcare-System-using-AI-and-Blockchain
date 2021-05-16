/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesscontrol;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import phr.*;

/**
 *
 * @author DELL
 */
public class AccessDataMaker {
    
     public boolean insertPersonalData(ArrayList info)
    {
        //name, dob, cadd, email, mobile, registerfor, uname, pass
        boolean flag=true;
        try
        {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/phr","root","root");
            Statement st=conn.createStatement();

            String query="Insert into tempinfo values('"+info.get(0)+"','"+info.get(1)+"','"+info.get(2)+"','"+info.get(3)+"','"+info.get(4)+"','"+info.get(5)+"','"+info.get(6)+"','"+info.get(7)+"','"+info.get(8)+"','"+info.get(9)+"','"+info.get(10)+"','"+info.get(11)+"','"+info.get(12)+"','"+info.get(13)+"','"+info.get(14)+"','"+info.get(15)+"','"+info.get(16)+"','"+info.get(17)+"','"+info.get(18)+"','"+info.get(19)+"','"+info.get(20)+"','"+info.get(21)+"','"+info.get(22)+"','"+info.get(23)+"','"+info.get(24)+"','"+info.get(25)+"','"+info.get(26)+"')";
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

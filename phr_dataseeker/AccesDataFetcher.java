/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package phr_dataseeker;
import java.io.File;
import phr.*;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
/**
 *
 * @author pratiksha
 */
public class AccesDataFetcher {
    
    public void provideData()
    {
        ArrayList data=getData();
        
           JFileChooser fc = new JFileChooser();
           fc.showOpenDialog(fc);

        File src = fc.getSelectedFile();
        String path = src.getAbsolutePath();
      //  System.out.println("Path: "+path);
        
        String filexten="xls";
        try
        {
            new CreateExcelFile().getExcelFile(data,path);
            data.clear();
            JOptionPane.showMessageDialog(null, "Excel Sheet As Been Downloaded Successfully");
        }
        catch (Exception e)
        {
            System.out.println("Exception e"+e);
        }
    }
 
public ArrayList getData()
    {
      String str=" provider_org, encounteid, memberid, provider_id, provider_npi, clinic_id, encounter_datetime, encounter_description, cc, episode_id, patient_dob, patient_gender, provider_name, specialty, clinic_type, lab_orders_count, lab_results_count, medication_orders_count, medication_fulfillment_count, vital_sign_count, therapy_actions_count, therapy_order_count, immunization_count, has_appt, soap_note, consult_ordered, disposition";
      String st1[]=str.split(",");
      
      
      ArrayList data=new ArrayList();
      ArrayList temp=new ArrayList();
      
        for (int i = 0; i < st1.length; i++)
        {
            temp.add(st1[i]);
        }
        data.add(temp);
        
        
        
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/phr","root","root");
            Statement st=conn.createStatement();

            String query="Select * from tempinfo"; 
            ResultSet rs=st.executeQuery(query);

            while(rs.next())
            {
                
                ArrayList ar= new ArrayList();
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
            
            
            data.add(ar);
            
            
            //[tushar, 01:03:1993, pune, t@gmail.com, TELECOM, 234d, TUS0019, 1234]
            }
            
    
        }
           // int x=st.executeUpdate(query);
            
        catch(Exception e)
        {
            System.out.println("Exception at ClientDataFetcher"+e);
            
        }
       
      return data;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package x_mean;

import java.text.DecimalFormat;
import java.util.ArrayList;


/**
 *
 * @author welcome
 */
public class EuclideanDistanceCal {
    
    
    public double getDistance(ArrayList preprocess)
    {
        ArrayList eucdistance=new ArrayList();
       double mean=0.0, summean=0.0;
        
       
        
        
        
        for(int i=0;i<preprocess.size();i++)
        {
            ArrayList ntemp=new ArrayList();
            double dis=0.0;
            ArrayList temp1=(ArrayList) preprocess.get(i);
            
           String s=(String) temp1.get(0);
           int x1=(int) temp1.get(1);
           
        
            double sum=0.0;
            for(int j=0;j<preprocess.size();j++)
            {
               
                if(i!=j)
                {
                   ArrayList temp2=(ArrayList) preprocess.get(j);
            
                     int y1=(int) temp2.get(1);
      
   
            double ssum= Math.pow(y1-x1, 2);
           // System.out.println(sum);
            dis=Math.sqrt(ssum);
            
            sum=sum+dis;
            
          //  System.out.println(sum);
                }
                
              }
         
            double rd=sum/preprocess.size()-1;
            rd=Double.parseDouble(new DecimalFormat("##.##").format(rd));
            String rd1=Double.toString(rd);
           // System.out.println("rd "+rd);
                
            ntemp.add(s);
            ntemp.add(x1);
            ntemp.add(rd1);
//           
            mean=mean+rd;
            
            eucdistance.add(ntemp);
           // DataKeeper.distancelist.add(ntemp);
            
        
        }
        
        mean=mean/preprocess.size();
        mean=Double.parseDouble(new DecimalFormat("##.##").format(mean));
        
        DataKeeper.distancelist=eucdistance;
        
//        System.out.println("MEAN===========================================");
//        System.out.println(mean);
        
        
        mean=Math.sqrt(mean);
        
        return mean;
    }
    
}

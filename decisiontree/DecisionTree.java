/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package decisiontree;

import java.text.DecimalFormat;
import java.util.ArrayList;
import x_mean.DataKeeper;


public class DecisionTree {
    
    public ArrayList getGainList(ArrayList rcluster )
    {
        ArrayList gainList=new ArrayList();
        ArrayList gainl=new ArrayList();
        
     
        for(int i=0;i<rcluster.size();i++)
        {
            ArrayList temp=new ArrayList();
            ArrayList single =(ArrayList) rcluster.get(i);
            
            int count=0;
            for(int j=0;j<single.size();j++)
            {
                ArrayList row=(ArrayList) single.get(j);
                int cc=(int) row.get(1);
                
                if(cc>2)
                {
                    count++;
                }
            }
            
           // System.out.println("Count"+count);
            int a=count;
            int c=single.size();
            int b=c-a;
            
            double gain=new GainEstimation().getSIGain(a, b, c);
            gain=Double.parseDouble(new DecimalFormat("##.#").format(gain));
            temp.add(Integer.toString(i));
            temp.add(Double.toString(gain));
            
           gainl.add(temp);
            
        }
         DataKeeper.gainl=gainl;
        new Sorter().getSortedList();
//        
      
        
        return gainl;
        
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package accesscontrol;

import java.util.ArrayList;

/**
 *
 * @author 2491
 */
public class EncounteridFreq {
    
    public ArrayList getEncounterid(ArrayList enid, ArrayList fre)
    {
        
       
        
        for (int i = 0; i < enid.size(); i++) 
        {
            ArrayList temp=(ArrayList) enid.get(i);
            String en=(String) temp.get(0);
            double tar=(double)temp.get(1);
            
            for (int j = 0; j < fre.size(); j++) 
            {
                ArrayList temp1=(ArrayList) fre.get(j);
                double tar1=(double) temp1.get(0);
                int count=(int)temp1.get(1);
                
                if(tar==tar1)
                {
                    temp.add(count);
                }
                
                
                
                
                
                
                
                
            }
            
            
            
            
             
        }
        
        
      return enid;   
    }
    
    
}

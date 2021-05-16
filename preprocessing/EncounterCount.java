/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package preprocessing;

import java.util.ArrayList;

/**
 *
 * @author 2491
 */
public class EncounterCount {
    
    public ArrayList getEncCount(ArrayList cc,ArrayList mas)
    {
        ArrayList enc=new ArrayList();
        
        
        for (int i = 0; i < mas.size(); i++) 
        {
          ArrayList temp1=new ArrayList();
            int count =0;
            ArrayList temp=(ArrayList) mas.get(i);
            String str1=(String) temp.get(24);
           String encc=(String) temp.get(1);
            for (int j = 0; j < cc.size(); j++) 
            {
            
                String str2=(String) cc.get(j);
                
                 if(str1.contains(str2))
                {
                    count++;
                 }
                
                
            }
           
            
           temp1.add(encc);
           temp1.add(count);
           enc.add(temp1);
        
        }
      
        return enc;
    }
    
    
}

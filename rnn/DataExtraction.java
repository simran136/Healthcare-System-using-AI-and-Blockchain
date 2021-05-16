/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rnn;

import java.util.ArrayList;

/**
 *
 * @author 2491
 */
public class DataExtraction {
    
    public ArrayList getData(ArrayList mas , ArrayList ac)
    {
        ArrayList mass=new ArrayList();
        
        for (int i = 0; i < ac.size(); i++)
        {
        
            ArrayList row=(ArrayList) ac.get(i);
            String eid=(String) row.get(0);
            
            for (int j = 0; j < mas.size(); j++) 
            {
            
                ArrayList mrow=(ArrayList) mas.get(j);
                String eid1=(String) row.get(0);
                if(eid.equals(eid1))
                {
                    mass.add(mrow);
                }
                
                
            }
            
                }
        
        
      
        
        return mass;
    }
    
    
}

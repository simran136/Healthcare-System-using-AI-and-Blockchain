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
public class AccessControl {
    
    public ArrayList getAccess(ArrayList anntar, double maxper)
    {
        ArrayList ac=new ArrayList();
        
        
        for (int i = 0; i < anntar.size(); i++) 
        {
            ArrayList row=(ArrayList) anntar.get(i);
            double prob=(double) row.get(3);
            
            if(prob>maxper)
            {
                ac.add(row);
            }
      
        }
        
     
        
        
        
        return ac;
    }
    
}

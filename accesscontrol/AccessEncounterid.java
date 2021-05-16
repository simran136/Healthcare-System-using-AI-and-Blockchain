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
public class AccessEncounterid {
    
    public ArrayList getAccessID(ArrayList acc)
    {
        ArrayList accid=new ArrayList();
        for (int i = 0; i < 10; i++) {
            
            ArrayList temp1=new ArrayList();
            
            ArrayList temp=(ArrayList) acc.get(i);
            String str1=(String) temp.get(0);
            double ann=(double) temp.get(temp.size()-1);
     
            
            
            temp1.add(str1);
             temp1.add(ann);
              accid.add(temp1);
        }
        
      return accid;  
    }
    
}

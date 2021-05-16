/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package accesscontrol;

import java.util.ArrayList;
import preprocessing.DuplicateEliminator;

/**
 *
 * @author 2491
 */
public class PredictionScoreFrequency {
    public ArrayList getFreq(ArrayList freq)
    {
        
         ArrayList <Double> idm=new  ArrayList <Double>();
         ArrayList <Double> ids=new  ArrayList <Double>();
        for (int i = 0; i < freq.size(); i++) 
        {
                ArrayList temp=(ArrayList) freq.get(i);
                double str1=(double) temp.get(temp.size()-1);
                
                
            idm.add(str1);
            ids.add(str1);
        
        }
         ids=new DuplicateEliminator().getUnique(ids);
         
         
         ArrayList fre=new ArrayList();
         for (int i = 0; i < ids.size(); i++)
         {
             int count=0;
                double id1=ids.get(i);
                ArrayList temp=new ArrayList();
                for (int j = 0; j < idm.size(); j++) 
                {
                   double  id2=idm.get(j);
                    
                    if(id2==id1)
                    {
                        count++;
                    }
                     
             }
             
             temp.add(id1);
             temp.add(count); 
             fre.add(temp);
        
             
        }
         
        
        
        return fre;
    }
    
}

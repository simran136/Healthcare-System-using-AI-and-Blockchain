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
public class RnnInputList {
    
    public ArrayList getannit(ArrayList cluster, ArrayList gain)
    {
        ArrayList anninputlist=new ArrayList();
        int count=0;
        
        for (int i = 0; i <=1; i++) 
        {
           ArrayList temp=(ArrayList) gain.get(i);
           String in=(String) temp.get(0);
           int ind=Integer.parseInt(in);
           
           
                ArrayList cl= (ArrayList) cluster.get(ind);
               
            for (int j = 0; j < cl.size(); j++) 
            {
               
                ArrayList row=(ArrayList) cl.get(j);
                
                anninputlist.add(row);
            }
     
    }

        return anninputlist;
}
}
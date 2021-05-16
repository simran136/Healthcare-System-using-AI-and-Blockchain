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
public class AccessControlData {
    
    public String getHashkey(ArrayList data)
    {
        int atr[]={10,11,5,7,15,16,19};
        String blockbody="";
        
        for (int i = 0; i < data.size(); i++) 
        {
        
            ArrayList temp=(ArrayList) data.get(i);
            String en=(String) temp.get(0);
            int fr=(int)temp.get(temp.size()-1);
            
            
            int x=(7*fr)/10;// x is access data control
          //  System.out.println("x = "+x);
            
            
            ArrayList info=new AccessDataFetcher().getAccessData(en);
            String rowdata="";
            for (int j = 0; j < 10; j++)
            {
                rowdata=rowdata+(String)info.get(j);
           
            }
            blockbody=blockbody+rowdata;
            
            
            for (int j = 0; j < x; j++) 
            {
            
                int d=atr[j];                
                info.set(d, "*****");
                
               
               
            }
             new AccessDataMaker().insertPersonalData(info);
        }
        
        String haskey=new MD5().MDfive(blockbody);
        String blockey=haskey.substring(0,5);
        System.out.println(" "+blockey);
       
        return blockey;
    }
    
}

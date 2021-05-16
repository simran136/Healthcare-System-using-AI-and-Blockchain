/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package x_mean;

import java.util.ArrayList;

/**
 *
 * @author welcome
 */
public class ClusterFormation {
    
    
    public ArrayList getCluster(ArrayList range)
    {
        ArrayList cluster=new ArrayList();
        
        ArrayList sorter=DataKeeper.distancelist;
        
        
        for(int i=0;i<range.size();i++)
        {
            
            ArrayList temp1=(ArrayList) range.get(i);
            
            double min=(double) temp1.get(0);
            double max=(double) temp1.get(1);
//            System.out.println(min);
//            System.out.println(max);
            
            ArrayList single=new ArrayList();
            for(int j=0;j<sorter.size();j++)
            {
                
                ArrayList temp2=(ArrayList) sorter.get(j);
                String rd1=(String) temp2.get(2);
                
                double r=Double.parseDouble(rd1);
              
                
                if(r>=min&&r<=max)
                {
                    single.add(temp2);
                }
                
               
                
                    
            }
            
            cluster.add(single);
        }
        
        
        
        cluster=getOuterLayer(cluster);
       
        return cluster;
    }
    
    
    public ArrayList getOuterLayer(ArrayList cluster)
    {
        
      
        ArrayList outlayer= new ArrayList();
        
        ArrayList sorter=DataKeeper.distancelist;

        
        
        for(int i=0;i<sorter.size();i++)
        {
            ArrayList temp1=(ArrayList) sorter.get(i);
            
            boolean flag=true;
            for(int j=0;j<cluster.size();j++)
            {
                ArrayList single=(ArrayList) cluster.get(j);
                
               if(single.contains(temp1))
               {
                   flag=false;
                   break;
               } 
                   
            }
            if(flag)
               outlayer.add(temp1);
        }
        if(outlayer.size()>0)
            cluster.add(outlayer);
        
        
        
        return cluster;
    }
    
    
    
    
}

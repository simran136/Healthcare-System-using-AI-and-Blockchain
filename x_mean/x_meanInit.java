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
public class x_meanInit {
    
    
    public ArrayList getCluster(ArrayList preprocess)
    {
        ArrayList cluster=new ArrayList();
        
    
         EuclideanDistanceCal ed=new EuclideanDistanceCal();
         
         double mean= ed.getDistance(preprocess);
         
         System.out.println("");
         System.out.println("Mean=  "+mean);
         
            
          
                  
         
        
          Sorter s=new Sorter();
          s.getSortedList();
           ArrayList distlist=DataKeeper.distancelist;
          System.out.println("");
          System.out.println("DISTANCE SORTED SCORE DATA LIST=======================================================");
          for(int i=0;i<distlist.size();i++)
         {
             ArrayList temp=new ArrayList();
             temp=(ArrayList) distlist.get(i);
             System.out.println(temp);
         }
        
          
          System.out.println();
          System.out.println("DATA POINTS LIST=======================================================");
          DataPoints dp=new DataPoints();
          ArrayList dpoints=dp.getDataPoints();
          
          System.out.println(dpoints);
          
          
          System.out.println();
          System.out.println("CENTROIDS ARE======================================================");
          Centroids c=new Centroids();
          
          ArrayList centroid=c.getCentroids(dpoints);
          System.out.println(centroid);
          
          
                  
          
          System.out.println();
          System.out.println("RANGES ARE======================================================");
          ArrayList range=c.getClusterBoundary(centroid, mean);
          for(int i=0;i<range.size();i++)
         {
             ArrayList temp=new ArrayList();
             temp=(ArrayList) range.get(i);
             System.out.println(temp);
         }
         
         
           System.out.println("\n");
       System.out.println("X_Mean CLUSTERS ARE===================================================");
       ClusterFormation cf=new ClusterFormation();
           cluster=cf.getCluster(range);
       
        
          
          
        return cluster;
    }
    
}

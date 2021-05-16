/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package x_mean;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 *
 * @author welcome
 */
public class Centroids {
    
    
    public ArrayList getCentroids(ArrayList dpoints)
    {
        ArrayList centroids=new ArrayList();
        
        ArrayList sorter=DataKeeper.distancelist;
        
        
        for(int i=0;i<dpoints.size();i++)
        {
            String p1=(String) dpoints.get(i);
            
            int x=Integer.parseInt(p1);
            
              ArrayList temp= (ArrayList) sorter.get(x);
              centroids.add(temp.get(temp.size()-1));
            
          
        }
        
        
        //System.out.println(range);
        
        return centroids;
    }
    
    
    public ArrayList getClusterBoundary(ArrayList centroids, double mean)
    {
        ArrayList boundary=new ArrayList();
        
        
        for(int i=0;i<centroids.size();i++)
        {
            ArrayList <Double>temp=new ArrayList<Double>();
            String str=(String) centroids.get(i);
            double x=Double.parseDouble(str);
            double min=x-mean;
            min=Double.parseDouble(new DecimalFormat("##.###").format(min));
            double max=x+mean;
            max=Double.parseDouble(new DecimalFormat("##.###").format(max));
            temp.add(min);
            temp.add(max);
            boundary.add(temp);
        }
        
        return boundary;
    }
    
}

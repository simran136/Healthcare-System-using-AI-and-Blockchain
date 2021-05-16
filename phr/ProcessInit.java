/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package phr;

import accesscontrol.AcSorter;
import accesscontrol.AccessControl;
import accesscontrol.AccessControlData;
import accesscontrol.AccessEncounterid;
import accesscontrol.EncounteridFreq;
import accesscontrol.PredictionScoreFrequency;
import rnn.RnnInputList;
import rnn.RnnInt;
import rnn.DataExtraction;
import decisiontree.DecisionTree;
import java.util.ArrayList;
import x_mean.x_meanInit;
import x_mean.Sorter;
import x_mean.SorterEE;
import phr_dataseeker.AuthenticateKeyFrame;
import phr_dataseeker.MobileNumberFetcher;
import phr_dataseeker.sendSMS;

import preprocessing.DataCCFetcher;
import preprocessing.DuplicateEliminator;
import preprocessing.EncounterCount;
import preprocessing.Preprocessor;

/**
 *
 * @author 2491
 */
public class ProcessInit {
    
    public void initializer( String str)
    {
        
        ArrayList mas=new DataFetcher().getData();
    //    System.out.println("*****************************Complete Data**************************************************");
//        for (int i = 0; i < mas.size(); i++)
//        {
//            
//            ArrayList temp=(ArrayList) mas.get(i);
//            System.out.println(temp);
//          
//        }
        
        
//        String query="Looking for 28 years female patient suffering with high-sensitivity fecal occult blood test, bilateral mammography, skin cancer screening";
//        System.out.println("*******************************Preprocessing************************************");
//        
         
             String pre=new Preprocessor().textProcessing(str);
             System.out.println(pre);
            
        
      System.out.println("*****************************CC**************************************************");
     ArrayList preprocess=new ArrayList();
        String str1[]=pre.split(" ");
        for (int i = 0; i < str1.length; i++) 
        {
        
            String str11=str1[i];
            preprocess.add(str11);
        }
        
      
        
        System.out.println(" dddd"+preprocess);
      
        
        ArrayList enc=new EncounterCount().getEncCount(preprocess, mas);
     System.out.println("*****************************Encounter and cc Count**************************************************");

        for (int i = 0; i < enc.size(); i++) 
        {
            ArrayList temp=(ArrayList) enc.get(i);
            System.out.println(temp); 
        }
        
        
         x_meanInit km=new x_meanInit();       
        ArrayList cluster=km.getCluster(enc);
        
         for(int i=0;i<cluster.size();i++)
        {
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++CLUSTER NO "+(i+1));
            ArrayList t=(ArrayList) cluster.get(i);
            
            for(int j=0;j<t.size();j++)
            {
                ArrayList t1=(ArrayList) t.get(j);
                System.out.println(t1);
            }
                        
                    System.out.println();
            
        }
         
        System.out.println("+++++++++++++++++++++++++++++++Decision Tree++++++++++++++++++++++++++++++++++++++");     
         ArrayList  gain1=new DecisionTree().getGainList(cluster);
         
       
       ArrayList gain= new SorterEE().getSortedList(gain1);
         
         
         
         for (int i = 0; i < gain.size(); i++) 
         {
          ArrayList temp=(ArrayList) gain.get(i);
          
             System.out.println(temp);
             
             
        }
         
         
       ArrayList input=new RnnInputList().getannit(cluster, gain);
         
        System.out.println("RNN Imput is +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n\n ");
         for(int i=0;i<input.size();i++)
        {
           ArrayList t=(ArrayList) input.get(i);
               System.out.println(t);
        }
         System.out.println("RNN with target val is +++++++++++++++++++++++++++++++++++++++++++++++++++++++\n\n ");
        RnnInt an= new RnnInt();
        
       ArrayList  anntar=an.geePrediction(input);
       
       
        for (int i = 0; i < anntar.size(); i++) {
            
            ArrayList at=(ArrayList) anntar.get(i);
            System.out.println(at);
            
            
        }
       
       
       
         
     double max=an.max;
        System.out.println("max "+max);
        
        double maxper=(max*99)/100;
        
        System.out.println("++++++++++++++++++++++++++++++++++++++Maxper ++++++++++++++++++++++++++++++++++++"+maxper);
        
        System.out.println("\n\n Access Control--------------------------------------------------------");
         ArrayList ac=new AccessControl().getAccess(anntar, maxper);
         
          for (int i = 0; i < ac.size(); i++) {
            
            ArrayList at=(ArrayList) ac.get(i);
            System.out.println(at);
         
        }
          System.out.println("\n \n\n++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ Sorted Access Control");
          ArrayList sortedac=new AcSorter().getSortedList(ac);
          
          for (int i = 0; i < sortedac.size(); i++) {
            
            ArrayList at=(ArrayList) sortedac.get(i);
            System.out.println(at);
         
        }
          
          System.out.println("\n\n\n\n  Select Encounter ID+++++++++++++++++++++++++++++++++++++++++++++++++++++++++ ");
          
          ArrayList enid=new AccessEncounterid().getAccessID(sortedac);
          
          
          for (int i = 0; i < enid.size(); i++) {
              
              ArrayList at=(ArrayList) enid.get(i);
            System.out.println(at);
            
        }
          
              System.out.println("\n\n\n\nFrequency Count++++++++++++++++++++++++++++++++++++++++++++++++++++++++ ");
      
          ArrayList frew=new PredictionScoreFrequency().getFreq(enid);
          
           for (int i = 0; i < frew.size(); i++) {
              
              ArrayList at=(ArrayList) frew.get(i);
            System.out.println(at);
            
        }
           
           
           System.out.println("\n\n\n\n Frequency Count with  Encounter id +++++++++++++++++++++++++++++++++++");
           
           
           ArrayList encfreq=new EncounteridFreq().getEncounterid(enid, frew);
           
            for (int i = 0; i < encfreq.size(); i++) {
              
              ArrayList at=(ArrayList) encfreq.get(i);
            System.out.println(at);
            
        }
        String blockey=   new AccessControlData().getHashkey(encfreq);
           
           blockey=blockey.toUpperCase();
        
           Datakeeper.blockey=blockey;
           System.out.println(blockey);
        String mob=new MobileNumberFetcher().getUserNumber(Datakeeper.username);
        System.out.println(mob);
        String msg="Dear, Dataseeker your  data is been granted please enter the authentication key "+blockey+" to Access same. ";
        
        new sendSMS().sendText(msg, mob);
        
        
        AuthenticateKeyFrame ak=new AuthenticateKeyFrame();
        ak.setVisible(true);
          ak.setSize(600,350);
        ak.setLocation(450, 150);
        
        
        
//          System.out.println("\n\n Data Extracted --------------------------------------------------------");
////        ArrayList data=new DataExtraction().getData(mas, ac);
////        
////         for (int i = 0; i < data.size(); i++) {
////            
////            ArrayList at=(ArrayList) data.get(i);
////            System.out.println(at);
////         
////        }
//        
    }
    
}

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
public class RnnInt {
  public  double max=0;
    public ArrayList  geePrediction(ArrayList input)
    {
        int big=0;
        for (int i = 0; i < input.size(); i++)
        {
        
            ArrayList row=(ArrayList) input.get(i);
            int c= (int) row.get(1);
            
            if(big<c)
            {
                big=c;
            }
            
            
        }
        int target1=big;
     //   System.out.println("target1 is \n\n"+big);
        int small=0;
         for (int i = 0; i < input.size(); i++)
        {
        
            ArrayList row=(ArrayList) input.get(i);
            int c= (int) row.get(1);
            
            if(small>c)
            {
                small=c;
            }
            
            
        }
            int target2=small;
      //   System.out.println("target 2 is \n\n "+small);
         double atr1=0.0;
         
         WeightKeeper.b1=new RandomFunction().getRandomWeight();
         WeightKeeper.b2=new RandomFunction().getRandomWeight();
         WeightKeeper.w1=new RandomFunction().getRandomWeight();
         WeightKeeper.w2=new RandomFunction().getRandomWeight();
         
         WeightKeeper.w3=new RandomFunction().getRandomWeight();
         WeightKeeper.w4=new RandomFunction().getRandomWeight();
         WeightKeeper.w5=new RandomFunction().getRandomWeight();
         WeightKeeper.w6=new RandomFunction().getRandomWeight();
         
         WeightKeeper.w7=new RandomFunction().getRandomWeight();
         WeightKeeper.w8=new RandomFunction().getRandomWeight();
       
         for (int i = 0; i < input.size(); i++) 
         {
         
             ArrayList row=(ArrayList) input.get(i);
             int cc=(int) row.get(1);
             atr1=cc;
             String ed=(String) row.get(2);
             double atr2=Double.parseDouble(ed);
             
             double prob=  new HiddenLayer().computerHiddenLayer(atr1, atr2, target1,target2);
             if(prob>max)
             {
                 max=prob;
             }
             row.add(prob);
        }
         
       return input;  
    }
    
    double getmax()
    {
              return max; 
    }
    
}

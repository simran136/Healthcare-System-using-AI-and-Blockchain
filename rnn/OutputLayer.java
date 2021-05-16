/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rnn;

/**
 *
 * @author 2491
 */
public class OutputLayer {
    public double performOutputLayerFunction(double h1,double h2,double tar1,double tar2)
    {
        
         
        double b2=WeightKeeper.b2;
        double x1=h1*WeightKeeper.w5+h2*WeightKeeper.w6+b2;
      //  System.out.println(" Output laHidden value is x1 is "+x1);
        double opval1=new SigmoidFunction().getActivationFunctionValue(x1);
      //  System.out.println("OP1 is "+opval1);
        
        
        double x2=h1*WeightKeeper.w7+h2*WeightKeeper.w8+b2;
        
    //    System.out.println("Hidden value is "+x2);
        
        
        double opval2=new SigmoidFunction().getActivationFunctionValue(x2);
      //  System.out.println("OP2 is "+opval2);
        
        
        
        double er1=Math.abs(tar1-opval1);
     //   System.out.println("Error Probabilty one is  "+er1);
        double er2=Math.abs(tar2-opval2);
     //   System.out.println("Error Probabilty two is  "+er2);
        
        double big=0.0;
     
        
        if(er1<big)
        {
            big=er1;
            return big;
        }
        else
        {
            big=er2;
            return er2;
        }
              
        
    }
    
    
}

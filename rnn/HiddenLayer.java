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
public class HiddenLayer {
    
    public double computerHiddenLayer(double atr1,double atr2,double tar1,double tar2)
    {
        
       
        double b1=WeightKeeper.b1;
        double x1=atr1*WeightKeeper.w1+atr2*WeightKeeper.w2+b1;
       // System.out.println("Hidden value is x1 is "+x1);
        double hiddenval1=new SigmoidFunction().getActivationFunctionValue(x1);
       // System.out.println("H1 is "+hiddenval1);
        
        
        double x2=atr1*WeightKeeper.w3+atr2*WeightKeeper.w4+b1;
        
     //   System.out.println("Hidden value is "+x2);
        
        
        double hiddenval2=new SigmoidFunction().getActivationFunctionValue(x2);
      //  System.out.println("H2 is "+hiddenval2);
        
      double tar=  new OutputLayer().performOutputLayerFunction(hiddenval1, hiddenval2,tar1,tar2);
        
        
        return tar;
        
        
    }
    
    
}

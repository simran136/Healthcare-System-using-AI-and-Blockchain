/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rnn;

import java.util.Random;

/**
 *
 * @author 2491
 */
public class RandomFunction {
    
    public double getRandomWeight()
    {
        double weight[] = {0.1, 0.9, 0.2, 0.4, 0.3, 0.2, 0.7, 0.9, 0.75, 0.25, 0.45};
          
        Random r = new Random();
        int Low = 0;
        int High = weight.length - 1;
        int index = r.nextInt(High - Low) + Low;

        double wt = weight[index];

        return (wt);
    
}
    
    
    
    
}

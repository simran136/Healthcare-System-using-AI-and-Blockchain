/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package phr_dataseeker;

import java.awt.Dimension;
import java.awt.Toolkit;

/**
 *
 * @author 2491
 */
public class Phr_Dataseeker {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         Dimension d=Toolkit.getDefaultToolkit().getScreenSize();

        LoginFrame l=new LoginFrame();
        l.setVisible(true);
        l.setSize(d);
        
    }
    
}

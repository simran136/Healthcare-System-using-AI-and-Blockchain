/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package phr_k;

import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import phr_dataseeker.LoginFrame;

/**
 *
 * @author 2491
 */
public class Phr_k {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
          try { 
  
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName()); 
            Dimension d=Toolkit.getDefaultToolkit().getScreenSize();

        LoginFrame mf=new LoginFrame();
        mf.setVisible(true);
        mf.setSize(d);
        } 
        catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException | HeadlessException e) { 
            System.out.println("Look and Feel not set"); 
        } 
        
        
    }
    
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package preprocessing;

import java.util.ArrayList;

public class Preprocessor
{

    public String  textProcessing(String str)
    {
         String [] words=str.split(" ");
        String temp="";
        for(int i=0;i<words.length;i++)
        {
            String w=words[i];
            

                w=w.replace("\"", "");
               w=w.replace("\'", "");
                w=w.replace(",", "");
               w=w.replace("!", "");
               w=w.replace(":", "");
               w=w.replace("  ", " ");
               w=w.replace("    ", " ");
                w=w.replace("(", "");
               w=w.replace(")", "");
               w=w.replace("[", "");
               w=w.replace("]", "");
               w=w.replace("{", "");
               w=w.replace("}", "");
               w=w.replace("?", "");
               w=w.replace("<", "");
               w=w.replace(">", "");
               w=w.replace("=", "");
                w=w.replace(".", "");









           boolean val12=StopWords.getWords(w);


       //    System.out.println("Returning value is .................."+val12);
           if( val12==false)
           {
             //  w.replace(w, " ");
             //   System.out.println(" Repalced Character >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+w);
                temp=temp+w+" ";

           }

        }

    


     //  System.out.println(" Stop Word Result is -------------------- :"+temp);

         Stemmer s1=new Stemmer();
       String []sw=temp.split(" ");
       String sa="";
       for(int i=0;i<sw.length;i++)
       {
           String st=sw[i];
           String sr=s1.stemmer(st);
           sa=sa+sr+" ";
      }

//System.out.println(" Stemming Word Result is ------------------------- :"+sa);


        

         return sa;


        
    }



}

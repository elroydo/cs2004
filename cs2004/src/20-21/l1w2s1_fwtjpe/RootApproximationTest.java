package l1w2s1_fwtjpe;

import javax.swing.JOptionPane;

public class RootApproximationTest {  
   public static void main(String[] args) {  
      boolean done = false;
      while (!done) {  
         String input = JOptionPane.showInputDialog("Enter a number, Cancel to quit");

         if (input == null) {
            done = true;
         }else {  
            double x = Double.parseDouble(input);
            RootApproximator r = new RootApproximator(x);
            double y = r.getRoot();
            
            System.out.println("square root of " + x + " = " + y);
         }
      }
   }
}

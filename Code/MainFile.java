import javax.swing.JOptionPane;
package Main;

public static int WIDTH = 200;
public static int HEIGHT = 100;
public class MainFile {
  
  
  public static void main(String[] args) { 
    String controls = "-------Player 1-----------//CONTROLS//-------Player 2-----------------\n"+
                      "JUMP:---Space-----------------||-------Up Arrow--------\n";

    JOptionPane.showMessageDialog(null,"Welcome to 2 Player Flappy Bird \nMade by Mahan Pandey \n Press OK to continue\n" + controls);
    
  }
  
 
  
}

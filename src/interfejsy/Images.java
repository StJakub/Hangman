package interfejsy;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Images extends JPanel {

	int counter = 0;
	private Image image;
	private Image[] imageicon;
	
	 
	 public Images() {
		 imageicon = new Image[7];
		 readImage();
	 }

	private void readImage() {
		for(int i=0; i<=6; i++) {
			  image = new ImageIcon("Images/Hangman" + i + ".png").getImage().getScaledInstance(300, 380, Image.SCALE_AREA_AVERAGING);
			imageicon[i] = image;
		}
	}
	 
	 
	 public void paintComponent(Graphics g) {
		 super.paintComponent(g);
	      
		 Graphics2D g2 = (Graphics2D) g;
		  g2.drawImage(imageicon[counter], 0, 0, this);
	 }
	 
	 public void increaseCounter() {
			counter++;
		}
	 
	 public void resetCounter() {
		 counter = 0;
	 }

}

	




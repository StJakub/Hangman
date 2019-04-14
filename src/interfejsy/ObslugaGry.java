package interfejsy;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;


public class ObslugaGry implements ActionListener{
	private Frame frame;
	private char retrieve;
	private Guess guessHND;
	
	public ObslugaGry(Frame frame, Guess guess) {
		this.frame = frame;
		guessHND = guess;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			retrieve = frame.getTextField().getText().charAt(0);
			frame.textarea().setText(null);
			frame.getTextField().setText(null);
			if(Character.isLetter(retrieve) == false) {
			JOptionPane.showMessageDialog(null,"Wprowadzona zla wielkosc");
			}
			
			if(!guessHND.check(retrieve)) {
				JOptionPane.showMessageDialog(null,
					    "Litera zostala powtorzona");
			}
			
			guessHND.check(retrieve);
			
			if(guessHND.getAttempts() == 0) {
				frame.akcepts().setEnabled(false);
				frame.textarea().setText(null);
				JOptionPane.showMessageDialog(null, "Koniec gry - pora¿ka, has³o to: " + guessHND.dajDostep().getAnswer());
				frame.reset();
			}
			
			if(guessHND.endGame()) {
				frame.akcepts().setEnabled(false);
				frame.textarea().setText(null);
				JOptionPane.showMessageDialog(null, "Gratulacje, wygra³eœ, has³o to: " + guessHND.dajDostep().getAnswer());
				frame.reset();
			}
			
			
			
			frame.textarea().append("hits: " + guessHND.getHits() +  "\n");
			frame.textarea().append("misses: " + guessHND.getMisses() + "\n");
			frame.textarea().append("Number of tries: " + guessHND.getAttempts() + "\n \n");
			frame.textarea().append("Answer:    " + guessHND.getProgress());
	
			}
			catch(StringIndexOutOfBoundsException e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage());
			}
		
	}

}



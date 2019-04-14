package interfejsy;

import javax.swing.JOptionPane;

public class Guess{

	private Answers answers;
	private Frame frame;
    private int attempts = 6;
	private String current = "";
	private String hits = "";
	private String misses = "";
	
	public Guess(Answers answers, Frame Frame) {
		this.answers = answers;
		this.frame = Frame;
	}
	
	private boolean isHit(char letter) {
	if(answers.getAnswer().indexOf(Character.toUpperCase(letter)) != -1 || answers.getAnswer().indexOf(Character.toLowerCase(letter)) != -1)
		return true;
		else
		return false;
	}
	
	public boolean check(char letter){
		if(!isRepeated(letter)) {
		if(isHit(letter)) {
			hits += letter;
			caseCheck(letter);
		}
		else {
			if(Character.isLetter(letter)) {
			misses += letter;
			caseCheck(letter);
		    attempts--;
		    frame.getImagePanel().increaseCounter();
		    frame.getImagePanel().repaint();
			}
		}
		return true;
		}
		return false;
	}
	
	public String getProgress(){
		String progress = "";
		char dash = '_';
		for(char sign : answers.getAnswer().toCharArray()) {
			if(hits.indexOf(sign) != -1)
				progress+= sign + " ";
			else
				progress += dash + " ";
		}
		return progress;
	}
	
	private boolean isRepeated(char letter){
		if(hits.indexOf(letter) != -1 || misses.indexOf(letter) != -1 ) {
			return true;
		}
		return false;
	}
	
	private void caseCheck(char letter) {
		if(isHit(letter)) {
		if(letter == Character.toLowerCase(letter)) {
			hits += Character.toUpperCase(letter);
		}
		else
			hits += Character.toLowerCase(letter);
		}
		else 
			if(letter == Character.toLowerCase(letter)) {
				misses += Character.toUpperCase(letter);
			}
			else
				misses += Character.toLowerCase(letter);
				
		
	}
	
	
	public boolean endGame() {
		char dash = '_';
		if(getProgress().indexOf(dash)!= -1)
			return false;
		return true;
	}
	
	public int getAttempts() {
		return attempts;
	}
	
	public String getHits() {
		String hits2display = "";
		for(char letter : hits.toCharArray()) {
			if(Character.isUpperCase(letter)) {
				hits2display += letter + " ";
			}
		}
	return hits2display;
		
	}
	
	public String getMisses() {
		String misses2display = "";
		for(char letter : misses.toCharArray()) {
			if(Character.isUpperCase(letter)) {
				misses2display += letter + " ";
			}
		}
	return misses2display;
	}
	
	public void guessReset() {
		hits = "";
		misses = "";
		attempts = 6;
	}
	
	public Answers dajDostep() {
		return answers;
	}


}
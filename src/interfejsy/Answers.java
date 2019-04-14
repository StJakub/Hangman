package interfejsy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Answers {

	private static final File answers = new File("Answers/Answers.txt"); ;
	private ArrayList<String> arrayAnswers;
	private Random generator;
	private String answer;
	
	public Answers() {
		arrayAnswers = new ArrayList<String>();
		generator = new Random();
		this.read();
		this.setAnswer();
	}
	
	private void read() {
		try {
			  BufferedReader reader = new BufferedReader(new FileReader(answers));
			  String line = reader.readLine();
			  
			while( line != null) {
				  arrayAnswers.add(line);
				  line = reader.readLine();
			}
			
			  reader.close();
			  }
			  catch(IOException e) {
				  e.getMessage();
			  }
	}
	
	private void setAnswer() {
	        answer = arrayAnswers.get(generator.nextInt(arrayAnswers.size()));
	}
	
	public String getAnswer() {
		return answer;
	}
	
	public void newAnswer() {
		answer = arrayAnswers.get(generator.nextInt(arrayAnswers.size()));
	}
	
	
	
	
}
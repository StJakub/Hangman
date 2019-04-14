package interfejsy;


	import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;


	public class Frame{
		
		private JFrame frame;
		private static final int width = 600;
		private static final int height = 400;
		private JButton akcept;
		private JButton startButton;
		private JPanel startPanel;
		private JPanel panel;
		private Images imagePanel;
		private JTextField textField;
		private ObslugaGry ObslugaGry;
		private  JTextArea textarea;
		private Guess guessHND;
		private Answers answers;
		private JSplitPane splitPane;

		
		public Frame(){
			frame = new JFrame("Hangman - samochody");
			frame.setResizable(false);
			setParameters();
			setComponents();
			answers = new Answers();
			guessHND = new Guess(answers, this);
			ObslugaGry = new ObslugaGry(this, guessHND);
			akcept.addActionListener(ObslugaGry);
		    startButton.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					Object event = e.getSource();
					startPanel.setVisible(false);
					panel = new JPanel(new BorderLayout());
					imagePanel = new Images();
					splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
	                           panel, imagePanel);
	                    splitPane.setOneTouchExpandable(false);
	                    splitPane.setDividerLocation(300);
	                    splitPane.setEnabled(false);
	                    frame.add(splitPane);
					panel.add(akcept, BorderLayout.PAGE_END);
					panel.add(textField, BorderLayout.PAGE_START);
					panel.add(textarea, BorderLayout.CENTER);
					
					
					textarea().append("hits: " + guessHND.getHits() +  "\n");
					textarea().append("misses: " + guessHND.getMisses() + "\n");
					textarea().append("Number of tries: " + guessHND.getAttempts() + "\n \n");
					textarea().append("Answer    " + guessHND.getProgress());
					
					textField.getDocument().addDocumentListener(new DocumentListener() {

								@Override
								public void insertUpdate(DocumentEvent e) {
									SwingUtilities.invokeLater(new Runnable() {
										@Override
										public void run() {
											String fromTextField = textField.getText();
											char sign = fromTextField.charAt(0);
											if(fromTextField.length()>1) {
												textField.setText(Character.toString(sign));
											}
										}});
					
								}

								@Override
								public void removeUpdate(DocumentEvent e) {					
								}

								@Override
								public void changedUpdate(DocumentEvent e) {								
								}});
			
				
				}
			});   
			
		}
		
		
		private void setParameters() {
			frame.setSize(width, height);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setLocationRelativeTo(null);
			frame.setVisible(true);
			startPanel = new JPanel();
			startPanel.setBackground(Color.GREEN);
			startPanel.setLayout(null);
			frame.add(startPanel);
		}
		
		private void setComponents() {
			textField = new JTextField();
			textarea = new JTextArea();
			textarea.setEditable(false);
			buttons();
			textField();
		}
		
		private void buttons() {
			akcept = new JButton();
			akcept.setText("Ok");
			
		   startButton = new JButton("Start");
			
			startButton.setSize(160, 80);
			startButton.setLocation(220,140);
			startButton.setBackground(Color.MAGENTA);
			startButton.setForeground(Color.BLACK);
			startButton.setFont(new Font("Arial",Font.ITALIC,25));
			startPanel.add(startButton);
		
		}
		
		private void textField() {
			textField = new JTextField();
		}	
		
		public JPanel getJPanel() {
			return panel;
		}
		
		public JTextField getTextField() {
			return textField;
		}
		
		public JTextArea textarea() {
			return textarea;
		}
		
		public JButton akcepts() {
			return akcept;
		}
		
		public Images getImagePanel() {
			return imagePanel;
		}	
		
		public void reset() {
			answers.newAnswer();
			guessHND.guessReset();
			imagePanel.resetCounter();
			imagePanel.repaint();
			akcept.setEnabled(true);		
		}
		
}

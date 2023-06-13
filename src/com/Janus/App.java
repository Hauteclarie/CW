package com.Janus;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JTextField;
import com.Janus.Core.FileHandler;
import com.Janus.Core.UnitConverter;
import com.Janus.Interface.AppInterface;
import com.Janus.Interface.Label;

public class App implements ActionListener {
	
	Label outputLabel = new Label(860, 30, 360, 620, Color.white, Color.black);
	JButton convertButton = new JButton("Convert");
	JButton saveButton = new JButton("Save");
	JButton readButton = new JButton("Read");
	JButton searchButton = new JButton("Search");
	JTextField inputField = new JTextField();
	JTextField searchField = new JTextField();
	JTextField inputUnitField = new JTextField();
	JTextField outputUnitField = new JTextField();
	FileHandler fileHandler = new FileHandler();
	String lastResultString;
	
	public App() {
		
	}
	
	public void start() {
		Dimension windowDimension = new Dimension(1280, 720);
		Color backgroundColor = new Color(127, 123, 123);
		AppInterface appWindowInterface = new AppInterface(windowDimension, backgroundColor, false);
		Label inputLabel = new Label(30, 30, 360, 620, Color.white, Color.black);
		
		inputField.setBounds(50, 50, 320, 30);
		inputField.setText("Here enter value..");
		
		searchField.setBounds(50, 100, 230, 30);
		searchField.setText("Here enter uint for search..");
		
		inputUnitField.setBounds(50, 150, 320, 30);
		inputUnitField.setText("Here enter input unit..");
		
		outputUnitField.setBounds(50, 200, 320, 30);
		outputUnitField.setText("Here enter output unit..");
		
		convertButton.setFocusable(false);
		convertButton.setBounds(450, 30, 360, 50);
		convertButton.addActionListener(this);
		
		saveButton.setFocusable(false);
		saveButton.setBounds(450, 110, 360, 50);
		saveButton.addActionListener(this);
		
		readButton.setFocusable(false);
		readButton.setBounds(450, 190, 360, 50);
		readButton.addActionListener(this);
		
		searchButton.setFocusable(false);
		searchButton.setBounds(280, 100, 90, 30);
		searchButton.addActionListener(this);
		
		appWindowInterface.innit();
        appWindowInterface.add(inputLabel);
        appWindowInterface.add(outputLabel);
        appWindowInterface.add(convertButton);
        appWindowInterface.add(saveButton);
        appWindowInterface.add(readButton);
        appWindowInterface.add(searchButton);
        appWindowInterface.add(inputField);
        appWindowInterface.add(searchField);
        appWindowInterface.add(inputUnitField);
        appWindowInterface.add(outputUnitField);
        
        outputLabel.setHorizontalAlignment(Label.CENTER);
        
        inputLabel.setHorizontalAlignment(Label.CENTER);;
        inputLabel.setText("<html>---Aviable Units-----<br/>1. B - byte<br/>2. KB - kilobyte<br/>3. MB - megabyte<br/>4. GB - gigabyte</html>");
	}
	
	public static void main(String[] args) {
		App appInstance = new App();
		appInstance.start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == convertButton) {
			double result = UnitConverter.convert(inputUnitField.getText(), outputUnitField.getText(), Double.parseDouble(inputField.getText()));
			String tempString = inputField.getText() + " " + inputUnitField.getText() + " is equal to: " + Double.toString(result) + " "  + outputUnitField.getText();
			outputLabel.setText(tempString);
			
			if(inputUnitField.getText().startsWith("B")) {
				try {
					fileHandler.logResult(tempString, "B");
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}else if (inputUnitField.getText().startsWith("K")) {
				try {
					fileHandler.logResult(tempString, "KB");
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}else if (inputUnitField.getText().startsWith("M")) {
				try {
					fileHandler.logResult(tempString, "MB");
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}else if (inputUnitField.getText().startsWith("G")) {
				try {
					fileHandler.logResult(tempString, "GB");
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			
			lastResultString = tempString;
			
		}
		
		if(e.getSource() == saveButton) {
			try {
				fileHandler.saveResult(lastResultString);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		
		if(e.getSource() == searchButton) {
			
			String resultString = null;
			
			if(searchField.getText().startsWith("B")) {
				try {
					resultString = fileHandler.readFile("B");
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			}else if (searchField.getText().startsWith("K")) {
				try {
					resultString = fileHandler.readFile("KB");
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			}else if (searchField.getText().startsWith("M")) {
				try {
					resultString = fileHandler.readFile("MB");
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			}else if (searchField.getText().startsWith("G")) {
				try {
					resultString = fileHandler.readFile("GB");
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			}
			
			outputLabel.setText("<html>" + resultString + "</html>");
			
		}
		
		if(e.getSource() == readButton) {
			String tempString = null;
			try {
				tempString = fileHandler.readFile("log");
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
			outputLabel.setText("<html>" + tempString + "</html>");
		}
		
	}
	
}

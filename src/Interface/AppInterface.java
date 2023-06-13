package com.Janus.Interface;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.ImageIcon;

public class AppInterface extends Window {

	private static final long serialVersionUID = -3881554968884534116L;

	public AppInterface(Dimension windowDimension, Color backgroundColor, boolean isResizable) {
		super(windowDimension, backgroundColor, isResizable);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void innit() {
		this.setResizable(isResizable);
		this.setTitle("Janus Unit Converter");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(getWindowDimension());
		this.setVisible(true);
		
		ImageIcon icon = new ImageIcon("res/logo.png");
		this.setIconImage(icon.getImage());
		this.getContentPane().setBackground(getBackgroundColor());
		this.setLayout(null);
		this.requestFocus();
	}
	
	public Dimension getWindowDimension() {
		return windowDimension;
	}
	
	public Color getBackgroundColor() {
		return backgroundColor;
	}
	
	public void setWindowDimension(Dimension windowDimension) {
		this.windowDimension = windowDimension;
	}
	
	public void setbackgroundColor(Color backgroundColor) {
		this.backgroundColor = backgroundColor;
	}

}

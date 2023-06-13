package com.Janus.Interface;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.border.Border;

public class Label extends JLabel{

	private static final long serialVersionUID = -5599213968189939089L;
	
	private int posX;
	private int posY;
	private int width;
	private int height;
	private Color backgroundColor;
	private Color borderColor;
	
	public Label(int posX, int posY, int width, int height, Color backgroundColor, Color borderColor) {
		this.posX = posX;
		this.posY = posY;
		this.width = width;
		this.height = height;
		this.backgroundColor = backgroundColor;
		this.borderColor = borderColor;
		
		Border border = BorderFactory.createLineBorder(this.borderColor);
		
		this.setBounds(this.posX, this.posY, this.width, this.height);
		this.setBorder(border);
		this.setBackground(this.backgroundColor);
		this.setOpaque(true);
	}
	
	public int getX() {
		return posX;
	}
	
	public int getY() {
		return posY;
	}
	
	public int getWidth() {
		 return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public void setBackgroundColor(Color backgroundColor) {
		this.backgroundColor = backgroundColor;
	}
	
}

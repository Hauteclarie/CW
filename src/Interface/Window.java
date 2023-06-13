package com.Janus.Interface;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;

public abstract class Window extends JFrame {

	private static final long serialVersionUID = -8366296531523781494L;
	
	protected boolean isResizable;
	protected Dimension windowDimension;
	protected Color backgroundColor;
	
	public Window(Dimension windowDimension, Color backgroundColor, boolean isResizable) {
		this.isResizable = isResizable;
		this.windowDimension = windowDimension;
		this.backgroundColor = backgroundColor;
	}
	
	public void innit() {
		
	}
	
}

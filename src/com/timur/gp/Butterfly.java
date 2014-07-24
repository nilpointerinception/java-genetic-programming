package com.timur.gp;

import java.awt.Color;

public class Butterfly {
	
	private Color color;
	private int size;
	
	public Butterfly(int r, int g, int b, int size){
		setColor(new Color(r, g, b));
		this.size = size;
	}


	public Color getColor() {
		return color;
	}


	public void setColor(Color color) {
		this.color = color;
	}


	public int getSize() {
		return size;
	}


	public void setSize(int size) {
		this.size = size;
	}
}

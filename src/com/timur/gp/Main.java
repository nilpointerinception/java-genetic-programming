package com.timur.gp;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JFrame;

import containers.Parents;

public class Main {

	static final int BUTTERFLY_SIZE = 25;
	static ArrayList<Butterfly> butterflies;
	static Input input;

	public static void main(String[] args) {
		input = new Input();
		butterflies = Gene.createButterflies(25, BUTTERFLY_SIZE);
		Parents.setParents(butterflies);

		@SuppressWarnings("serial")
		JFrame frame = new JFrame() {
			@Override
			public void paint(Graphics g) {
				g.drawString("Click anywhere for evolution!", 15, 45);
				try {
					drawButterflies(g, butterflies);
				} catch (InterruptedException e) {
				}

			}

			private void drawButterflies(Graphics g, ArrayList<Butterfly> butterflies)
					throws InterruptedException {
				int paintX = 40;
				int paintY = 60;

				for (Butterfly b : butterflies) {
					int size = b.getSize();
					Color c = b.getColor();

					// Left Wing
					g.setColor(c);
					g.fillOval(paintX - 22, paintY - 5, size, size);
					g.setColor(Color.BLACK);
					g.drawOval(paintX - 22, paintY - 5, size, size);
					g.setColor(c);
					g.fillOval(paintX - 22, paintY + 5, size, size);
					g.setColor(Color.BLACK);
					g.drawOval(paintX - 22, paintY + 5, size, size);

					// Right Wing
					g.setColor(c);
					g.fillOval(paintX + 2, paintY - 5, size, size);
					g.setColor(Color.BLACK);
					g.drawOval(paintX + 2, paintY - 5, size, size);
					g.setColor(c);
					g.fillOval(paintX + 2, paintY + 5, size, size);
					g.setColor(Color.BLACK);
					g.drawOval(paintX + 2, paintY + 5, size, size);

					// Body
					g.setColor(Color.BLACK);
					g.fillOval(paintX, paintY - 5, size / 4, size + 15);

					int xOffset = this.getWidth() - size * 4;
					if (paintX > xOffset) {
						paintX = 40;
						paintY += 45;
					} else {
						paintX += 60;
					}

				}
			}
		};
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(330, 330);
		frame.setLocationRelativeTo(null);
		frame.addKeyListener(input);
		frame.addMouseListener(input);
		frame.setVisible(true);
	}
}

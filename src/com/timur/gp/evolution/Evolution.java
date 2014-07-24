package com.timur.gp.evolution;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;

import com.timur.gp.Butterfly;

import containers.Parents;

public class Evolution {

	private ArrayList<Butterfly> butterflies;

	@SuppressWarnings("unused")
	public Evolution() {
		butterflies = Parents.getParents();
		ArrayList<Butterfly> evolvedButterflies = new ArrayList<>();
		final double MUTATE_RATE = .35D;
		final double ELITE_RATE = .15D;
		final double CROSSOVER_RATE = 1D - MUTATE_RATE - ELITE_RATE;
		ArrayList<Double> scores = new ArrayList<>();

		for (Butterfly b : butterflies) {
			
			Color color = b.getColor();
			int red = color.getRed();
			int green = color.getGreen();
			int blue = color.getBlue();
			double distance = calculateDistance(red, green, blue);
			double score = 1 / distance;
//			System.out.printf("%f = distance  r = %d  g = %d  b = %d  score = %f\n", distance, red,
//					green, blue, score);
			scores.add(score);
		}
		Collections.sort(scores);
		Collections.reverse(scores);
	}

	private double calculateDistance(int r, int g, int b) {
		return 255D - r + g + b;
	}

}

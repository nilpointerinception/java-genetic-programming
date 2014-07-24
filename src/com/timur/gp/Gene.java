package com.timur.gp;

import java.util.ArrayList;
import java.util.Random;

public class Gene {

	public static ArrayList<Butterfly> createButterflies(int numOfButterflies,
			int size) {
		Random rand = new Random();
		ArrayList<Butterfly> butterflies = new ArrayList<Butterfly>();
		for (int i = 0; i < numOfButterflies; i++) {
			int red = rand.nextInt(256);
			int green = rand.nextInt(256);
			int blue = rand.nextInt(256);
			butterflies.add(new Butterfly(red, green, blue, size));
		}
		return butterflies;
	}

}

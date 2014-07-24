package containers;

import java.util.ArrayList;

import com.timur.gp.Butterfly;

public class Parents {
	
	private static ArrayList<Butterfly> butterflies;
	
	public static void setParents(ArrayList<Butterfly> butterflies){
		Parents.butterflies = butterflies;
	}
	public static ArrayList<Butterfly> getParents(){
		return butterflies;
	}
}

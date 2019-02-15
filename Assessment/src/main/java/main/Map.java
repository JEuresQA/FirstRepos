package main;

import java.util.Scanner;

public class Map { // Map object to track the character's position.
	private int horiz;
	private int vert;
	private Scanner input;
	
	public Map(int horizStart, int vertStart) {
		this.setHoriz(horizStart);
		this.setVert(vertStart);
	}
	
	public Map() {
		new Map(0, 0);
	}
	
	public void next() { // Method to ask for input and change position based on it.
		input = new Scanner(System.in);
		String direct = input.nextLine();
		if (direct.equals("north") || direct.equals("n")) {
			this.setVert(this.getVert() + 1);
		} else if (direct.equals("south") || direct.equals("s")) {
			this.setVert(this.getVert() - 1);
		} else if (direct.equals("east") || direct.equals("e")) {
			this.setHoriz(this.getHoriz() + 1);
		} else if (direct.equals("west") || direct.equals("w")) {
			this.setHoriz(this.getHoriz() - 1);
		} else {
			System.out.println("Invalid input! Pick a direction.");
		}
	}

	public int getHoriz() {
		return horiz;
	}

	public void setHoriz(int horiz) {
		this.horiz = horiz;
	}

	public int getVert() {
		return vert;
	}

	public void setVert(int vert) {
		this.vert = vert;
	}
}

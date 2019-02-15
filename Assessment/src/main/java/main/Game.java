package main;

import java.util.Scanner;

public class Game { // Holds the final goal to reach the treasure and processes to run the game.
	private int horizGoal;
	private int vertGoal;
	private static Scanner choice;
	
	public Game(int horizGoal, int vertGoal) {
		this.horizGoal = horizGoal;
		this.vertGoal = vertGoal;
	}
	
	public Game() { // Default values.
		this.horizGoal = 1;
		this.vertGoal = 2;
	}
	public static void start(int horiz, int vert) { // Manually select a goal.
		process(horiz, vert);
	}
	
	public void play() { // Play an already-generated game from the object.
		process(this.horizGoal, this.vertGoal);
	}
	
	private static void process(int h, int v) {
		float distance; // Variable to hold distance from the goal, via Pythagoras.
		Map map = new Map(0, 0); // Initialises Map object to hold the character's position.
		intro();
		while (h != map.getHoriz() || v != map.getVert()) { // Keeps asking for input until you reach the goal.
			distance = (float) Math.sqrt(Math.pow(h-map.getHoriz(), 2) + Math.pow(v-map.getVert(), 2));
			System.out.println("The dial reads '" + distance + "'m");
			map.next();
		}
		System.out.println("You see a box sitting on the plain. It's filled with treasure! You win! The end.");
	}
	
	private static void intro() { // Displays intro text from the email.
		System.out.println("Grey foggy clouds float oppressively close to you,");
		System.out.println("reflected in the murky grey water which reaches up your shins.");
		System.out.println("Some black plants barely poke out of the shallow water.");
		System.out.println("Try \"north\",\"south\",\"east\",or \"west\"");
		System.out.println("You notice a small watch-like device in your left hand.");
		System.out.println("It has hands like a watch, but the hands don't seem to tell time.");
	}
	
	public static void prompt() { // Sends prompt to ask for goal coordinates.
		choice = new Scanner(System.in);
		System.out.println("Please enter a horizontal coordinate for the goal.");
		int chosenH = choice.nextInt();
		System.out.println("Please enter a vertical coordinate for the goal.");
		int chosenV = choice.nextInt();
		process(chosenH, chosenV);
	}
	
	public static void random() {
		int rand1 = (int) (Math.random() * 10); // random integer between 0 and 10 inclusive
		int rand2 = (int) (Math.random() * 10);
		double sign1 = Math.random();
		double sign2 = Math.random();
		if (sign1 < 0.5) {
			rand1 *= -1; // turns negative if the random double is less than 0.5
		}
		if (sign2 < 0.5) {
			rand2 *= -1;
		}
		process(rand1, rand2);
	}
	
	public static void challenge() { // Time-limited "hard mode" that gives you a game over if you don't make it in time.
		int h = (int) (Math.random() * 10);
		int v = (int) (Math.random() * 10);
		double signH = Math.random();
		double signV = Math.random();
		if (signH < 0.5) {
			h *= -1; 
		}
		if (signV < 0.5) {
			v *= -1;
		}
		float distance;
		Map map = new Map(0, 0);
		int counter = Math.abs(h) + Math.abs(v) + 5; // Timer gives enough moves to make a mistake and correct it on each axis.
		intro();
		while ((h != map.getHoriz() || v != map.getVert()) && counter > 0) {
			distance = (float) Math.sqrt(Math.pow(h-map.getHoriz(), 2) + Math.pow(v-map.getVert(), 2));
			System.out.println("The dial reads '" + distance + "'m");
			map.next();
			counter--;
		}
		if (counter == 0) {
			System.out.println("Sorry, you didn't make it to the treasure in time. You lose! GAME OVER");
		} else {
			System.out.println("You see a box sitting on the plain. It's filled with treasure! You win! The end.");
		}
	}
}

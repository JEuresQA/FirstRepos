package main;

public class Main {

	public static void main(String[] args) {
		Game game1 = new Game();
		game1.play();
		Game game2 = new Game(1, 2);
		game2.play();
		Game.start(1, 2);
		// The above should all result in the same game, which has the goal placement from the example.
		Game.start(-5, -2); // Using a different goal placement
		Game.start(0, 0); // Starts a game on the goal, for an instant win.
		Game.prompt(); // Starts a game with a prompt to put coordinates for the goal
		Game.random(); // Starts a game with a randomly-placed goal.
		Game.challenge(); // Starts a time-limited "hard mode" game, also with a random goal.
	}
}

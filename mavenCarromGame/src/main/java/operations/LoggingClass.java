package operations;

import java.util.logging.Level;
import java.util.logging.Logger;

import entities.Players;

public class LoggingClass {

	public static void display(Players player1, Players player2) {

		final Logger LOGGER = Logger.getLogger(LoggingClass.class.getName());

		LOGGER.log(Level.INFO, "Player1 has:: " + player1.getPoints() + " Points");
		LOGGER.log(Level.INFO, "Player 2 has:: " + player2.getPoints() + " Points");
		if (player1.getPoints() > player2.getPoints() && (player1.getPoints() - player2.getPoints()) >= 3
				&& player1.getPoints() >= 5) {
			LOGGER.log(Level.INFO, player1.getName() + " Wins");
		} else if (player2.getPoints() > player1.getPoints() && (player2.getPoints() - player1.getPoints()) >= 3
				&& player2.getPoints() >= 5) {
			LOGGER.log(Level.INFO, player2.getName() + " Wins");
		} else {
			LOGGER.log(Level.INFO, "Match Draw between" + player1.getName() + " and " + player2.getName());
		}
	}

	public static void displayListOfMoves() {

		final Logger LOGGER = Logger.getLogger(LoggingClass.class.getName());
		LOGGER.log(Level.INFO,"Enter choice 1. Strike\r\n" + "2. Multistrike\r\n" + "3. Red strike\r\n" + "4. Striker strike\r\n"
				+ "5. Defunct coin\r\n" + "6. None");
	}
}

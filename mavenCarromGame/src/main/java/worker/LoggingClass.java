package worker;

import entities.Players;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class LoggingClass {
	final static Logger LOGGER = LogManager.getLogger(AvailabilityCheck.class.getName());

	/**
	 * 
	 * @param player1
	 * @param player2
	 * 
	 *                This function displays the output of the game.
	 */
	public static void display(Players player1, Players player2) {

		LOGGER.info(player1.getName() + " has:: " + player1.getPoints() + " Points");
		LOGGER.info(player2.getName() + " has:: " + player2.getPoints() + " Points");
		if (player1.getPoints() > player2.getPoints() && (player1.getPoints() - player2.getPoints()) >= 3
				&& player1.getPoints() >= 5) {
			LOGGER.info(player1.getName() + " Wins");
		} else if (player2.getPoints() > player1.getPoints() && (player2.getPoints() - player1.getPoints()) >= 3
				&& player2.getPoints() >= 5) {
			LOGGER.info(player2.getName() + " Wins");
		} else {
			LOGGER.info("Match Draw between " + player1.getName() + " and " + player2.getName());
		}
	}

	/**
	 * 
	 * @param file
	 * @return
	 * 
	 *         This function helps to choose the move the the user will play.
	 */
	public static String getNameOfMove(File file) {

		String result = null;
		Random rand = new Random();
		int n = 0;
		try {
			for (Scanner sc = new Scanner(file); sc.hasNext();) {
				++n;
				String line = sc.nextLine();
				if (rand.nextInt(n) == 0)
					result = line;
			}
		} catch (FileNotFoundException fileNotFoundException) {
			LOGGER.error("Not a valid file path  " + fileNotFoundException);
		}

		return result;

	}
}

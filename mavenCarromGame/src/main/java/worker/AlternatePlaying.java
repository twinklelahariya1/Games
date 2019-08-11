package worker;

import entities.Coins;
import entities.Players;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * 
 * @author twinkle.lahariya
 * 
 *         This function performs toss between the players to decide who goes
 *         first
 */
public class AlternatePlaying {

	final static Logger LOGGER = LogManager.getLogger(AvailabilityCheck.class.getName());

	public static void BreakerDecider() {

		Players playerA = new Players();
		Players playerB = new Players();

		playerA.setName("Tom");
		playerB.setName("Jerry");

		LOGGER.info("Players in the match :: PlayerA :: " + playerA.getName() + " :::: " + " PlayerB:: "
				+ playerB.getName());

		if (Math.random() < 0.5) {
			LOGGER.info("Player A plays First");
			turnAlternator(playerA, playerB);

		} else {
			LOGGER.info("Player B plays First");
			turnAlternator(playerB, playerA);
		}
	}

	/**
	 * 
	 * @param player1
	 * @param player2
	 * 
	 *                The function sends both the players into the game one after
	 *                the other while checking conditions each time they are suppose
	 *                to play
	 */

	private static void turnAlternator(Players player1, Players player2) {

		Coins coins = Coins.getInstance();

		while ((coins.getBlack() + coins.getRed() > 0)

				&& !(player1.getPoints() >= 5 && player1.getPoints() - player2.getPoints() >= 3)
				&& !(player2.getPoints() >= 5 && player2.getPoints() - player1.getPoints() >= 3)) {

			LOGGER.info(player1.getName() + "'s Turn");
			PointsComputation.pointsCalculate(player1, coins);

			if (!(coins.getBlack() + coins.getRed() > 0)

					&& (player1.getPoints() >= 5 && player1.getPoints() - player2.getPoints() >= 3)
					&& (player2.getPoints() >= 5 && player2.getPoints() - player1.getPoints() >= 3))
				break;

			LOGGER.info(player2.getName() + "'s Turn");
			PointsComputation.pointsCalculate(player2, coins);

		}

		// LoggingClass displays the result of the match
		LoggingClass.display(player1, player2);
	}

}
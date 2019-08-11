package worker;

import entities.Coins;
import entities.Players;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;

public class PointsComputation {

	final static Logger LOGGER = LogManager.getLogger(PointsComputation.class.getName());

	/**
	 * 
	 * @param player
	 * @param coins
	 * 
	 *               Player into the game chooses a move randomly and gets points
	 *               accordingly
	 */
	public static void pointsCalculate(Players player, Coins coins) {

		// Call to getNameOfMove gives one random move name that is played by the user
		String nameOfMove = LoggingClass.getNameOfMove(new File("D:\\AssignmentDemo\\File2.txt"));
		LOGGER.info(player.getName() + "'s present points:: " + player.getPoints());
		LOGGER.info(player.getName() + " played " + nameOfMove);

		switch (nameOfMove) {
		case "strike":
			AvailabilityCheck.availabilityOfBlack(player, coins);
			break;
		case "multiStrike":
			AvailabilityCheck.availabilityOfCoins(player, coins);
			break;
		case "redStrike":
			AvailabilityCheck.availabilityOfRed(player, coins);
			break;
		case "strikerStrike":
			Compute.strikerStrike(player, coins);
			break;
		case "defunctCoin":
			Compute.defunctCoin(player, coins);
			break;
		case "none":
			Compute.none(player, coins);
			break;
		default:
			LOGGER.info("Wrong choice");
			break;
		}
	}

}

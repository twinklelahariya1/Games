package worker;

import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import entities.Coins;
import entities.Players;

/**
 * 
 * @author twinkle.lahariya
 *
 *         This function checks availablity of coins onto the board before
 *         playing them
 */
public class AvailabilityCheck {

	final static Logger LOGGER = LogManager.getLogger(AvailabilityCheck.class.getName());

	public static void availabilityOfBlack(Players player, Coins coins) {

		if (coins.getBlack() > 0) {
			Compute.strike(player, coins);
		} else
			LOGGER.info("No black left");
	}

	public static void availabilityOfRed(Players player, Coins coins) {

		if (coins.getRed() > 0) {
			Compute.redStrike(player, coins);
		} else
			LOGGER.info("No red left");
	}

	public static void availabilityOfCoins(Players player, Coins coins) {

		Random rand = new Random();
		int numberOfCoins = (2 + rand.nextInt(5));

		if (coins.getBlack() >= numberOfCoins) {
			Compute.multiStrike(player, coins, numberOfCoins);
		} else
			LOGGER.info("No black left");

	}

}

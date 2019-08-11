import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import entities.*;

public class AvailabilityCheck {

	public static void availabilityOfBlack(Players player, Coins coins) {

		final Logger LOGGER = Logger.getLogger(AvailabilityCheck.class.getName());

		if (coins.getBlack() > 0) {
			Compute.strike(player, coins);
		} else
			LOGGER.log(Level.INFO, "no black left");
	}

	public static void availabilityOfRed(Players player, Coins coins) {

		final Logger LOGGER = Logger.getLogger(AvailabilityCheck.class.getName());

		if (coins.getRed() > 0) {
			Compute.red_Strike(player, coins);
		} else
			LOGGER.log(Level.INFO, "no red left");
	}

	public static void availabilityOfCoins(Players player, Coins coins) {

		final Logger LOGGER = Logger.getLogger(AvailabilityCheck.class.getName());

		LOGGER.log(Level.INFO, "Enter the number of coins pocketed");

		Scanner numberOfMultiStrikes = new Scanner(System.in);
		int numberOfCoins = numberOfMultiStrikes.nextInt();

		if (coins.getBlack() >= numberOfCoins) {
			Compute.multi_Strike(player, coins, numberOfCoins);
		} else
			LOGGER.log(Level.INFO, "no black left");

	}

}

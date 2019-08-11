package operations;

import java.util.logging.Level;
import java.util.logging.Logger;

import entities.*;

public class AlternatePlaying {

	private static final Logger LOGGER = Logger.getLogger(AlternatePlaying.class.getName());

	public static void BreakerDecider() {

		Players playerA = new Players();
		Players playerB = new Players();

		playerA.setName("Adam");
		playerB.setName("Eve");

		if (Math.random() < 0.5) {
			LOGGER.log(Level.INFO, "Player A plays First");
			turnAlternator(playerA, playerB);

		} else {
			LOGGER.log(Level.INFO, "Player B plays First");
			turnAlternator(playerB, playerA);
		}
	}

	private static void turnAlternator(Players player1, Players player2) {

		Coins coins = Coins.getInstance();

		while ((coins.getBlack() + coins.getRed() > 0)

				&& !(player1.getPoints() >= 5 && player1.getPoints() - player2.getPoints() >= 3)
				&& !(player2.getPoints() >= 5 && player2.getPoints() - player1.getPoints() >= 3)) {

			LOGGER.log(Level.INFO, player1.getName() + "'s Turn");
			PointsComputator.calculate(player1, coins);

			if (!(coins.getBlack() + coins.getRed() > 0)

					&& (player1.getPoints() >= 5 && player1.getPoints() - player2.getPoints() >= 3)
					&& (player2.getPoints() >= 5 && player2.getPoints() - player1.getPoints() >= 3))
				break;

			LOGGER.log(Level.INFO, player2.getName() + "'s Turn");
			PointsComputator.calculate(player2, coins);

			LoggingClass.display(player1, player2);
		}

	}

}
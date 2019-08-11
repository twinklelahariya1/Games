package worker;

import entities.*;

/**
 * 
 * @author twinkle.lahariya
 *
 *         This class is responsible to set the points obtained by the player in
 *         the game according to the rules of the game.
 */
public class Compute {

	public static void strike(Players player, Coins coins) {
		coins.setBlack(coins.getBlack() - 1);
		player.setPoints(player.getPoints() + 1);
		coins.setFoulPoints(0);
	}

	public static void multiStrike(Players player, Coins coins, int numberOfCoins) {
		player.setPoints(player.getPoints() + 2);
		coins.setRed(1);
		coins.setBlack(7);
		coins.setFoulPoints(0);
	}

	public static void redStrike(Players player, Coins coins) {
		coins.setRed(0);
		player.setPoints(player.getPoints() + 3);
		coins.setFoulPoints(0);
	}

	public static void strikerStrike(Players player, Coins coins) {
		player.setPoints(player.getPoints() - 1);
		coins.setFoulPoints(coins.getFoulPoints() + 1);

	}

	public static void defunctCoin(Players player, Coins coins) {
		player.setPoints(player.getPoints() - 2);
		coins.setBlack(coins.getBlack() - 1);
		coins.setFoulPoints(coins.getFoulPoints() + 1);
	}

	public static void none(Players player, Coins coins) {

		if (coins.getFoulPoints() >= 3) {
			player.setPoints(player.getPoints() - 1);
		}

	}

}

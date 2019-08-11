package operations;

import entities.*;

public class Compute {

	public static void strike(Players player, Coins coins) {
		coins.setBlack(coins.getBlack() - 1);
		player.setPoints(player.getPoints() + 1);
		coins.setFoulPoints(0);
	}

	public static void multi_Strike(Players player, Coins coins, int numberOfCoins) {
		player.setPoints(player.getPoints() + 2);
		coins.setRed(1);
		coins.setBlack(7);
		coins.setFoulPoints(0);
	}

	public static void red_Strike(Players player, Coins coins) {
		coins.setRed(0);
		player.setPoints(player.getPoints() + 3);
		coins.setFoulPoints(0);
	}

	public static void striker_Strike(Players player, Coins coins) {
		player.setPoints(player.getPoints() - 1);
		coins.setFoulPoints(coins.getFoulPoints() + 1);

	}

	public static void defunct_Coin(Players player, Coins coins) {
		player.setPoints(player.getPoints() - 2);
		coins.setBlack(coins.getBlack()-1);
		coins.setFoulPoints(coins.getFoulPoints() + 1);
	}

	public static void none(Players player, Coins coins) {

		if (coins.getFoulPoints() >= 3) {
			player.setPoints(player.getPoints() - 1);
		}

	}

}

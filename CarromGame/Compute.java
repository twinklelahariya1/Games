import entities.*;

public class Compute {

	public static void strike(Players player, Coins coins) {
		coins.setBlack(coins.getBlack() - 1);
		player.setPoints(player.getPoints() + 1);
	}

	public static void multi_Strike(Players player, Coins coins, int numberOfCoins) {
		player.setPoints(player.getPoints() + 2);
		coins.setRed(1);
		coins.setBlack((9 - coins.getBlack()) + (numberOfCoins - 2));
	}

	public static void red_Strike(Players player, Coins coins) {
		coins.setRed(0);
		player.setPoints(player.getPoints() + 3);
	}

	public static void striker_Strike(Players player, Coins coins) {
		player.setPoints(player.getPoints() - 1);
	}

	public static void defunct_Coin(Players player, Coins coins) {
		player.setPoints(player.getPoints() - 2);
	}

	public static void none(Players player, Coins coins) {
		player.setPoints(player.getPoints() - 1);

	}

}

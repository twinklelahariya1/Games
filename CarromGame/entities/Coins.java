package entities;

public class Coins {

	private int black = 9;
	private int red = 1;
	private int striker = 1;
	private int totalCoinsOnBoard = 10;

	private int foulPoints = 0;

	private static Coins object = null;

	private Coins() {
	}

	public static Coins getInstance() {
		if (object == null) {
			object = new Coins();
		}
		return object;
	}

	public int getBlack() {
		return black;
	}

	public void setBlack(int black) {
		this.black = black;
	}

	public int getRed() {
		return red;
	}

	public void setRed(int red) {
		this.red = red;
	}

	public int getStriker() {
		return striker;
	}

	public void setStriker(int striker) {
		this.striker = striker;
	}

	public int getTotalCoinsOnBoard() {
		return totalCoinsOnBoard;
	}

	public void setTotalCoinsOnBoard(int totalCoinsOnBoard) {
		this.totalCoinsOnBoard = totalCoinsOnBoard;
	}

	public int getFoulPoints() {
		return foulPoints;
	}

	public void setFoulPoints(int foulPoints) {
		this.foulPoints = foulPoints;
	}

}
import java.util.Scanner;

import entities.*;

public class PointsComputator {

	public static void calculate(Players player, Coins coins) {

		System.out.println("Enter choice 1. Strike\r\n" + "2. Multistrike\r\n" + "3. Red strike\r\n"
				+ "4. Striker strike\r\n" + "5. Defunct coin\r\n" + "6. None");
		Scanner scanner = new Scanner(System.in);
		int choice = scanner.nextInt();

		switch (choice) {
		case 1:
			AvailabilityCheck.availabilityOfBlack(player, coins);
//			System.out.println("Blacks::" +coins.getBlack());
			break;
		case 2:
			AvailabilityCheck.availabilityOfCoins(player, coins);
			break;
		case 3:
			AvailabilityCheck.availabilityOfRed(player, coins);
			break;
		case 4:
			Compute.striker_Strike(player, coins);
			break;
		case 5:
			Compute.defunct_Coin(player, coins);
			break;
		case 6:
			Compute.none(player, coins);
			break;
		default:
			System.out.println("Wrong choice");
			break;
		}
	}

}

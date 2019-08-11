import java.util.Scanner;

import entities.*;

public class AvailabilityCheck {

	public static void availabilityOfBlack(Players player, Coins coins) {
		if(coins.getBlack()!=0) {
			Compute.strike(player, coins);
		}
	}
	
	

	public static void availabilityOfRed(Players player, Coins coins) {
		if(coins.getRed()!=0) {
			Compute.red_Strike(player, coins);
		}
		
	}



	public static void availabilityOfCoins(Players player, Coins coins) {
		
		System.out.println("Enter the number of coins pocketed");
		Scanner sr = new Scanner(System.in);
		int numberOfCoins=sr.nextInt();
		
		if(coins.getBlack()>=numberOfCoins) {
			Compute.multi_Strike(player, coins,numberOfCoins);
		}
		
	}
	
	
	
}

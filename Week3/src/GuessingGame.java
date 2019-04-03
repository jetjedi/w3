import java.util.Scanner;

public class GuessingGame {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
			
		int num = (int)(Math.random() * 1000);
		
		//add 1 if random number turns out to be 0
		if (num == 0)
			num += 1;
		
		System.out.println("Answer is: " + num);
		
		System.out.print("Guess a number between 1 and 1000: ");
		int myGuess = input.nextInt();
		
		while(myGuess != num) {
			if (myGuess < num)
				System.out.println("Too Low\n");
			else if (myGuess > num)
				System.out.println("Too High\n");
			
			System.out.print("Guess a number between 1 and 1000: ");
			myGuess = input.nextInt(); //grab a new number
		}
		System.out.println("Winner Winner Chicken Dinner " + myGuess + " is correct!");

	}

}

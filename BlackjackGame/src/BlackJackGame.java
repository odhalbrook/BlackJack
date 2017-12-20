import java.util.Scanner;

public class BlackJackGame
	{
		static	String [] suit = new String [4];
		static	String [] card = new String [13];
		
		public static void main(String[] args)
			{
				
				greetUser();
				defineCard();
				gameStart();
			}

		

		private static void greetUser()
			{
				Scanner userInput = new Scanner(System.in);
				System.out.println("What is your name?");
				String name = userInput.nextLine();
				
				int randomNum = (int) (Math.random( ) * 3);
				
				String [] comp = new String [4];
				comp [0] = ", you look like you've been hitting the gym lately.";
				comp [1] = ", I like your backpack.";
				comp [2] = ", you look great today.";
				comp [3] = ", you look very good today.";
				
				System.out.println(name + comp[randomNum]);
				
			}

		public static void defineCard()
			{
			
				
				suit[0] = "hearts";
				suit[1] = "diamonds";
				suit[2] = "clubs";
				suit[3] = "spades";
			
				card[0]="one";
				card[1]="two";
				card[2]="three";
				card[3]="four";
				card[4]="five";
				card[5]="six";
				card[6]="seven";
				card[7]="eight";
				card[8]="nine";
				card[9]="ten";
				card[10]="Jack";
				card[11]="Queen";
				card[12]="King";
				
			}
		public static void gameStart()
			{
				system.out.println("hello world");
				
			}

	}

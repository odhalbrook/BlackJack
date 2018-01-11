import java.util.Scanner;

public class BlackJackGame
	{
		static	String [] card = new String [13];
		static int playerHand = 0;
		static int dealerHand = 0;
		static int randomNum;
		static int value;
		static Scanner userInput = new Scanner(System.in);
		
		public static void main(String[] args)
			{
				//greetUser();
				defineCard();
				assignValue();
				gameStart();
				dealCardPlayer();
				dealCardDealer();
				

			}

		public static void greetUser()
			{
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
			
				card[0]="Ace";
				card[1]="Two";
				card[2]="Three";
				card[3]="Four";
				card[4]="Five";
				card[5]="Six";
				card[6]="Seven";
				card[7]="Eight";
				card[8]="Nine";
				card[9]="Ten";
				card[10]="Jack";
				card[11]="Queen";
				card[12]="King";
		
			}
		public static void assignValue()
			{
				switch (card[randomNum])
		        {
		        	case "Ace":
		        			{
		        		value = 1;
		        		break;
		        			}
		        	case "Two":
		        			{
		        		value = 2;
		        		break;
		        			}
		        	case "Three":
		        			{
		        		value = 3;
		        		break;
		        			}
		        	case "Four":
		        			{
		        		value = 4;	
		        		break;
		        			}
		        	case "Five":
		        			{
		        		value = 5;
		        		break;
		        			}
		        	case "Six":
		        			{
		        		value = 6;
		        		break;
		        			}
		        	case "Seven":
		        			{
		        		value = 7;
		        		break;
		        			}
		        	case "Eight":
		        			{
		        		value = 8;
		        		break;
		        			}
		        	case "Nine":
		        			{
		        		value = 9;
		        		break;
		        			}
		        	case "Ten":
		        	case "Jack":
		        	case "Queen":
		        	case "King":
		        			{
		        		value = 10;
		        		break;
		        			}
		        }
		}	

		
		public static String dealCardPlayer()
			{
				randomNum = (int) (Math.random() * 13);
				assignValue();
				playerHand += value;
				return (card[randomNum]);
				
			}

		public static String dealCardDealer()
			{
				randomNum = (int) (Math.random() * 13);
				assignValue();
				dealerHand += value;
				return (card[randomNum]);
				
			}

		public static void gameStart()
			{
				System.out.println("Welcome to Blackjack");
				
				System.out.println("You have been dealt a " + dealCardPlayer() + " and a " + dealCardPlayer());
				if(playerHand == 21 || card[0].equals(21))
					{
						System.out.println("You have a BlackJack, you WIN!");
						System.exit(0);
					}
				System.out.println("Which equals " + playerHand);
				System.out.println("The dealer has a face down card and is showing a " + dealCardDealer());
			}

	}

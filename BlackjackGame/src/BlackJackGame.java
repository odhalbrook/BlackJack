import java.util.Scanner;

public class BlackJackGame
	{
		static	String [] card = new String [13];
		static int playerHand = 0;
		static int dealerHand = 0;
		static int randomNum;
		static int value;
		static Scanner userInput = new Scanner(System.in);
		static boolean playerAce = false;
		static boolean dealerAce = false;
		static boolean dealerBust = false;
		
		public static void main(String[] args)
			{
				//greetUser();
				defineCard();
				assignValue();
				gameStart();
				playerTurn();
				dealerTurn();
				results();
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
		        		value = 11;
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
		        		default: 
		        				{
		        					value = 0;
		        				}
		        			}
		        }
			

		
		public static String dealCardPlayer()
			{
				randomNum = (int) (Math.random() * 13);
				if (card[randomNum].equals("Ace"))
					{
						playerAce = true;
					}
				assignValue();
				playerHand += value;
				return (card[randomNum]);
				
			}

		public static String dealCardDealer()
			{
				randomNum = (int) (Math.random() * 13);
				if (card[randomNum].equals("Ace"))
					{
						dealerAce = true;
					}
				assignValue();
				dealerHand += value;
				return (card[randomNum]);
				
			}

		public static void gameStart()
			{
				System.out.println("Welcome to Blackjack");
				
				System.out.println("Do you want to check the deck?");
				String yesNo = userInput.nextLine();
				
				if(yesNo.equals("yes") || yesNo.equals("Yes"))
					{
						for (String c : card)
							{
								System.out.println(c + " of Spades");
								System.out.println(c + " of Clubs");
								System.out.println(c + " of Diamonds");
								System.out.println(c + " of Hearts");
							}
					}
				
				System.out.println("You have been dealt a " + dealCardPlayer() + " and a " + dealCardPlayer());
				System.out.println("Which equals " + playerHand);
				if(playerHand == 21)
					{
						System.out.println("You have a BlackJack, you WIN!");
						System.exit(0);
					}
				if (playerHand > 21)
					{
						playerHand = playerHand - 10;
					}
				dealCardDealer();
				System.out.println("The dealer has a face down card and is showing a " + dealCardDealer());
				if(dealerHand == 21)
					{
						System.out.println("The Dealer has a Blackjack, you lose.");
						System.exit(0);
					}
				if (dealerHand > 21)
					{
						dealerHand = dealerHand - 10;
					}
			}

		public static void playerTurn()
			{
				boolean playing = true;
				
				while (playing)
					{
						System.out.println("Do you want to Hit or Stay?");
						String answer = userInput.nextLine();
						
						if(answer.equals("Stay") || answer.equals("stay"))
							{
								playing = false;
								break;
							}
						else if(answer.equals("Hit") || answer.equals("hit"))
							{
								
								System.out.println("You have been dealt a " + dealCardPlayer() + " for a total of " + playerHand);
								if (playerHand > 21 && playerAce == true)
									{
										playerHand = playerHand - 10;
										playerAce = false;
									}
								if (playerHand > 21)
									{
										System.out.println("You busted");
										playing = false;
									}
							}
					}
				
			}
		

		private static void dealerTurn()
			{
				boolean dealerPlaying = true;
				
				while(dealerPlaying)
					{
					if(dealerHand >= 21)
						{
							dealerPlaying = false;
							dealerBust = true;
						}
					else if(dealerHand <= 16)
						{
							dealCardDealer();
						}
					else if(dealerHand >= 17)
						{
							dealerPlaying = false;
						}
					}
			}


		private static void results()
			{
				if(playerHand > dealerHand && dealerBust == false)
					{
						System.out.println("The dealer had a " + dealerHand + " and you had a " + playerHand + ", You win!!!");
					}
				else if(dealerHand > playerHand && dealerBust == false)
					{
						System.out.println("The dealer had a " + dealerHand + " and you had a " + playerHand + ", You lose :(");
					}
			}

		
	}

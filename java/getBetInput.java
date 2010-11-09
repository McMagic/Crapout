public int[] getBetInput(int betID) {
		//Declare and init string variables that store user input
		String str = ""; 
		String amt = "";
		
		
		//Get user input and save input into betInput
		BufferedReader keyboard = 
			new BufferedReader(new InputStreamReader(System.in)); 
		
		
		
		switch (betID) {
			  case 0: //Pass Line Bet 
				//Declare myBets array
				int[] myBets = new int[1];
				
			  	while (true) {
					//Prompt user
					System.out.println("Would you like to make a Passline Bet? (y/n)");
					System.out.println("NOTE: Must have minimum Passline Bet of $5 in order to roll");
					Sytem.out.println("Current amount on pass line: " + passLineBet.betAmount);
					
					//Read in Choice from user
					str = keyboard.readLine();
					
					
					//If user wants to make passline bet
					if (str.equals("y") ) {
						System.out.println("Please enter the amount for the Passline Bet: ");
						amt = keyboard.readLine();
						//Read value into array
						myBets[0] = Integer.parseInt(amt);
						
						return myBets;
					}
					//else if user does not want to make passline bet
					else if (str.equals("n") ) {
						myBets[0] = -1;
						
						return myBets;
					}
					//If y or n was not typed in 
					else {
						System.out.println("This is not a valid input. Please type in valid input.");
					}
				}
				break;
			  case 1: //Dont Pass Line Bet
				//Declare myBets array
				int[] myBets = new int[1];
				
				while (true) {
					//Prompt user
					System.out.println("Would you like to make a Don't Pass Line Bet? (y/n)");
					Sytem.out.println("Current amount on Don't Pass Line Bet: " + dontPassLineBet.betAmount);
					
					//Read in Choice from user
					str = keyboard.readLine();
					
					//If user wants to make passline bet
					if (str.equals("y") ) {
						System.out.println("Please enter the amount for the Don't Pass Line Bet: ");
						amt = keyboard.readLine();
						//Read value into array
						myBets[0] = Integer.parseInt(amt);
						
						return myBets;
					}
					//else if user does not want to make passline bet
					else if (str.equals("n") ) {
						myBets[0] = -1;
						
						return myBets;
					}
					//If y or n was not typed in 
					else {
						System.out.println("This is not a valid input. Please type in valid input.");
					}
				}
				break;
				
			  default: //Default case do nothing
		} //End of switch block

	}
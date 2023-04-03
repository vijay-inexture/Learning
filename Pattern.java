import java.util.Scanner;

class Pattern{
	public static void main(String args[]){
	
		Scanner scanner = new Scanner(System.in);
		boolean flag = true;
		boolean invalidInput = false;
		String input;
		String choice;
		String userWantExit;
		int size;
		int userChoice = 0;
		
		//check until user want to exit
		while(flag){

			//check until user provide valid input
			do{
				
				System.out.println("Enter number: ");
				input = scanner.nextLine();
				
				//check if user enter Invalid number
				if(!isNumber(input)) {
					invalidInput = true;
				}else {
					invalidInput = false;
				}
				
			}while(invalidInput);
			
			
			size = Integer.parseInt(input); 
		
			System.out.println("you enter number: "+size+"\n");
			
			//check until user provide valid choice
			do {
				System.out.println("Enter your choice");
				System.out.println("1. Clockwise Matrix (Enter 1)");
				System.out.println("2. Anti-clockwise Matrix (Enter 2)");
				
				choice = scanner.nextLine();
				
				//check if user enter Invalid number
				if(!isNumber(choice)) {
					invalidInput = true;
					System.out.println("Please enter valid Choice!");
				}else {
					userChoice = Integer.parseInt(choice);
					if(userChoice==1 || userChoice==2) {
						invalidInput = false;
					}else {
						invalidInput = true;
						System.out.println("Please enter valid Choice!");
					}
				}
				
			}while(invalidInput);
			
			
			System.out.println("you choose option: "+userChoice+"\n");
			
			switch(userChoice) {
			
				case 1:	
					clockwiseMatrix(size);
					break;
				case 2:	
					antiClockwiseMatrix(size);
					break;
				default: 
					System.out.println("Enter valid choice");
					break;
						
			}
			
			//ask user for exit
			System.out.println("\nYou want to exit? (y/n)");
			userWantExit = scanner.nextLine();
			
			if(userWantExit.equals("Y") || userWantExit.equals("y")) {
				System.out.println("-------> Exit from system");
				System.out.println("-------> Thank you");
				flag = false;	
			}
			
		}
		scanner.close();	
		
	}
	
	public static boolean isNumber(String input) {
		try {
		    int intValue = Integer.parseInt(input);
		    return true;
		} catch (NumberFormatException e) {
			System.out.println(input+" is Invalid input, Please enter valid input! \n");
		    return false;
		}
	}

	public static void clockwiseMatrix(int size) {
		System.out.println("clockwiseMatrix size: "+size);
		int startRow = 0;
		int startCol = 0;
		int endRow = size;
		int endCol = size;
		int num = 1;
		int array[][] = new int[size][size];
		
		while(startRow<endRow && startCol<endCol) {
			
		     // Print the first row from the remaining rows in top
		     for (int col = startCol; col < endCol; col++) {
			array[startRow][col] = num;
			num++;
		    }
		    startRow++;
		    
		    
		    // Print the last column from the remaining columns
		    for (int row = startRow; row < endRow; row++) {
		    	array[row][endCol-1] = num;
		    	num++;
		        
		    }
		    endCol--;
		    
		    // Print the last row from the remaining rows 
		    if (startRow<endRow) {
		        for (int col = endCol - 1; col >= startCol; col--) {
		        	array[endRow-1][col] = num;
		        	num++;
		        }
		        endRow--;
		    }
		    
		    // Print the first column from the remaining columns 
		    if (startCol < endCol) {
		        for (int row = endRow - 1; row >= startRow; row--) {
		        	array[row][startCol] = num;
		        	num++;
		        }
		        startCol++;
		    }
		}
		
		//print matrix
		printMatrix(array, size);
		
	}
	
	public static void antiClockwiseMatrix(int size) {
		System.out.println("Anti-clockwiseMatrix size: "+size);
		int startRow = 0;
		int startCol = 0;
		int endRow = size;
		int endCol = size;
		int num = 1;
		int array[][] = new int[size][size];
		
		while(startRow<endRow && startCol<endCol) {
			
			// Print the first row from the remaining rows in top
			for(int col=endCol-1;col>=startCol;col--) {
				array[startRow][col] = num;
				num++;
			}
			startRow++;
			
			// Print the first column from the remaining columns 
			for(int row=startRow;row<endRow;row++) {
				array[row][startCol] = num;
				num++;
			}
			startCol++;
			
			// Print the last row from the remaining rows 
			if(startRow<endRow) {
				for(int col=startCol;col<endCol;col++) {
					array[endRow-1][col] = num;
					num++;
				}
				endRow--;
			}
			
			// Print the last column from the remaining columns
			if(startCol<endCol) {
				for(int row=endRow-1;row>=startRow;row--) {
					array[row][endCol-1] = num;
					num++;
				}
				endCol--;
			}
			
		}
		
		//print matrix
		printMatrix(array, size);
		
	}

	public static void printMatrix(int[][] array, int size) {
		for(int row=0;row<size;row++) {
			for(int col=0;col<size;col++) {
				System.out.print(array[row][col]+" ");
			}
			System.out.println();
		}		
	}
}


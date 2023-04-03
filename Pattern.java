import java.util.Scanner;

class Pattern{
	public static void main(String args[]){
	
		Scanner scanner = new Scanner(System.in);
		boolean flag = true;
		boolean invalidSize = false;
		boolean invalidChoice = false;
		String input;
		String choice;
		String userWantExit;
		int size;
		int userChoice = 0;
		
		//iterate if user provide invalid input or want to use again
		do {
			System.out.println("Enter size: ");
			input = scanner.nextLine();
			
			System.out.println("Enter your choice");
			System.out.println("1. Clockwise Matrix (Enter 1)");
			System.out.println("2. Anti-clockwise Matrix (Enter 2)");
			choice = scanner.nextLine();
			
			//check user provided data is valid or not
			if(!isNumber(input)) {
				invalidSize = true;
				System.out.println("Invalid Size!");
			}
			else if(!isNumber(choice)) {
				invalidChoice = true;
				System.out.println("Invalid Choice!");
			}else {
				userChoice = Integer.parseInt(choice);
				if(userChoice==1 || userChoice==2) {
					invalidSize = false;
					invalidChoice = false;
				}else {
					invalidChoice = true;
					System.out.println("Invalid Choice!");
				}
			}
			
			if(!invalidSize && !invalidChoice) {
				size = Integer.parseInt(input); 
				System.out.println("you enter number: "+size+"\n");
				System.out.println("you choose option: "+userChoice+"\n");
				
				matrix(size, userChoice);
				
				//ask user for exit
				System.out.println("\nYou want to exit? (y/n)");
				userWantExit = scanner.nextLine();
				
				if(userWantExit.equals("Y") || userWantExit.equals("y")) {
					System.out.println("-------> Exit from system");
					System.out.println("-------> Thank you");
					flag = false;	
				}
			}
		}while(invalidSize || invalidChoice || flag);
		
		scanner.close();	
		
	}

	public static boolean isNumber(String input) {
		try {
		    int intValue = Integer.parseInt(input);
		    return true;
		} catch (NumberFormatException e) {
		    return false;
		}
	}

	public static void matrix(int size,int userChoice) {
		int startRow = 0;
		int startCol = 0;
		int endRow = size;
		int endCol = size;
		int num = 1;
		int array[][] = new int[size][size];
		
		try {
			if(userChoice==1) {
				array = clockwiseMatrix(startRow, startCol, endRow, endCol, num, array);
			}else {
				array = antiClockwiseMatrix(startRow, startCol, endRow, endCol, num, array);
			}
		} catch (Exception e) {
			System.out.println("Issue with Generating Matrix!");
			System.out.println(e.getMessage());
		}
		
		try {
			printMatrix(array, size);
		} catch (Exception e) {
			System.out.println("Issue with Displaying Matrix!");
			System.out.println(e.getMessage());
		}
		
	}
	
	public static int[][] clockwiseMatrix(int startRow, int startCol, int endRow, int endCol, int num,
			int[][] array) {
		
		if(startRow<endRow && startCol<endCol) {
			
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
		    
		    clockwiseMatrix(startRow, startCol, endRow, endCol, num, array);
		}
		return array;
	}

	public static int[][] antiClockwiseMatrix(int startRow, int startCol, int endRow, int endCol, int num,
			int[][] array) {
		if(startRow<endRow && startCol<endCol) {
			
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
			
			antiClockwiseMatrix(startRow, startCol, endRow, endCol, num, array);
		}
		return array;
	}
	
	public static void printMatrix(int[][] array, int size) {
		int maxLength = String.valueOf(size*size).length();
		for(int row=0;row<size;row++) {
			for(int col=0;col<size;col++) {
				
				//add extra space before matrix element for proper visibility
				int valueInt = array[row][col];
				String valueString = String.valueOf(valueInt);
				int length = valueString.length();
				if(length<maxLength) {
					valueString = String.format("%" + (maxLength - length) + "s", " ") + valueString;
				}
				
				System.out.print(valueString+" ");
			}
			System.out.println();
		}			
	}

}




/***************************************************************  
*  file: KnightsOnABoard.java
*  author: Kevin Wong  
*  class: CS 1400 – Intro to Programming and Problem Solving  
*  
*  assignment: program 5  
*  date last modified: 4/18/2022 
*  
*  purpose: This program asks the user for the name of an input file. It checks if the file exists 
*           or if the file contains valid data. If the file is invalid, or if there are not 8 lines 
*           of 8 integers, an error message is printed and it asks the user to enter a valid input 
*           file again. If it passes both of these tests, it checks if each integer is a 1 or a 0.
*           A message is printed alerting the user that values greater than 1 have been found and will be converted to
*           1 and/or that values smaller than 0 have been found and will be converted to 0.
*	    The data is then used to represent knights on a chessboard where 1’s represent where a 
*           knight is placed and 0’s represent an empty square. A method returns true if the knights 
*           are placed on a chessboard in such a manner that no knight can capture another knight. The 
*           2D array is displayed and a message is printed stating whether knights were able to be
*           captured by another knight/other knights.
*	     	
****************************************************************/

import java.util.Scanner;
import java.io.File;
import java.io.*;

public class KnightsOnABoard
{
    //method: main
	//purpose: This method is the entry point from where execution starts. It
    //creates an instance of our Board class, then it prompts the user for a file name and loops through
    //validateFile and validateData until we read in and create a valid 2D chess board array with
    //populateBoard. It then uses printBoard to display the 2D array and calls cannotCapture and prints a
    //message to the screen based on the true or false response.
	
	public static void main(String[] args) throws IOException {
	Board board = new Board();
	
	//method: print
	//purpose: This method prints the text on the console.
	    
	System.out.print("Please enter the name of a valid file: ");
	Scanner scnr = new Scanner(System.in);
	String fileName = scnr.nextLine();
	File file = new File(fileName);
	File newFile = board.validateFile(file);
	
	int[][] boardArray = new int[8][8];
	
	boolean dataValidation = board.validateData(newFile);
	
	
	   while (dataValidation == false) {
	   System.out.print("Please enter the name of a valid file: ");
	   scnr = new Scanner(System.in);
	   fileName = scnr.nextLine();
	   file = new File(fileName);
	   newFile = board.validateFile(file);
	   dataValidation = board.validateData(newFile);
	   if (dataValidation == true) {
	        break;
	    }
	   }
	

	
	if (dataValidation == true) {
	    System.out.print("The board looks as follows:");
	    boardArray = board.populateBoard(newFile);
	    board.printBoard(boardArray);
	    boolean captureStatus = board.cannotCapture(boardArray);
	
	if (captureStatus == false) {
	    //method: println
		//purpose: This method prints the text on the console and the cursor remains at the start of the next line at the console.
	    System.out.println("\nThere is at least one knight which can capture another knight.");
	}
	else if (captureStatus == true) {
	    System.out.println("\nNo knights can capture any other knight.");
	}
	
	}
	
	

	    
	
	
	}

    
}










class Board {
    
    
    
    public Board(){
        
    }
    
    //method: validateFile
	//purpose: This method checks to see if the given file exists. If the input
    //file does not existthe method will give an error message and ask the user for another file name until a
    //valid one is given. It will then return file only if it is valid.
	
    public File validateFile(File inputFile) {
        File userFile;
        userFile = inputFile;
        
    //method: exists
	//purpose: This function determines whether the file given by the filename exists or not. 
	//	   The function returns true if the file path exists or else it returns false.
	
    while (!userFile.exists()) {
    System.out.println("File does not exist!");
    System.out.print("Please enter the name of a valid file: ");
	Scanner scnr2 = new Scanner(System.in);
	String fileName = scnr2.nextLine();
	File newUserFile = new File(fileName);
	
	if (newUserFile.exists()) {
	return newUserFile;
	}
	    
    }
    
    return userFile;
    }
    
    //method: validateData
	//purpose: This method validates the data from the input file, or
    //prints an error message if there is not 8 lines of 8 integers. It returns true if the data is valid 
    //or false if the date is invalid.
    
     public boolean validateData(File inputFile) throws IOException {
        Scanner rowCounter = new Scanner(inputFile);
        Scanner intCounter = new Scanner(inputFile);
        Scanner scnr = new Scanner(inputFile);
        int intCount = 0;
        int rowCount = 0;
        String rowInput;
        int intInput;
        String charInput;
        boolean intOverload = false;
        boolean intUnderload = false;
        
    //method: hasNext
	//purpose: This is a method of the Java Scanner class which returns true if and only 
	//if the scanner has another token in its input. 
        
        while (scnr.hasNext()) {
            charInput = scnr.next();
        
        for (int i = 0; i < 1; i++) {
            
    //method: isLetter
	//purpose: This method determines if the specified character is a letter.
	        
            if (Character.isLetter(charInput.charAt(i))) {
                System.out.println("File has invalid data.");
                return false;
            }
        }
            
        }
        
        while (intCounter.hasNext()) {
            
    //method: nextInt
    //purpose: This method scans the next token of the input as a int value.

            intInput = intCounter.nextInt();
            intCount++;
            
            if (intCount > 64) {
                intOverload = true;
                break;
            }
            
            if (intInput < 0) {
                intInput = -1;
            }
            
            if (intInput > 1) {
                intInput = 2;
            }
        
        }
        
        if (intCount < 64) {
                intUnderload = true;
            }
        
        while (rowCounter.hasNext()) {
            
    //method: nextLine
    //purpose: This method pushes the scanner past the current line and returns the input that was skipped.
    
		    rowInput = rowCounter.nextLine();
		    rowCount++;
		    }
		if(rowCount!=8 || intOverload == true || intUnderload == true) {
		    System.out.println("File has invalid data.");
		    return false;
		}
		else {
		    return true;
		}
        
    }
    
    //method: populateBoard
    //purpose: This method reads through the file that has been
    //validated, then it creates and populates an 8x8 2D array with the information from the file.
    //Any lines of data which are integers but not 1’s or 0’s are corrected and an appropriate message is printed if 
    //needed. It then returns the created array.
    
    public int[][] populateBoard(File inputFile) throws IOException {
        int[][] populatedArray = new int[8][8];
        Scanner arrayScanner = new Scanner(inputFile);
        boolean smallNumber = false;
        boolean bigNumber = false;
        
    for (int i = 0; i < 8; i++) {
	   for (int j = 0; j < 8; j++) {
        
	    populatedArray[i][j] = arrayScanner.nextInt();
	    if (populatedArray[i][j] > 1) {
	        populatedArray[i][j] = 1;
	        bigNumber = true;
	    }
	    if (populatedArray[i][j] < 0) {
	        populatedArray[i][j] = 0;
	        smallNumber = true;
	    }
	    
	        }
	    }
	    if (bigNumber == true) {
	        System.out.print("\nInteger larger than 1 found. It has been converted to 1.");
	    }
	    if (smallNumber == true) {
	        System.out.print("\nInteger smaller than 0 found. It has been converted to 0.");
	    }
	    
	return populatedArray;
	
    }
    
    //method: cannotCapture
    //purpose: This method computes if the knights are placed on
    //the chessboard in such a manner that no knight can capture another knight. It returns true if no knight can
    //capture any other knight, or false if one or more knights can capture another knight.
    
    public boolean cannotCapture(int[][] chessBoard) throws IOException {
    for (int i = 0; i < 8; i++) {
	   for (int j = 0; j < 8; j++) { 
    
        if ((i < 6) && (j < 7)) {
            if ((chessBoard[i+2][j+1] == 1) && (chessBoard[i][j] == 1)) {
            return false;
            }
        }
        
        if ((i < 7) && (j < 6)) {
        if ((chessBoard[i+1][j+2] == 1) && (chessBoard[i][j] == 1)) {
            return false;
            }
        }
        
        if ((i > 0) && (j < 6)) {
        if ((chessBoard[i-1][j+2] == 1) && (chessBoard[i][j] == 1)) {
            return false;
            }
        }
        
        if ((i > 1) && (j < 7)) {
        if ((chessBoard[i-2][j+1] == 1) && (chessBoard[i][j] == 1)) {
            return false;
            }
        }
        
        if ((i > 1) && (j > 0)) {
        if ((chessBoard[i-2][j-1] == 1) && (chessBoard[i][j] == 1)) {
            return false;
            }
        }
        
        if ((i > 0) && (j > 1)) {
        if ((chessBoard[i-1][j-2] == 1) && (chessBoard[i][j] == 1)) {
            return false;
            }
        }
        
        if ((i < 7) && (j > 1)) {
        if ((chessBoard[i+1][j-2] == 1) && (chessBoard[i][j] == 1)) {
            return false;
            }
        }
        
        if ((i < 6) && (j > 0)) {
        if ((chessBoard[i+2][j-1] == 1) && (chessBoard[i][j] == 1)) {
            return false;
            }
        }
        
        
    }
        }
        return true;
    }
    
    //method: printBoard
    //purpose: This method displays the 2D array to the screen.
    
    public void printBoard(int[][] chessBoard) {
        System.out.print("\n");
    for (int i = 0; i < 8; i++) {
	   for (int j = 0; j < 8; j++) {
        if ((i == 0) && (j == 0)) {
            System.out.print(chessBoard[i][j] + " ");
        }
        else if ((j==7)) {
            System.out.print(chessBoard[i][j] + "\n");
        }
        else {
	        System.out.print(chessBoard[i][j] + " ");
        }
	   
	        }
	    }
    }

    
}
# Knights On A Board

## Overview

The "Knights On A Board" program is a Java application designed to determine if knights placed on a chessboard are positioned in such a way that no knight can capture another knight. It reads an input file containing the arrangement of knights on the chessboard, validates the data, populates a 2D array representing the chessboard, and checks if the knights can capture each other.

This program was developed as part of the CS 1400 - Intro to Programming and Problem Solving course, and it serves as Program 5.

## Usage

1. Compile the Java program using a Java compiler, such as `javac`:

   ```
   javac KnightsOnABoard.java
   ```

2. Run the compiled program:

   ```
   java KnightsOnABoard
   ```

3. The program will prompt you to enter the name of a valid file that contains the chessboard arrangement.

4. Enter the file name and press Enter.

5. The program will validate the file, its data, and populate the chessboard array.

6. After populating the chessboard, it will display the chessboard layout.

7. Finally, it will determine whether any knight can capture another knight and display the result.

## File Validation

The program performs the following file validation steps:

- Checks if the file exists.
- Verifies that the file contains exactly 8 lines of 8 integers (0 or 1).
- Corrects any integers larger than 1 to 1.
- Corrects any integers smaller than 0 to 0.

## Chessboard Layout

The chessboard layout is displayed to the console with 0 representing an empty cell and 1 representing a knight. The layout is shown as an 8x8 grid.

## Knight Capture Check

The program checks the arrangement of knights on the chessboard to determine whether any knight can capture another knight. It checks all possible knight moves to see if there are any pairs of knights that can capture each other.

## Error Handling

The program provides appropriate error messages and prompts for file input until a valid file is provided.

## Note

- Ensure that your input file contains valid data representing the chessboard with knights (0 for empty cells, 1 for knights).
- The program assumes a standard 8x8 chessboard.

## Author

- **Author**: Kevin Wong

## Date Last Modified

- **Date Last Modified**: April 18, 2022

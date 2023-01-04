# Knights-On-A-Board

Purpose: This program asks the user for the name of an input file. It checks if the file exists 
or if the file contains valid data. If the file is invalid, or if there are not 8 lines 
of 8 integers, an error message is printed and it asks the user to enter a valid input 
file again. If it passes both of these tests, it checks if each integer is a 1 or a 0.
A message is printed alerting the user that values greater than 1 have been found and will be converted to
1 and/or that values smaller than 0 have been found and will be converted to 0.
The data is then used to represent knights on a chessboard where 1’s represent where a 
knight is placed and 0’s represent an empty square. A method returns true if the knights 
are placed on a chessboard in such a manner that no knight can capture another knight. The 
2D array is displayed and a message is printed stating whether knights were able to be
captured by another knight/other knights.

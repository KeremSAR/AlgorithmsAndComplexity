# Finding Number of Island
* The purpose of this project is the find out how many shapes there are and how these 
shapes are formed in the 2D matrix. Also, how to read 2D matrix from a “.txt” file and how to 
write output to a “.txt” file. Java JDK 8 programming language is used with Apache NetBeans 
IDE 12.5 environment to build the algorithms of this assignment. All algorithms will be 
explaining in the following content.

* Depth-First search (DFS) algorithm is used to detect the shapes on the given 2D matrix. DFS 
is the searching algorithm that goes deep in each branch before moving to explore another 
branch. In the assignment 1’s searched in the 2D array using two for loops. In OutputShapes() 
when a 1 is found it goes deep to search other neighbors in 8 different traversal and changes its 
value to different state. Same state of elements positions adds in stateQueue to print the shapes 
in correct positions. OutputShape() has O(𝑛4) complexity.

* In the PrintShape() method the 
positions of the stateQueue elements 
extracted from the queue and searched 
for the maximum elements of row and 
column to detect exact border of the 
shape. 

* Then, the x left and y up distances between the shape and the 2D matrix boundary are founded.
All distance values put into queues. To find how much should the shape slide to printed  
![image](https://user-images.githubusercontent.com/98567140/174307491-8f5cab3e-84c6-42eb-a3e0-21c41eb011db.png) 
* Properly, the x and y distance values are put into arrays and the values are sorted using the 
bubble sort algorithm and the shape shifted by the smallest distances of x and y. If the distances 
is 0 there is no need to shift the shape stays at the same location. If the distances are different 
than 0 the shape shifts to left for x axis and shifts to up for y axis.
* To print the shape after shifting to proper position, the new bounds of the shape should be set to get 
rid of unnecessary zeros. Subtracting the shift amount from the older row and column length of the 
shape gives proper bounds and prints “*” when the pixel is equal to currentState if it is not equal to 
currentState prints one empty space. PrintShape() has O(𝑛2) complexity.
* ReadShapeFile() method is used to read the given input of 2D matrix from a “.txt” file. In the 
method all the elements of 2D matrix in “.txt” file scanned and bounds of matrix detected. Then, 
all the elements of matrix parsed and putted into M[][] global variable. ReadShapeFile() has 
O(𝑛2) complexity.
OutputShapeToFile() method is used to print the shapes into a”.txt” file. In the method 
system.out directory is changed to given path of “.txt” file and OutputShapes() method called 
after changing path. OutputShapeToFile() has O(𝑛4) complexity.
In this assignment detecting shapes in giving position works correct. But while shifting the 
shapes to first place some pixels can be disappears because of the border detection algorithm 
should be improved when giving a shape that touch each other from corners or edges in 2D
matrix %10 of the shape printing wrong. But %90 of the inputs works correct. For the giving 
input for this assignment is printing in correct order.


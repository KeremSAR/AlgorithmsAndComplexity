# Avl Tree Implemantation
* The purpose of this project is the find out how to build AVL Tree data structure to 
store large numbers of elements and searching fastest way it’s possible. Java JDK 8 
programming language is used with Apache NetBeans IDE 12.5 environment to build the 
algorithms of this assignment. All algorithms will be explained in the following content.
* insertStudent() method adds the given id numbers as AVL tree methodology. The 
functions written as recursive way. If inserting id number is smaller than root id, inserts left 
side. If it is greater than the root id, insert right side. BalanceTree() method is called while 
inserting the id numbers. The method checks the height of right and left subtree and subtract 
left from right. If the number is grater than 1 or less than -1 that means balance should be fixed
by rotations. There are four possible distortions to fix. Left-Left, Right-Right, Left-Right, 
Right-left.
* searchStudent() method recursively visits on nodes and compares with the given input
if the input is greater than visited node goes left side. If the input is smaller than the visited node 
goes right side in the balanced tree. If the input cannot be found returns null.
* printSearchPath() method prints the every visited node. The same visiting technique is
used that used in searchStudent() method.
* processFile() method takes every students information of id number, name and surname
from a “.txt” file. First number is the number of students that should be inserted on tree. Every
line reads from the “.txt” file and puts in a array, then every type of information parse and puts 
in different Queues except first two numbers. Then, every elements inserts with using 
insertStudent() method. Second number is the number of students that should be deleted from 
the tree. The id numbers that will be deleted from tree are on the last values of the array. It 
automatically checks the last elements of array and deletes from the tree. Also program asks for 
an id number to test implementation of tree with using printSearchPath() method.
* deleteStudent() method removes the specified element from the tree. The method 
checks every value from the root. When it finds the given id number checks left and right 
subtree of the node if left subtree is null, swaps the value with the right side of the element and 
vice-versa. If both child is not null swaps with the largest element in left subtree. If there is no 
element in the left subtree swaps with the smallest element of right subtree and removes the 
element used element to prevent multiple same nodes. The function returns to balanceTree()
method to prevent distortion.
* In this project, inserting the id numbers and printing them is working correctly. But 
deleteStudent() method has a problem deleting the root. In the method I tried to implement
Hibbard’s Algorithm [2] which is deleting a node by replacing it with its successor[3]. But when trying to delete a node that has two children distorted the tree. In the 
algorithm I take the element always largest element of the right subtree, this should be change 
to some parameters. Because of that deletion operation in processFile() is commented
## REFERENCES
- https://codeskulls.com/ds/avl-tree-rotations “AVL Tree Rotations”.
- https://apex.mpi-sws.org/apex/hibbardalgorithm.html
- http://www.mathcs.emory.edu/~cheung/Courses/253/Syllabus/Trees/AVL-delete.html
“The remove method for the AVL tree”.
- https://algs4.cs.princeton.edu/32bst/ “Order-based methods and deletion ”

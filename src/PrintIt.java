/**
* The PrintIt program is an application that
* extends a Binary Search Tree to store the data entries 
* and outputs the data in alphabetical order after using an inorder traversal.
* This application uses a Person class to create objects of type Person
* which will be stored in the BST.
*
* @author  Muhammad Azhar Rohiman
* @since   03.04.2017
*/

import java.util.*;
import java.io.*;

public class PrintIt extends BinarySearchTree {

	public static void main(String[] args) {

		try {

			Scanner input = new Scanner(System.in);
			Person newPerson;
			BufferedReader fileIn = new BufferedReader(new FileReader("testdata"));

			String line;
			while ((line = fileIn.readLine()) != null ) {
				int positionName = line.indexOf('|', line.indexOf('|') + 1 );
        		int positionAddress = line.indexOf('|');


        		String name = line.substring(positionName+1, line.length());
				String address = line.substring(0, positionAddress);
				String number = line.substring(positionAddress+1, positionName);
				newPerson = new Person(name, address, number);

				// calls insertion method in class BinarySearchTree.java
				treeInsert(newPerson);
			}
			// calls inorder traversal method in class BinarySearchTree.java
			// to print the data entries in alphabetical order.
			treeList(root);
		}

		catch (IOException e) {
			System.out.println("IO Error.");
		}
	}
}
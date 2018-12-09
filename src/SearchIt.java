/**
* The SearchIt program is an application that
* uses a Binary Search Tree to store the data entries and asks for input from the user
* to enter the name of the query file to find specific entries using the names of people
* as key.
*
* @author  Muhammad Azhar Rohiman
* @since   04.04.2017
*/

import java.util.*;
import java.io.*;

public class SearchIt extends BinarySearchTree {

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

			// asks user to enter name of query file.
			System.out.println("Enter name of file to read queries: ");
			String queryFile = input.nextLine();

			BufferedReader queryIn = new BufferedReader(new FileReader(queryFile));

			String queryName;
			while ((queryName = queryIn.readLine()) != null ) {
                // checks if method treeContains has values in the BST or not.
				if (treeContains(root, queryName) != null) {
                    // prints data entry if queryName matches a name in BST.
					System.out.println(treeContains(root, queryName));
				}
				else {
					System.out.println("Not Found");
				}
			}	
		}

		catch (IOException e) {
			System.out.println("IO Error.");
		}
	}
}
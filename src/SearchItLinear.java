/**
* The SearchItLinear program implements an application that
* uses an array to store the data entries and asks for input from the user
* to enter the name of the query file to find specific entries using the names of people
* as key.
*
* @author  Muhammad Azhar Rohiman
* @since   29.03.2017
*/

import java.util.*;
import java.io.*;

public class SearchItLinear {

	public static ArrayList<String> details;
	public static String[] detailsArr;

	public static void main(String[] args) {

		try {

			Scanner input = new Scanner(System.in);
			// initialize arraylist
			details = new ArrayList<String>();
			BufferedReader fileIn = new BufferedReader(new FileReader("testdata"));

			String line;
			while ((line = fileIn.readLine()) != null ) {
				// store data in arraylist because its dynamic and can accomodate
				// for entries without making copies of array.
				details.add(line);
			}

			// convert arraylist to array
			detailsArr = details.toArray(new String[details.size()]);

			// asks user to enter name of query file.
			System.out.println("Enter name of file to read queries: ");
			String queryFile = input.nextLine();

			BufferedReader queryIn = new BufferedReader(new FileReader(queryFile));

			String queryName;
			while ((queryName = queryIn.readLine()) != null ) {
				// calls for method searchName to search for queryName in array
				// containing data entries.
				System.out.println(searchName(detailsArr, queryName));
			}	
		}

		catch (IOException e) {
			System.out.println("IO Error.");
		}
	}

	/** method with two parameters (array containing data entries and name to find
	* in entries)
	*/
	public static String searchName(String[] detailsArr, String queryName) {

		for (int i=0; i<detailsArr.length; i++) {

			String entry = detailsArr[i];

			// finds position of second '|'
        	int position = entry.indexOf('|', entry.indexOf('|') + 1 );

        	// extract name from data entry
        	String name = entry.substring(position+1, entry.length());

        	// compares queryName against name in data entry.
        	// return whole data entry is name is found,
        	// else return "Not Found"
        	if (queryName.equals(name)) {
        		return detailsArr[i];
        	}
        	else {
        		continue;
        	}
		}
		return "Not Found";
	}
}
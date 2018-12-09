import java.util.*;
import java.io.*;

public class QueryFile {

	public static void main(String[] args) {

		try {

			ArrayList<String> details = new ArrayList<String>();
			Scanner input = new Scanner(System.in);
			BufferedReader fileIn = new BufferedReader(new FileReader("testdata"));
			PrintWriter writer = new PrintWriter("Query", "UTF-8");

			String line;
			while ((line = fileIn.readLine()) != null ) {
				int positionName = line.indexOf('|', line.indexOf('|') + 1 );

				String name = line.substring(positionName+1, line.length());

				details.add(name);
			}
			for (int i=0; i<details.size(); i++) {
				writer.print(details.get(i));
				if (i == details.size()-1) {
					break;
				}
				writer.println();
			}
			writer.close();
		}

		catch (IOException e) {
			System.out.println("IO Error.");
		}
	}
}
/**
* The Person class has instance variables to store the data entries by separating them
* into name, number and address. It has a toString method to return the data entry in its
* original form.
*
* @author  Muhammad Azhar Rohiman
* @since   03.04.2017
*/

class Person {

	String name;
	String address;
	String number;

	// constructor to initialize instance variables when an
	// object of Type is created.
	public Person(String name, String address, String number) {
		this.name = name;
		this.address = address;
		this.number = number;
	}

	// getters
	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public String getNumber() {
		return number;
	}

	// toString method to return data entry in its original form.
	public String toString() {
		return address + "|" + number + "|" + name;
	}
}
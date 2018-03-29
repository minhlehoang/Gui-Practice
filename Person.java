package PA07;

import PA07.Address;

public abstract class Person {
	String firstname; // example, Jim
	String lastName; // example, Miller
	Address address;  
	String phoneNumber; // example, (970) 421-1212. No need to code to verify the format of the phone number, other than it not being blank, or not empty
	String emailAddress; // example, jim@gmail.com. No need to code to verify the format of the email address, other than it not being blank, or not empty

	public static int numberOfPersons=0; 
	
    // add the constructor with data fields
	public Person(String firstname, String lastName, Address address, String phoneNumber, String emailAddress) {
		this.firstname = firstname;
		this.lastName = lastName;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.emailAddress = emailAddress;
		numberOfPersons++;
	}
	// This is an abstract method
	public abstract String toString();
	
	
	public int compareTo(Person per) {
		int comparevalue = this.lastName.compareTo(per.lastName);
		if(comparevalue > 0) {
			return 1;
		}
		else if(comparevalue < 0) {
			return -1;
		}
		else {
			return 0;
		}
	}
}

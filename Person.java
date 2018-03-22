package PA07; 

public abstract class Person {
	String firstname; // example, Jim
	String lastName; // example, Miller
	Address address;  
	String phoneNumber; // example, (970) 421-1212. No need to code to verify the format of the phone number, other than it not being blank, or not empty
	String emailAddress; // example, jim@gmail.com. No need to code to verify the format of the email address, other than it not being blank, or not empty

	
    // add the constructor with data fields
	

	// This is an abstract method
	public abstract String toString();
}

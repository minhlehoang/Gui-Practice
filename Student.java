
package PA07; 

public class Student extends Person{
	

	private String status; // Values are Freshman, Sophomore, Junior, Senior 
	
	Student(String firstname, String lastName, Address address, String phoneNumber, String emailAddress, String status){
		// call the super class constructor to pass the Person data fields	
		
		this.status = status;
	}
	
	// Override the abstract method from Person
	@Override
	public String toString() {

		return null;
	}

}

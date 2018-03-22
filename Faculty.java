package PA07; 

public class Faculty extends Person{
	

	
	private String rankOfFaculty; // values are Lecturer, Assistant Professor, Associate professor, Professor
	private MyDate appointmentDate;
	
	Faculty(String firstname, String lastName, Address address, String phoneNumber, String emailAddress, String rankOfFaculty, MyDate appointmentDate){
		// call the super class constructor to pass the Person data fields	
		
		this.rankOfFaculty = rankOfFaculty; // values are Lecturer, Assistant Professor, Associate Professor, Professor
		this.appointmentDate = appointmentDate;		
	}

	// Override the abstract method from Person
	@Override
	public String toString() {
		return firstname + " , "+ lastName + " , " + address.toString() + " , " + phoneNumber + " , " + emailAddress + " , " + rankOfFaculty +" , " + appointmentDate;
	}

}

package PA07;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JFrame;

public class UserGUI extends JFrame implements ActionListener{
	
	static Person[] personArray;
	
	// declare all GUI components below
	private JLabel firstname;
	private JTextField firstname_field;
	private JLabel lastname;
	private JTextField lastname_field;
	private JLabel address;
	private JTextField address_field;
	private JLabel city;
	private JTextField city_field;
	private JLabel state;
	private JTextField state_field;
	private JLabel zipcode;
	private JTextField zipcode_field;
	
	
	// constructor
	UserGUI(int nPersons){
		// create person array of size nPersons
		personArray = new Person[nPersons];
		
		//Initialize the components
		initComponenet();
		
		//Organize the GUI components
		doTheLayout();
		
		/*Add the action listeners GUI buttons(add, sort, and display)
		Example: addButton.addActionListener(this);*/
	}//End of constructor
	private void initComponenet(){
		// initialize all user interface components
		firstname = new JLabel("First Name");
		firstname_field = new JTextField("What is your firstname ?");
		lastname = new JLabel("Last Name");
		lastname_field = new JTextField("What is your lastname ?");
		address = new JLabel("Address");
		address_field = new JTextField("What is your address ?");
		city = new JLabel("City");
		city_field = new JTextField("City ?");
		state = new JLabel("State");
		state_field = new JTextField("State ?");
		zipcode = new JLabel("Zipcode");
		zipcode_field = new JTextField("Zipcode ?");
	}
	private void doTheLayout(){
		setLayout(new GridLayout(2, 2, 10, 10));
		// Organize the components into GUI window
		add(firstname);
		add(firstname_field);
		add(lastname);
		add(lastname_field);
		add(address);
		add(address_field);
		add(city);
		add(city_field);
		add(state);
		add(state_field);
		add(zipcode);
		add(zipcode_field);
		}


	@Override
	public void actionPerformed(ActionEvent e) {
	// Call the required button action method according to the action event
	}
	private void addButtonClicked(){
		//Method to implement add button action
		}
	private void sortBnttonClicked() {
		//Method to implement sort button action
		}
	private void displaynttonClicked() throws FileNotFoundException{
		// Method to implement display button action
		// calls the selection sort to sort the personArray
		// displays the array in the text area after sorting
		}
	private void selectionSort() {
		//Method to sort person objects based on last name
		}
	
	public static void main(String[] args) throws FileNotFoundException {
		//declare variables
		int numberOfPersons = 0;
		//Input number of audiences.
		//Create a new GUI
		UserGUI frame = new UserGUI(numberOfPersons);
		//Set GUI frame settings
		frame.setTitle("Student or Faculty");
	    frame.setSize(200, 125);
	    frame.setLocationRelativeTo(null); // Center the frame
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setVisible(true);
	}// end main
}

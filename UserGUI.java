package PA07;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.Scanner;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;

public class UserGUI extends JFrame implements ActionListener{
	static Person[] personArray;
	
	// declare all GUI components below
	private JLabel firstname;
	private JTextField firstname_field;
	private JLabel lastname;
	private JTextField lastname_field;
	private JLabel street;
	private JTextField street_field;
	private JLabel housenumber;
	private JTextField housenumber_field;
	private JLabel city;
	private JTextField city_field;
	private JLabel state;
	private JTextField state_field;
	private JLabel zipcode;
	private JTextField zipcode_field;
	private JLabel phonenumber;
	private JTextField phonenumber_field;
	private JLabel email;
	private JTextField email_field;
	
	private JRadioButton student_radio;
	private JRadioButton faculty_radio;
	private ButtonGroup student_or_faculty_button_group;
	
	private JComboBox student_combobox;
	private JComboBox faculty_combobox;
	
	private String[] student_status_options = {"Please select one of these options", "Freshman", "Sophomore", "Junior", "Senior", "Graduate Student"};
	private String[] faculty_rank_options = {"Please select one of these options", "Lecturer", "Assistant Professor", "Associate Professor", "Professor"};
	
	private JButton add_student_faculty;
	private JButton sort_student_faculty;
	private JButton display_student_faculty;
	
	private JTextArea textarea;
	private JScrollPane jp;
	
	private JPanel main_panel;
	private JPanel info_panel;
	private JPanel student_or_faculty_panel;
	private JPanel status_or_rank_panel;
	//private JPanel textarea_panel;
	private JPanel some_buttons_panel;
	
	String student_status_text;
	String faculty_rank_text;
	
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
		add_student_faculty.addActionListener(this);
		sort_student_faculty.addActionListener(this);
		display_student_faculty.addActionListener(this);
		student_radio.addActionListener(this);
		faculty_radio.addActionListener(this);
	}//End of constructor
	
	private void initComponenet(){
		// initialize all user interface components
		firstname = new JLabel("First Name");
		firstname_field = new JTextField();
		lastname = new JLabel("Last Name");
		lastname_field = new JTextField();
		street = new JLabel("Street Name");
		street_field = new JTextField();
		housenumber = new JLabel("House Number");
		housenumber_field = new JTextField();
		city = new JLabel("City");
		city_field = new JTextField();
		state = new JLabel("State");
		state_field = new JTextField();
		zipcode = new JLabel("Zipcode");
		zipcode_field = new JTextField();
		phonenumber = new JLabel("Phone Number");
		phonenumber_field = new JTextField();
		email = new JLabel("Email");
		email_field = new JTextField();
		
		student_radio = new JRadioButton("Student");
		student_radio.setSelected(true);
		faculty_radio = new JRadioButton("Faculty");
		
		student_or_faculty_button_group = new ButtonGroup();
		student_or_faculty_button_group.add(student_radio);
		student_or_faculty_button_group.add(faculty_radio);	
		
		student_combobox = new JComboBox(student_status_options);
		student_combobox.setVisible(true);		
		faculty_combobox = new JComboBox(faculty_rank_options);
		faculty_combobox.setVisible(false);
		
		textarea = new JTextArea(6,600);
		textarea.setEditable(false);
		textarea.setLineWrap(true);
		textarea.setWrapStyleWord(true);
		
		jp = new JScrollPane(textarea);
		jp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		jp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		add_student_faculty = new JButton("Add Student/Faculty");
		sort_student_faculty = new JButton("Sort Student & Faculty");
		display_student_faculty = new JButton("Display Student & Faculty");
		
		main_panel = new JPanel(new GridLayout(5, 1));
		info_panel = new JPanel(new GridLayout(5, 4));
		student_or_faculty_panel = new JPanel(new GridLayout(2, 1));
		status_or_rank_panel = new JPanel(new GridLayout(1, 1));
		some_buttons_panel = new JPanel(new BorderLayout());
	}
	private void doTheLayout(){
		//setLayout(new GridLayout(8, 2, 10, 10));
		// Organize the components into GUI window
		info_panel.add(firstname);
		info_panel.add(firstname_field);
		info_panel.add(lastname);
		info_panel.add(lastname_field);
		info_panel.add(housenumber);
		info_panel.add(housenumber_field);
		info_panel.add(street);
		info_panel.add(street_field);
		info_panel.add(city);
		info_panel.add(city_field);
		info_panel.add(state);
		info_panel.add(state_field);
		info_panel.add(zipcode);
		info_panel.add(zipcode_field);
		info_panel.add(phonenumber);
		info_panel.add(phonenumber_field);
		info_panel.add(email);
		info_panel.add(email_field);
		
		student_or_faculty_panel.add(student_radio);
		student_or_faculty_panel.add(faculty_radio);
		
		status_or_rank_panel.add(student_combobox);
		
		some_buttons_panel.add(add_student_faculty, BorderLayout.WEST);
		some_buttons_panel.add(sort_student_faculty, BorderLayout.CENTER);
		some_buttons_panel.add(display_student_faculty, BorderLayout.EAST);
		
		main_panel.add(info_panel);
		main_panel.add(student_or_faculty_panel);
		main_panel.add(status_or_rank_panel);
		main_panel.add(jp);
		main_panel.add(some_buttons_panel);
		
		add(main_panel);
		}

	@Override
	public void actionPerformed(ActionEvent e) {
	// Call the required button action method according to the action event
		if(e.getSource() == add_student_faculty) {
			addButtonClicked();
		}
		else if(e.getSource() == sort_student_faculty) {
			sortBnttonClicked();
		}
		else if(e.getSource() == display_student_faculty) {
			try {
				displaynttonClicked();
			} 
			catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(student_radio.isSelected()) {			
			status_or_rank_panel.remove(faculty_combobox);
			status_or_rank_panel.add(student_combobox);
			faculty_combobox.setVisible(false);
			student_combobox.setVisible(true);
		}
		else if(faculty_radio.isSelected()) {
			status_or_rank_panel.remove(student_combobox);
			status_or_rank_panel.add(faculty_combobox);
			student_combobox.setVisible(false);
			faculty_combobox.setVisible(true);
		}
	}
	
	private void addButtonClicked(){
		//Method to implement add button action
		MyDate day_object;
		LocalDate today = LocalDate.now();
		day_object = new MyDate(today.getYear(), today.getMonthValue(), today.getDayOfMonth());
		
		String first_name_text = null;
		String last_name_text = null;
		String street_text = null;
		int housenumber_text = 0;
		String city_text = null;
		String state_text = null;
		int zipcode_text = 0;
		Address address;
		String phonenumber_text = null;
		String email_text = null;
		int option = JOptionPane.YES_OPTION;
		String error_message = "********ERROR******** \n";
		
		if(Person.numberOfPersons < personArray.length ) {
			try {
				first_name_text = firstname_field.getText().trim().substring(0,1).toUpperCase() + firstname_field.getText().trim().substring(1);
				if(first_name_text.length() == 0) {
					throw new Exception();
				}
			}
			catch(Exception ex) {
				error_message += "Please correct your first name. \n";
				firstname_field.requestFocus();
				
			}
			
			try {
				last_name_text = lastname_field.getText().trim().substring(0,1).toUpperCase() + lastname_field.getText().trim().substring(1);
				if(last_name_text.length() == 0) {
					throw new Exception();
				}
			}
			catch(Exception ex) {
				error_message += "Please correct your last name. \n";
				lastname_field.requestFocus();
			}			
			
			try {
				street_text = street_field.getText();
				if(street_text.length() == 0) {
					throw new Exception();
				}
			}
			catch(Exception ex) {
				error_message += "Please correct your street name. \n";
				street_field.requestFocus();				
			}
			
			try {
				housenumber_text = Integer.parseInt(housenumber_field.getText());
				if(housenumber_text < 0) {
					throw new Exception();
				}
			}
			catch(Exception ex) {
				housenumber_field.setText("");
				error_message += "Please correct your house number. \n";
				housenumber_field.requestFocus();				
			}
			
			try {
				city_text = city_field.getText();
				if(city_text.length() == 0) {
					throw new Exception();
				}
			}
			catch(Exception ex) {
				error_message += "Please correct your city. \n";
				city_field.requestFocus();
			}
			
			try {
				state_text = state_field.getText();
				if(state_text.length() == 0) {
					throw new Exception();
				}
			}
			catch(Exception ex) {
				error_message += "Please correct your state. \n";
				state_field.requestFocus();	
			}
			
			try {
				zipcode_text = Integer.parseInt(zipcode_field.getText());
				if(zipcode_text < 0) {
					throw new Exception();
				}
			}
			catch(Exception ex){
				error_message += "Please correct your zipcode. \n";
				zipcode_field.requestFocus();					
			}
			
			try {
				phonenumber_text = phonenumber_field.getText();
				if(phonenumber_text.length() == 0) {
					throw new Exception();
				}
			}
			catch(Exception ex) {
				error_message += "Please correct your phone number. \n";
				phonenumber_field.requestFocus();
			}
			
			try {
				email_text = email_field.getText();
				if(email_text.length() == 0) {
					throw new Exception();
				}
			}
			catch(Exception ex) {
				error_message += "Please correct your email address. \n";
				email_field.requestFocus();	
			}
			if(error_message == "********ERROR******** \n") {
				address =  new Address(street_text, housenumber_text, city_text, state_text, zipcode_text);
				if(student_radio.isSelected()) {
					try {
						student_status_text =  student_combobox.getSelectedItem().toString();	
						if(student_combobox.getSelectedItem().toString() != "Please select one of these options") {
							Person person = new Student(first_name_text, last_name_text, address, phonenumber_text, email_text, student_status_text);
							JOptionPane.showMessageDialog(null, "The person has been added to the array. Here is the information: " + "\n" + person.toString());
							textarea.setText("The person has been added to the array. Here is the information: " + "\n" + person.toString());
							personArray[Person.numberOfPersons - 1] = person;
							firstname_field.setText("");
							lastname_field.setText("");
							street_field.setText("");
							housenumber_field.setText("");
							city_field.setText("");
							state_field.setText("");
							zipcode_field.setText("");
							phonenumber_field.setText("");
							email_field.setText("");
						}
						else {
							throw new Exception();
						}
					}
					catch(Exception ex){
						error_message += "You have not selected your student status yet. Please do it again. \n";
						JOptionPane.showMessageDialog(null, error_message);
						textarea.setText(error_message);
					}
				}
				else if(faculty_radio.isSelected()) {
					try {
						faculty_rank_text = faculty_combobox.getSelectedItem().toString();
						if(faculty_combobox.getSelectedItem().toString() != "Please select one of these options") {
							Person person = new Faculty(first_name_text, last_name_text, address, phonenumber_text, email_text, faculty_rank_text, day_object);
							JOptionPane.showMessageDialog(null, "The person has been added to the array. Here is the information: " + "\n" + person.toString());
							textarea.setText("The person has been added to the array. Here is the information: " + "\n" + person.toString());
							personArray[Person.numberOfPersons - 1] = person;
							firstname_field.setText("");
							lastname_field.setText("");
							street_field.setText("");
							housenumber_field.setText("");
							city_field.setText("");
							state_field.setText("");
							zipcode_field.setText("");
							phonenumber_field.setText("");
							email_field.setText("");
						}
						else{
							throw new Exception();
						}
					}
					catch(Exception ex){
						error_message += "You have not selected your rank yet. Please do it again. \n";
						JOptionPane.showMessageDialog(null, error_message);
						textarea.setText(error_message);
					}
					
				}
			}
			else {
				JOptionPane.showMessageDialog(null, error_message);
				textarea.setText(error_message);
			}
		}
		
		else{
			JOptionPane.showMessageDialog(null, "Your array is already full.");
			textarea.setText("Your array is already full.");
		}
	}
	
	private void sortBnttonClicked() {
		//Method to implement sort button action
		textarea.setText("sort button clicked");
		textarea.append("\n");
		selectionSort();
	}
	
	private void displaynttonClicked() throws FileNotFoundException{
		// Method to implement display button action
		// calls the selection sort to sort the personArray
		// displays the array in the text area after sorting
		String results = null;
		if(Person.numberOfPersons > 0) {	
			textarea.setText("Here is the full list of the array: ");
			textarea.append("\n");
			for(int i = 0; i < Person.numberOfPersons; i++) {
				results = personArray[i].toString();
				textarea.append(results);
				textarea.append("\n");					
			}
		}
		else {
			textarea.setText("There is no person in your list.");
		}
	}
	
	private void selectionSort() {
		if(Person.numberOfPersons > 1) {
			for(int i = 0; i <Person.numberOfPersons; i++) {
				Person currentMin = personArray[i];
				int currentMinIndex = i;
				for(int j = i + 1; j < Person.numberOfPersons; j++) {
					if(currentMin.compareTo(personArray[j]) > 0) {
						currentMin = personArray[j];
						currentMinIndex = j;
					}
				}
				if(currentMinIndex != i) {
					personArray[currentMinIndex] = personArray[i];
					personArray[i] = currentMin;
				}
			}
			textarea.append("Your array has been sorted successfully.");
		}
		else if(Person.numberOfPersons == 1){
			textarea.append("There is only one record in the array. No need to sort.");
		}
		else {
			textarea.append("There is no record in your list. Please add more to sort.");
		}
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		//declare variables
		int numberOfPersons = 0;
		int option = JOptionPane.YES_OPTION;
		while(option == JOptionPane.YES_OPTION) {
			try {
				numberOfPersons = Integer.parseInt(JOptionPane.showInputDialog("How many person ?"));
				//Input number of audiences.				
				if(numberOfPersons < 0) {
					throw new Exception();
				}
				else if(numberOfPersons == 0) {
					JOptionPane.showMessageDialog(null, "Exit program");
					System.exit(0);
				}
				option = 1;
			}
			catch(Exception ex){
				option = JOptionPane.showConfirmDialog(null, "Invalid input! Would you like to try again?");
				if(option != JOptionPane.YES_OPTION) {
					JOptionPane.showMessageDialog(null, "Exit program");
					System.exit(0);
				}
			}
		}
		//Create a new GUI
		UserGUI frame = new UserGUI(numberOfPersons);
		//Set GUI frame settings
		frame.setTitle("Student or Faculty");
	    frame.setSize(600, 600);
	    frame.setLocationRelativeTo(null); // Center the frame
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setVisible(true);
	}// end main
}
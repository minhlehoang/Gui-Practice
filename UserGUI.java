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
		//textarea_panel = new JPanel(new FlowLayout());
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
		
		//textarea_panel.add(textarea);
		
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
		if(Person.numberOfPersons < personArray.length ) {
			//Method to implement add button action
			MyDate day_object;
			LocalDate today = LocalDate.now();
			day_object = new MyDate(today.getYear(), today.getMonthValue(), today.getDayOfMonth());
			
			String first_name_text = firstname_field.getText().trim().substring(0,1).toUpperCase() + firstname_field.getText().trim().substring(1);
			String last_name_text = lastname_field.getText().trim().substring(0,1).toUpperCase() + lastname_field.getText().trim().substring(1);
			String street_text = street_field.getText();
			int housenumber_text = Integer.parseInt(housenumber_field.getText());
			String city_text = city_field.getText();
			String state_text = state_field.getText();
			int zipcode_text = Integer.parseInt(zipcode_field.getText());
			Address address =  new Address(street_text, housenumber_text, city_text, state_text, zipcode_text);
			String phonenumber_text = phonenumber_field.getText();
			String email_text = email_field.getText();
			if(student_radio.isSelected()) {
				student_status_text =  student_combobox.getSelectedItem().toString();			
				if(student_combobox.getSelectedItem().toString() != "Please select one of these options") {
					JOptionPane.showMessageDialog(null, student_status_text);
					Person person = new Student(first_name_text, last_name_text, address, phonenumber_text, email_text, student_status_text);
					JOptionPane.showConfirmDialog(null, Person.numberOfPersons);
					textarea.setText("The person has been added to the array. Here is the information: " + "\n" + person.toString());
					
					personArray[Person.numberOfPersons - 1] = person;
				}
				else {
					JOptionPane.showMessageDialog(null, "do it again" );
				}
			}
			else if(faculty_radio.isSelected()) {
				String faculty_rank_text = faculty_combobox.getSelectedItem().toString();
				JOptionPane.showMessageDialog(null, faculty_rank_text);
				if(faculty_combobox.getSelectedItem().toString() != "Please select one of these options") {
					Person person = new Faculty(first_name_text, last_name_text, address, phonenumber_text, email_text, faculty_rank_text, day_object);
					JOptionPane.showConfirmDialog(null, Person.numberOfPersons);
					textarea.setText("The person has been added to the array. Here is the information: " + "\n" + person.toString());
					personArray[Person.numberOfPersons - 1] = person;
				}
				else {
					JOptionPane.showMessageDialog(null, "do it again");
				}
			}
		}
		else {
			JOptionPane.showMessageDialog(null, "Full");
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
		JOptionPane.showMessageDialog(null, "display button clicked");
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
		int numberOfPersons = Integer.parseInt(JOptionPane.showInputDialog("How many person ?"));
		//Input number of audiences.
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

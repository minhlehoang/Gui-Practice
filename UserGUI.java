package PA07;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
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
	private JLabel address;
	private JTextField address_field;
	private JLabel city;
	private JTextField city_field;
	private JLabel state;
	private JTextField state_field;
	private JLabel zipcode;
	private JTextField zipcode_field;
	private JRadioButton student_radio;
	private JRadioButton faculty_radio;
	private ButtonGroup student_or_faculty_button_group;
	private JComboBox<Object> student_combobox;
	private JComboBox<Object> faculty_combobox;
	private String[] student_status_options = {"Please select one of these options", "Freshman", "Sophomore", "Junior", "Senior", "Graduate Student"};
	private String[] faculty_rank_options = {"Please select one of these options", "Lecturer", "Assistant Professor", "Associate Professor", "Professor"};
	private JButton add_student_faculty;
	private JButton sort_student_faculty;
	private JButton display_student_faculty;
	private JPanel main_panel;
	private JPanel info_panel;
	private JPanel student_or_faculty_panel;
	private JPanel status_or_rank_panel;
	private JPanel some_buttons_panel;
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
		student_radio = new JRadioButton("Student");
		faculty_radio = new JRadioButton("Faculty");
		student_or_faculty_button_group = new ButtonGroup();
		student_or_faculty_button_group.add(student_radio);
		student_or_faculty_button_group.add(faculty_radio);		
		student_combobox = new JComboBox<Object>(student_status_options);
		//student_combobox.setVisible(false);		
		faculty_combobox = new JComboBox<Object>(faculty_rank_options);
		//faculty_combobox.setVisible(false);
		add_student_faculty = new JButton("Add Student/Faculty");
		sort_student_faculty = new JButton("Sort Student & Faculty");
		display_student_faculty = new JButton("Display Student & Faculty");
		main_panel = new JPanel(new GridLayout(4, 1));
		info_panel = new JPanel(new GridLayout(6, 2));
		student_or_faculty_panel = new JPanel(new GridLayout(2, 1));
		status_or_rank_panel = new JPanel(new GridLayout(2, 1));
		some_buttons_panel = new JPanel(new BorderLayout());
	}
	private void doTheLayout(){
		//setLayout(new GridLayout(8, 2, 10, 10));
		// Organize the components into GUI window
		info_panel.add(firstname);
		info_panel.add(firstname_field);
		info_panel.add(lastname);
		info_panel.add(lastname_field);
		info_panel.add(address);
		info_panel.add(address_field);
		info_panel.add(city);
		info_panel.add(city_field);
		info_panel.add(state);
		info_panel.add(state_field);
		info_panel.add(zipcode);
		info_panel.add(zipcode_field);
		student_or_faculty_panel.add(student_radio);
		student_or_faculty_panel.add(faculty_radio);
		status_or_rank_panel.add(student_combobox);
		status_or_rank_panel.add(faculty_combobox);
		some_buttons_panel.add(add_student_faculty, BorderLayout.WEST);
		some_buttons_panel.add(sort_student_faculty, BorderLayout.CENTER);
		some_buttons_panel.add(display_student_faculty, BorderLayout.EAST);
		main_panel.add(info_panel);
		main_panel.add(student_or_faculty_panel);
		main_panel.add(status_or_rank_panel);
		main_panel.add(some_buttons_panel);
		add(main_panel);
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
	    frame.setSize(600, 600);
	    frame.setLocationRelativeTo(null); // Center the frame
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setVisible(true);
	}// end main
}

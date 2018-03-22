package PA07;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JFrame;

public class UserGUI extends JFrame implements ActionListener{
	
	static Person[] personArray;
	
	// declare all GUI components below
	  
				// constructor
				UserGUI(int nPersons){
					
					
					// create person array of size nPersons
					
					//Initialize the components
					initComponenet();

					//Organize the GUI components
					doTheLayout();
					
					/*Add the action listeners GUI buttons(add, sort, and display)
					Example: addButton.addActionListener(this);*/
					
								       		
					
				}//End of constructor

				private void initComponenet(){
				
					  // initialize all user interface components
				      
			  
				}

			   private void doTheLayout(){
					// Organize the components into GUI window

					
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
			
			}// end main
			
	
	}

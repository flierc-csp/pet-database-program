package pet.database.program;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Casey Flier
 * CSC415
 * Assignment 1 - Part 2
 * Created: 2021-11-07
 * Updated: 2021-11-12
 */
public class PetDatabaseMain {

    /**
     * Print the menu and ask the user which option they would like
     * After they have completed the activity, repeat the process until the user chooses option 7
     * @param args
     */
    public static void main(String[] args) {
        Menu menu = new Menu();
        Scanner input = new Scanner(System.in);
        String selectedOption = "";
        
        while(!selectedOption.equals("4")){
            menu.printMenu();
            selectedOption = input.nextLine();
            
            switch(selectedOption){
                case "1" -> Pet.viewAllPets();
                case "2" -> Pet.addPets();
                case "3" -> Pet.removePet();
            }
        }
        
        
        try{
            FileHelper.savePets();
        }catch(IOException ioException){
           System.out.println(ioException.getMessage());
           System.out.println("An error occurred while saving the Pet Database. Pets were not saved."); 
        }
         System.out.println("Goodbye!");        
    }
    
}

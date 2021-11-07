package pet.database.program;
import java.util.Scanner;

/**
 *
 * @author Casey Flier
 * CSC415
 * Assignment 1 - Part 2
 * 2021-11-07
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
        
        while(!selectedOption.equals("7")){
            menu.printMenu();
            selectedOption = input.nextLine();
            
            switch(selectedOption){
                case "1":
                    Pet.viewAllPets();
                    break;
                case "2":
                    Pet.addPets();
                    break;
                case "3":
                    Pet.updatePet();
                    break;
                case "4":
                    Pet.removePet();
                    break;
                case "5":
                    Pet.searchPetsByName();
                    break;
                case "6":
                    Pet.searchPetsByAge();
                    break;
            }
        }
         System.out.println("Goodbye!");        
    }
    
}

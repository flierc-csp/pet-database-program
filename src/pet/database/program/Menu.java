package pet.database.program;

import java.util.ArrayList;

/**
 *
 * @author Casey Flier
 * CSC415
 * Assignment 1 - Part 2
 * 2021-11-07
 */
public class Menu {
    private ArrayList<String> options = new ArrayList<>();
    
    /**
     * On instantiation, add options to the options array
     */
    public Menu(){
        options.add("1) View all pets\n");
        options.add("2) Add more pets\n");
        options.add("3) Remove an existing pet\n");
        options.add("4) Exit program\n");
    }
    
    /**
     * Print instructions and loop-through and print each option
     */
    public void printMenu(){
        System.out.println("Pet Database Program.");
        System.out.println("What would you like to do?");
        
        options.forEach((option) -> {
            System.out.print(option);
        });
        System.out.print("\nYour choice: ");
    }
}

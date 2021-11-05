package com.caseyflier.pet.database.program;
import java.util.Scanner;

/**
 *
 * @author Casey Flier
 * CSC415
 * Assignment 1 - Part 2
 * 2021-11-017
 */
public class PetDatabaseMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Menu menu = new Menu();
        Scanner input = new Scanner(System.in);
        String selectedOption = "";
        
        while(!selectedOption.equals("7")){
            menu.printMenu();
            selectedOption = input.nextLine();
        }
         System.out.println("Goodbye!");        
    }
    
}

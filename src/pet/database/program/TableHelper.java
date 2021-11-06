package pet.database.program;

import java.util.ArrayList;

/**
 *
 * @author Casey Flier
 * CSC415
 * Assignment 1 - Part 2
 * 2021-11-07
 * 
 * 
 * System.out.printf() syntax found at:
 * https://alvinalexander.com/programming/printf-format-cheat-sheet/
 */
public class TableHelper {
    
    private static int ID_WIDTH = 3;
    private static int NAME_WIDTH = 10;
    private static int AGE_WIDTH = 4;
    
    public static void printHeader(){
   
        System.out.print("+-------------------------+\n");
        System.out.print("| ID  | NAME     | AGE   |\n");
        System.out.print("+-------------------------+\n");
    }
    
    public static void printLine(Pet pet){
        System.out.printf("| %-3s | %-10s | %-4s |%n",pet.getId(),pet.getName(),pet.getAge());
    }
    
    public static void printFooter(int petLength){
   
        System.out.print("+------------------------+\n");
        System.out.print(petLength + " rows in set.\n");
    }
}
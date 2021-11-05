package pet.database.program;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Casey Flier
 * CSC415
 * Assignment 1 - Part 2
 * 2021-11-07
 */
public class Pet {
    
    private int id;
    private String name;
    private int age;
    static protected int lastInsertId = 0;
    static protected ArrayList<Pet> pets = new ArrayList<>();
    
    public Pet(String name, int age){
    
        this.id = Pet.lastInsertId++;
        this.name = name;
        this.age = age;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public int getId(){
        return this.id;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public String getName(){
        return this.name;
    }
    
    public void setAge(int age){
        this.age = age;
    }
    
    public int getAge(){
        return this.age;
    }
    
    public static Pet addPet(){
    
        Scanner scanner = new Scanner(System.in);
        System.out.print("add pet(name, age): ");
        
        String input = scanner.nextLine();
        String[] params = input.split(" ");
        
        String name = params[0];
        int age = Integer.parseInt(params[1]);
   
        return new Pet(name, age);      
    }
}

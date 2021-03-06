package pet.database.program;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Casey Flier
 * CSC422
 * Assignment 1 - Part 2
 * Created: 2021-11-07
 * Updated: 2021-11-13
 */
public class Pet implements Serializable{
    
    private int id;
    private String name;
    private int age;
    static protected int lastInsertId = 0;
    static protected ArrayList<Pet> pets = new ArrayList<>();
    
/**
 * Constructor that automatically sets the id
 * @param name
 * @param age 
 */
    public Pet(String name, int age){
    
        this.id = ++Pet.lastInsertId;
        this.name = name;
        this.age = age;    
    }
    
    /**
     * Constructor must be passed an id
     * @param name
     * @param age
     * @param id 
     */
    public Pet(String name, int age, int id){
    
        this.id = id;
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
    
    /**
     * Within a loop, ask user to input a new pet, parse the string, and add it to the array
     */
    public static void addPets(){
    
        String input = "";
        
        while(true){
            Scanner scanner = new Scanner(System.in);
            System.out.print("add pet(name, age):");
            input = scanner.nextLine();
            
            if(input.equals("done")){
                return;
            }else{
                
                if(Pet.pets.size() >= 5){
                    System.out.println("---------------------------");
                    System.out.println("Database is full.");
                    System.out.println("---------------------------");
                    return;
                }
            }
            
            try{
                Pet newPet = Pet.parsePetString(input);                
                Pet.pets.add(newPet);
            }catch(Exception exception){
                System.out.println(exception.getMessage());
            }
        }
    }
    
    /**
     * Parse the string input by the user into a new Pet object.
     * @param input
     * @return
     * @throws Exception 
     */
    private static Pet parsePetString(String input) throws PetFormatException, PetAgeException{
            
        String[] params = input.split(" ");
            
        //There must be both a name and an age, but no more than that.
        if(params.length != 2){
            throw new PetFormatException(input);
       }
            
        String name = params[0];
        int age;
        
        try{
            age = Integer.parseInt(params[1]);
        }catch(NumberFormatException numberFormatException){
            throw new PetFormatException(input);
        }
        
        if(age > 20 | age < 1){
            throw new PetAgeException(age);
        }
        
        return new Pet(name, age);
    }
    
    /**
     * Parse a new pet string, but set the id of the pet to the one provided
     * @param input
     * @param ID
     * @return 
     */
    private static Pet parsePetString(String input, int ID){
    
        String[] params = input.split(" ");

        String name = params[0];
        int age = Integer.parseInt(params[1]);

        return new Pet(name, age, ID);
    }
    
    /**
     * Ask user for a search string, and search the array of pets for matches
     */
    public static void searchPetsByName(){
    
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter name to search:");
        
        String input = scanner.nextLine();
        int resultCount = 0;
        TableHelper.printHeader();
              
        for(Pet pet : Pet.pets){
        
            if(pet.name.contains(input)){
                TableHelper.printLine(pet);
                resultCount ++;
            }
        }
        
        TableHelper.printFooter(resultCount);
    }
    
    /**
     * Ask the user to input an age, and search the array for pets who are that age
     */
    public static void searchPetsByAge(){
    
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter age to search:");
        
        String input = scanner.nextLine();
        int age = Integer.parseInt(input);
            
        
        int resultCount = 0;
        TableHelper.printHeader();
              
        for(Pet pet : Pet.pets){
        
            if(pet.age == age){
                TableHelper.printLine(pet);
                resultCount ++;
            }
        }
        
        TableHelper.printFooter(resultCount);
    }
        
    
    /**
     * List all pets in the array
     */
    public static void viewAllPets(){
        
        TableHelper.printHeader();   
        
        pets.forEach((pet) -> {
           TableHelper.printLine(pet);
        });
        
        TableHelper.printFooter(pets.size());
    }
    
    /**
     * Print all pets, ask the user for the id of the pet to remove, and remove it
     */
    public static void removePet(){
    
        Pet.viewAllPets();
        System.out.print("Enter the pet ID to remove:");
        
        Scanner scanner = new Scanner(System.in);
        
        int petId = 0;
        String input = "";
        
        try{
            input = scanner.nextLine();
            petId = Integer.parseInt(input);
        }catch(NumberFormatException exception){
            System.out.println(input + " is not a valid ID.");
            return;
        }
        
        if(petId < 0){
            System.out.println(input + " is not a valid ID.");
            return;
        }
        
        for(int i=0; i < Pet.pets.size(); i++){
            Pet currentPet = Pet.pets.get(i);
            
            if(currentPet.id == petId){
              pets.remove(i);
              System.out.println(currentPet.name + " " + currentPet.age + " removed.");
              return;
            }
        }
        
        System.out.println("Error: ID " + petId + " does not exist.");
    }
    
    /**
     * Print all pets
     * Ask the user which pet to update
     * Ask the user for a new string
     * Parse the string into a Pet, and set the ID to the one supplied
     * Add the pet to the array
     * Print the changes
     */
    public static void updatePet(){
    
        Pet.viewAllPets();
        
        System.out.print("Enter id of pet to update:");
        
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int updateId = 0;
        int updateIndex = -1;
        
        try{
            updateId = Integer.parseInt(input);
        }catch(NumberFormatException exception){
            System.out.println(input + " is not a valid ID.");
            return;
        }
        
        for(int i=0; i < Pet.pets.size(); i++){
            Pet currentPet = Pet.pets.get(i);
            
            if(currentPet.id == updateId){
              updateIndex = i;
            }
        } 
        
       if(updateIndex == -1){
           System.out.println("Error: ID " + input + " does not exist.");
           return;
       }
       
       System.out.print("Enter new name and age:");
       
       input = scanner.nextLine();
       Pet updatedPet = null;
       
       try{
           updatedPet = Pet.parsePetString(input, updateId);
       }catch(Exception exception){
           System.out.println(exception.getMessage());
           return;
       }
       
       Pet oldPet = Pet.pets.get(updateIndex);
       Pet.pets.set(updateIndex, updatedPet);
       
       System.out.println(oldPet.getName() + " " + oldPet.getAge() + " updated to " + updatedPet.getName() + " " + updatedPet.getAge());
    }
    
    
    /**
     * Loads pets read from file into the protected pets ArrayList
     * @param pets 
     */
    static void loadPets(ArrayList<Pet> pets){
        Pet.pets = pets;
        Pet.setLastInsertId();
    }
    
    /**
     * Find and set the highest id in case of loading from file
     */
    static void setLastInsertId(){
        int lastInsertID = 0;
        for(Pet pet : Pet.pets){
            if(pet.getId() > lastInsertID){
                lastInsertID = pet.getId();
            }
        }
        
        Pet.lastInsertId = lastInsertID;
    }
}

class PetFormatException extends Exception{

    public PetFormatException(String input){
        super("Error: " + input + " is not a valid input.");
    }
}

class PetAgeException extends Exception{
    public PetAgeException(int age){
        super("Error: " + age + " is not a valid age.");
    }
}
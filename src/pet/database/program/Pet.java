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
    
    public static void addPets(){
    
        String input = "";
        
        while(true){
            Scanner scanner = new Scanner(System.in);
            System.out.print("add pet(name, age):");
            input = scanner.nextLine();
            
            if(input.equals("done")){
                return;
            }
            
            try{
                Pet newPet = Pet.parsePetString(input);
                Pet.pets.add(newPet);
            }catch(Exception exception){
                System.out.println("Input is not valid");
            }
        }
    }
    
    private static Pet parsePetString(String input) throws Exception{
            String[] params = input.split(" ");

            String name = params[0];
            int age = Integer.parseInt(params[1]);

           return new Pet(name, age);
    }
    
    private static Pet parsePetString(String input, int ID){
    
        String[] params = input.split(" ");

        String name = params[0];
        int age = Integer.parseInt(params[1]);

        return new Pet(name, age, ID);
    }
    
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
        
    public static void viewAllPets(){
        
        TableHelper.printHeader();   
        
        pets.forEach((pet) -> {
           TableHelper.printLine(pet);
        });
        
        TableHelper.printFooter(pets.size());
    }
    
    public static void removePet(){
    
        Pet.viewAllPets();
        System.out.print("Enter the pet ID to remove:");
        
        Scanner scanner = new Scanner(System.in);
        
        int petId = 0;
        
        try{
            petId = Integer.parseInt(scanner.nextLine());
        }catch(NumberFormatException exception){
            System.out.println("Input is not valid");
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
        
        System.out.println("Pet not removed because it couldn't be found.");
    }
    
    public static void updatePet(){
    
        Pet.viewAllPets();
        
        System.out.print("Enter id of pet to update:");
        
        Scanner scanner = new Scanner(System.in);
        int updateId = 0;
        int updateIndex = -1;
        
        try{
            updateId = Integer.parseInt(scanner.nextLine());
        }catch(NumberFormatException exception){
            System.out.println("Input is not valid");
            return;
        }
        
        for(int i=0; i < Pet.pets.size(); i++){
            Pet currentPet = Pet.pets.get(i);
            
            if(currentPet.id == updateId){
              updateIndex = i;
            }
        } 
        
       if(updateIndex == -1){
           System.out.println("That id was not found.");
           return;
       }
       
       System.out.print("Enter new name and age:");
       
       String input = scanner.nextLine();
       Pet updatedPet = null;
       
       try{
           updatedPet = Pet.parsePetString(input, updateId);
       }catch(Exception exception){
           System.out.println("The update information entered was not valid.");
       }
       
       Pet oldPet = Pet.pets.get(updateIndex);
       Pet.pets.set(updateIndex, updatedPet);
       
       System.out.println(oldPet.getName() + " " + oldPet.getAge() + " updated to " + updatedPet.getName() + " " + updatedPet.getAge());
    }
}

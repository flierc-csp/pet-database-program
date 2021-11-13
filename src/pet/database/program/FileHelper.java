package pet.database.program;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Casey Flier
 * CSC415
 * Assignment 2
 * Created 2021-11-14
 */
public class FileHelper {
    
    static void savePets(ArrayList<Pet> pets) throws IOException{
                    
      //Object wrting pattern found using Netbeans tooltip for Serializable
      FileOutputStream file = new FileOutputStream("./pets.dat");
      ObjectOutputStream outputStream = new ObjectOutputStream(file);

      outputStream.writeObject(pets);
      outputStream.close();
    }
    
    static ArrayList<Pet> readPets() throws IOException, ClassNotFoundException{
    
      FileInputStream file = new FileInputStream("./pets.dat");
      ObjectInputStream inputStream = new ObjectInputStream(file);

      ArrayList<Pet> pets = (ArrayList) inputStream.readObject();
      inputStream.close();
      
      return pets;
    }
}
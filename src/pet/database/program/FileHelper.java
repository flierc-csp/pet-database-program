package pet.database.program;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Casey Flier
 * CSC415
 * Assignment 2
 * Created 2021-11-14
 */
public class FileHelper {
    
    static void savePets() throws IOException{
        
      ArrayList<Pet> pets = Pet.pets;
            
      //Object wrting pattern found using Netbeans tooltip for Serializable
      FileOutputStream file = new FileOutputStream("./pets.dat");
      ObjectOutputStream outputStream = new ObjectOutputStream(file);

      outputStream.writeObject(pets);
      outputStream.close();
    }
}
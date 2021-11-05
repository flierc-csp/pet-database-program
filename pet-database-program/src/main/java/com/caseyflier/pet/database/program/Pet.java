package com.caseyflier.pet.database.program;

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
    
    public Pet(String name, int age){
    
        //I need to update this when Database is implemented
        this.id = 0;
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
     * Handle pet addition to the database
     */
    public static void addNewPet(){
        
    }
}

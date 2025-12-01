/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package videogamescoresapp;

import java.io.IOException;

/**
 *
 * @author zackd
 */
public class StudentClass {
    private final int NUMBER_OF_SCORES = 10;
    private String id;
    private String name;
    private int[] scores;
    
    public StudentClass()
    {
        this.id = "";
        this.name ="";
        this.scores = new int[NUMBER_OF_SCORES];
    }
    public StudentClass(String id, String name, int[] scores)
    {
        
        this.id = id;
        this.name = name;
        this.scores = new int[NUMBER_OF_SCORES];
        
        for (int i = 0; i < this.scores.length; i++){
            this.scores[i] = scores[i];
        }
    }
    
    
    public String getID()
    {
        return this.id;
    }
    
    public String getName()
    {
        return this.name;
    }
    
    public int getScore(int index)
    { 
       int score = this.scores[index];
       return score;
    }
    
    public void setId(String id)
    {
        this.id = id;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public void setScore(int index, int value){
        this.scores[index] = value;
    }
    
    public int getTotal()
    {
        int score;
        int valuescore = 0;
        for(int i = 0; i < scores.length; i++)
        {
            score = scores[i];
            valuescore += score;
        }
        
        return valuescore;
    }
    
    public double getAverage()
    {
        return (1.0)*this.getTotal() / this.scores.length;
    }
    
    public String toDataLine()
    {
        String line = getID() + ", " + getName();
        
        for(int i = 0; i <this.scores.length; i++)
        {
            line = line + ", " + this.scores[i];
        }
        return line;
    }
    
    
    public StudentClass fromDataLine(String lineC) throws IOException{
        
        String[] lineComponents = lineC.split(" , ");
       
        int[] score = new int[NUMBER_OF_SCORES];
        
        for(int i = 0; i < this.scores.length; i++)
        {
            score[i] = Integer.parseInt(lineComponents[i+2]);
            this.scores[i] = score[i];
        }
        
        StudentClass student = new StudentClass((lineComponents[0]), lineComponents[1], score);
        return student; 
    }
    public String ToString()
    {
        String gameString = String.format("%5s - %20s", this.getID(), this.getName());
        return gameString;
    }
     public boolean equals(StudentClass student, int i){
        boolean result = true;
        result = this.getID().equalsIgnoreCase(student.getID()) && this.getName().equalsIgnoreCase(student.getName());
        
         if (this.getScore(i) == student.getScore(i)) {
             result = true;
         }
       
               
        return result;
    }
    
}

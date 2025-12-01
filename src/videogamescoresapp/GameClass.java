/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package videogamescoresapp;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author zackd
 */
public class GameClass{ 
    private int id = 0;
    private String title = "";
    private String genre = "";
    private String publisher = "";
    
    public GameClass()
    {
        this.id = 0;
        this.title = "";
        this.genre = "";
        this.publisher = "";
    }
   
    public GameClass(int id, String title, String genre, String publisher) throws IOException 
    {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.publisher = publisher;
    }
    
    public int getID()
    {
        return this.id;
    }
    public String getTitle()
    {
        return this.title;
    }
    
    public String getGenre()
    {
        return this.genre;
    }
    
    public String getPublisher()
    {
        return this.publisher;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public void setTitle(String title)
    {
        this.title = title;
    }
    
    public void setGenre(String genre)
    {
        this.genre = genre;
    }
    
    public void setPublisher(String publisher)
    {
        this.publisher = publisher;
    }
    
    public String toDataLine()
    {
        String line = getID() + ", " + getTitle() + ", " + getGenre() + ", " + getPublisher();
        return line;
    }
    
    
    public static GameClass fromDataLine(String lineC) throws IOException{
        
        String[] lineComponents = lineC.split(",");
       
       
        GameClass game = new GameClass(Integer.parseInt(lineComponents[0]), lineComponents[1], lineComponents[2], lineComponents[3]);
        return game; 
    }
    
    public String ToString()
    {
        String gameString = String.format("%5d - %2s (%2s, %2s)", this.getID(), this.getTitle(), this.getGenre(), this.getPublisher());
        return gameString;
    }
    
    public boolean equals(GameClass game){
        boolean result = true;
        result = this.getTitle().equalsIgnoreCase(game.getTitle()) &&
                this.getGenre().equalsIgnoreCase(game.getGenre()) && this.getPublisher().equalsIgnoreCase(game.getPublisher());
        return result;
    }
    
}

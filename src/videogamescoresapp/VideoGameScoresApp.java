/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package videogamescoresapp;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author zackd
 */
public class VideoGameScoresApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic here
        
        ScoreBoardAppClass app = new ScoreBoardAppClass();
        app.loadGames("C:\\School Scripts\\JavaClassFolder\\VideoGameScoresApp\\src\\games.txt");
        app.loadScore("C:\\School Scripts\\JavaClassFolder\\VideoGameScoresApp\\src\\scores.txt");
        
        
        while(true){
            int choice = -1;
            
            do{
                printMenu();
                choice = Utilites.getUserChoice("Please, enter choice: ");
            }while(choice < 0 || choice > 8);
            
            switch(choice){
                case 1:
                    handleListGames(app);
                  
                    break;
                case 2:
                    handleListStudents(app);
                    
                    break;
                case 3:
                    handleStudentReport();
                    handleListStudents(app);
                    System.out.print("Enter student ID: ");
                    Scanner input = new Scanner(System.in);
                    app.StudentReport(input.nextLine());
                    break;
                case 4:
                    handleTopNforAGame();
                    break;
                case 5:
                    handleUpdateStudentScore(app);
                    break;
                case 6:
                    handleGameStats();
                    break;
                case 7:
                    handleAddNewStudent();
                    break;
                case 8:
                    handleSaveData();
                    app.saveGames("C:\\School Scripts\\JavaClassFolder\\VideoGameScoresApp\\src\\games.txt");
                    app.saveScores("C:\\School Scripts\\JavaClassFolder\\VideoGameScoresApp\\src\\scores.txt");
                    break;
                case 0:
                    System.exit(0);
                    break;
                
            }
        }
    }
    
    
    private static void printMenu()
    {
        System.out.println("");
        System.out.println("""
                           1) List games
                           2) List students
                           3) Show a students report
                           4) Show top N for a game
                           5) Update a student's score
                           6) Game stats (min/max/avg)
                           7) Add a new student
                           8) Save data
                           0) Exit
                           """);
    }
    
   
    
    
    public static void handleListGames(ScoreBoardAppClass app)
    {
        System.out.println("Handling List OF Games");
        app.listGames();
    }
    public static void handleListStudents(ScoreBoardAppClass app)
    {
         System.out.println("Handling List OF Students");
         app.listStudents();
    }
    public static void handleStudentReport()
    {
         System.out.println("Handling A Student Report");
    }
    public static void handleTopNforAGame()
    {
         System.out.println("Handling Top N For A Game");
    }
    public static void handleUpdateStudentScore(ScoreBoardAppClass app)
    {
         System.out.println("Handling Updating Student Score");
         Scanner input = new Scanner(System.in);
         app.updateScore(input.nextLine(), input.nextInt(), input.nextInt());
    }
    public static void handleGameStats()
    {
         System.out.println("Handling Game Stats");
    }
    public static void handleAddNewStudent()
    {
         System.out.println("Handling Adding A New Student");
    }
    public static void handleSaveData()
    {
         System.out.println("Handling Saving Data");
    }
}

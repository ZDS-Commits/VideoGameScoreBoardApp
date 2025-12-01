/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package videogamescoresapp;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author zackd
 */
public class ScoreBoardAppClass {
    private final int MAX_STUDENTS = 100;
    private GameClass[] games;
    private StudentClass[] students;
    private int studentCount;

    public ScoreBoardAppClass() {
        this.studentCount = 0;
        this.students = new StudentClass[this.MAX_STUDENTS];
        this.games = new GameClass[10];
    }

    public ScoreBoardAppClass(int studentCount, GameClass[] games, StudentClass[] students) {
        this.studentCount = studentCount;
        this.students = new StudentClass[this.MAX_STUDENTS];

        for (int i = 0; i < students.length; i++) {
            this.students[i] = students[i];
        }
        this.games = new GameClass[games.length];
        for (int i = 0; i < games.length; i++) {
            this.games[i] = games[i];
        }
    }

    public void setGames(GameClass[] games) {
        this.games = new GameClass[games.length];

        for (int i = 0; i < games.length; i++) {
            this.games[i] = games[i];
        }
    }

    public void loadGames(String filename) throws IOException {
        this.games = new GameClass[10];
        File input = new File(filename);
        Scanner output = new Scanner(input);
        int i = 0;
        while (output.hasNext()) {
            String str = output.nextLine();
            games[i] = new GameClass().fromDataLine(str);
           
            i++;

        }
        System.out.println("The Size of the list of students is: " + this.students.length);
        output.close();
    }

    public void loadScore(String filename) throws IOException {
        this.students = new StudentClass[MAX_STUDENTS];
        File input = new File(filename);
        Scanner output = new Scanner(input);

        int i = 0;
        while (output.hasNext()) {
            String str = output.nextLine();
            students[i] = new StudentClass().fromDataLine(str);
            
            i++;
        }
    }

    public void saveGames(String filename) throws IOException {
        ///
         /// This is a function to save the array of games into the file games.txt as a new copy.
         ///
        
        PrintWriter output = new PrintWriter(filename);

        for (int i = 0; i < games.length; i++) {
            output.println(games[i].toDataLine());
        }

        output.close();

    }
    
    public void saveScores(String filename) throws IOException{
        PrintWriter output = new PrintWriter(filename);

        for (int i = 0; i < students.length; i++) {
            output.println(students[i].toDataLine());
        }

        output.close();
    }
    
    public void listGames(){
        for(int i = 0; i < games.length; i++)
        {
            System.out.println(games[i].ToString());
        }
    }
    
    public void listStudents(){
        
        for(int i = 0; i < students.length; i++)
        {
            if(students[i] != null)
            {
                System.out.println(students[i].ToString());
                studentCount++;
            }else{
                break;
            }
            
        }
    }
    
    private int findStudentByID(String id){
        int studentID = -1;
        for(int i = 0; i < games.length; i++){
           
           if(id.equalsIgnoreCase(students[i].getID()))
           {
              studentID = i;
              break;
           }
          
       }
       return studentID;
    }
    
    
    private int findGameByID(int ID){
        int gameID = -1;
        String id = String.valueOf(ID);
        for(int i = 0; i < games.length; i++){
            
            if(id.equalsIgnoreCase(String.valueOf(games[i].getID()))){
                gameID = i;
                break;
            }
        }
        
        return gameID;
    }

    public void StudentReport(String id) throws IOException{
       int scoreID = 0;
     
       int studentID = findStudentByID(id);
       String str = students[studentID].getID();
       if(id.equalsIgnoreCase(str))
       {
           
           for(int i = 0; i < games.length; i++)
           {
               System.out.println(games[i].getTitle() + " " + students[studentID].getScore(scoreID));
               scoreID++;
           }
       }
    }
    
    public void updateScore(String studentID, int gameID, int newScore){
        findStudentByID(studentID);
        System.out.println("This game with this user has a score of: " +  findGameByID(gameID));
        
    }
    
    public void TopNForGames(String id) throws IOException{
        int gameID = 0;
        
    }
    
   
    public class Stats {

        int min;
        int max;
        double avg;
        
        public Stats(int min, int max, double avg){
            this.min = min;
            this.max = max;
            this.avg = avg;
        }
    }
    
    public Stats computeStatsForGame(int gameIndex){
        int[] scoreForGigenGame = new int[this.studentCount];
        for(int i =0; i < this.studentCount; i++){
            StudentClass s = this.students[i];
            int[] allHisScores = s.getScores();
            int score = allHisScores[gameIndex];
            System.out.print(score + ", ");
        }
        
        //int min = Utilities.findLowest(scoreForGigenGame);
        //int max = Utilities.findHighest(scoreForGigenGame);
        //double avg = Utilities.findAverage(scoreForGigenGame);
        
        Stats statsObj = new Stats(0, 0, 0);
        
        
        return statsObj;
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package videogamescoresapp;

import java.util.Scanner;

/**
 *
 * @author zackd
 */
public class Utilites {
    
    static int getUserChoice(String prompt)
    {
        int choice = 0;
        System.out.println(prompt);
        Scanner myScanner = new Scanner(System.in);
        choice = myScanner.nextInt();
        return choice;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package assigment_pdc;

import java.util.Scanner;

/**
 *
 * @author ellagregory
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello and welcome to our Hangman game ");
        System.out.println("The game consists of three levels, level 1, 2 and 3");

        System.out.print("Please enter your name: ");
        String username = scanner.nextLine();
        User user = new User(username);
        System.out.println("Welcome" + userName + "!:)");

        System.out.println("Please choose your level 1, 2 or 3 : ");
            int level = scanner.nextInt();
            scanner.nextLine();
    }
    
}

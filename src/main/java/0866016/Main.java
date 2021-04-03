package main.java;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException,IllegalArgumentException {
        Scanner scanner = new Scanner(System.in);
        Game onegame=new Game();
        System.out.println("===Welcome to Rock-Paper-Scissors game ===");
        System.out.println("Enter Player 1 choice (rock, paper, scissors)");
        String str1 = scanner.nextLine();
        onegame.legalInput(str1);
        System.out.println("Enter Player 2 choice (rock, paper, scissors)");
        String str2 = scanner.nextLine();
        onegame.legalInput(str2);
        System.out.println(onegame.WhoWin(str1,str2));
    }
}

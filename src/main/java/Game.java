package main.java;

import java.util.ArrayList;
import java.util.Arrays;

public class Game {
    public ArrayList<String> legalstr=new ArrayList<String>(Arrays.asList(new String("scissors"),new String("rock"),new String("paper")));
    void legalInput(String str){
        if(!legalstr.contains(str)){
            throw new IllegalArgumentException("Bad choice!");
        }
    }
    public String WhoWin(String Play1,String Play2){
        legalInput(Play1);
        legalInput(Play2);

        int n=legalstr.indexOf(Play1);
        int m=legalstr.indexOf(Play2);
        if(n==m){
            return "Draw!";
        }
        else if(n==m+1 || n==m-2){
            return "Player 1 win!";
        }
        else{
            return "Player 2 win!";
        }
    }
}

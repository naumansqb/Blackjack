package com.pluralsight;

import java.util.Scanner;

public class Blackjack {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Deck deck = new Deck();
        deck.shuffle();


        System.out.println("Please enter name for player 1: ");
        String playerOneName = scan.nextLine();
        System.out.println("Please enter name for player 2: ");
        String playerTwoName = scan.nextLine();

        while(true) {
            if(deck.getSize()<10){
                System.out.println("It's time to reshuffle. ");
                deck= new Deck();
                deck.shuffle();
            }

            Hand player1 = new Hand();
            Hand player2 = new Hand();

            player1.deal(deck.deal());
            player1.deal(deck.deal());
            player2.deal(deck.deal());
            player2.deal(deck.deal());

            int playerOneTotal = player1.getValue();
            int playerTwoTotal = player2.getValue();

            System.out.println(playerOneName+"'s hand: ");
            player1.print();
            System.out.println("Total Value of Cards: " + playerOneTotal);

            System.out.println(playerTwoName+"'s hand: ");
            player2.print();
            System.out.println("Total Value Of Cards: " + playerTwoTotal);

            System.out.println();
            if (playerOneTotal > 21 && playerTwoTotal > 21) {
                System.out.println("Both players have busted.");
            } else if (playerOneTotal > 21) {
                System.out.println(playerOneName + " busted! " + playerTwoName + " wins!");
            } else if (playerTwoTotal > 21) {
                System.out.println(playerTwoName + " busted! " + playerOneName + " wins!");
            } else if (playerOneTotal > playerTwoTotal) {
                System.out.println(playerOneName + " wins!");
            } else if (playerTwoTotal > playerOneTotal) {
                System.out.println(playerTwoName + " wins!");
            } else {
                System.out.println("It's a tie!");
            }

            System.out.println("Would you like to play another round?\nEnter yes or no");
            String input= scan.nextLine().trim();
            if(input.equalsIgnoreCase("yes")){
                continue;
            }else if(input.equalsIgnoreCase("no")){
                break;
            }else{
                System.out.println("Invalid Option. Exiting");
                break;
            }
        }
        System.out.println("have a great day");
        scan.close();

    }
}

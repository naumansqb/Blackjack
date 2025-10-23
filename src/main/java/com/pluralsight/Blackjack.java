package com.pluralsight;

import java.util.Scanner;

public class Blackjack {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Deck deck = new Deck();
        deck.shuffle();

        Hand player1 = new Hand();
        Hand player2 = new Hand();

        System.out.println("Please enter name for player 1: ");
        String playerOneName = scan.nextLine();
        System.out.println("Please enter name for player 2: ");
        String playerTwoName = scan.nextLine();


        player1.deal(deck.deal());
        player1.deal(deck.deal());
        player2.deal(deck.deal());
        player2.deal(deck.deal());

        int playerOneTotal = player1.getValue();
        int playerTwoTotal = player2.getValue();


        player1.print();
        System.out.println("Total Value of Cards: " + playerOneTotal);

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
        } else if(playerTwoTotal>playerOneTotal){
            System.out.println(playerTwoName + " wins!");
        }else {
            System.out.println("It's a tie!");
        }

    }
}

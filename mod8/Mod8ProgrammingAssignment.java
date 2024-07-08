package com.example.mod8programmingassignment;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Random;

//Eric WP CSD420 Module 8 Programming Assignment
//The purpose of this assignment was to create three threads to output 10,000 random alphabet characters, 10,000 random
//numbers between 0-9, and 10,000 random symbols
//To do this I created three classes that all extend Thread and implement the run method with code inside
//In hindsight it might have been more efficient to combine this into one class with a Generic object parameter or
//overload the run method

public class Mod8ProgrammingAssignment extends Application{


    public static void main(String[] args) {

        launch(args);

    }

    //Class for string Thread
    static class stringThread extends Thread {

        //Create an empty character array
        ArrayList<Character> strList = new ArrayList<>();

        //When the thread starts, create an SB called 'alph' that has all the uppercase and lowercase characters in the
        //alphabet
        public void run(){

            StringBuilder alph = new StringBuilder("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz");

            //Create a new instance of random
            Random rand = new Random();

            //Add 10,000 characters from random positions in the StringBuilder object created above
            for (int i = 0; i <= 10000; i++) {
                strList.add(alph.charAt(rand.nextInt(alph.length())));
            }

        }
    }

    //Class for integer Thread
    static class integerThread extends Thread {

        //Create empty array of integers
        ArrayList<Integer> intList = new ArrayList<>();

        //When the thread runs, add 10,000 random numbers between 0-10 to the integer array created above
        public void run(){
            for (int i = 0; i <= 10000; i++) {
                Random rand = new Random();
                intList.add(rand.nextInt(10));
            }
        }
    }

    //Class for symbol Thread
    static class symbolThread extends Thread {

        //Create empty array of characters
        ArrayList<Character> symbolList = new ArrayList<>();

        //When the thread runs, create an SB called 'symbolList' that holds various symbols
        public void run(){
            StringBuilder symbols = new StringBuilder("!@#$%^&*()");

            //Create an instance of random
            Random rand = new Random();

            //Add 10,000 symbols from random positions in the SB built above
            for (int i = 0; i < 10000; i++) {

                symbolList.add(symbols.charAt(rand.nextInt(symbols.length())));

            }
        }
    }



    @Override
    public void start(Stage primaryStage) {

       //Create GridPane to hold Labels and TextAreas
        GridPane gridPane = new GridPane();

        //Creating and adjusting sizes
        Scene scene = new Scene(gridPane, 1600, 600);

        //Creating instance of each thread class and starting threads early
        stringThread sT = new stringThread();
        integerThread iT = new integerThread();
        symbolThread sYThread = new symbolThread();
        iT.start();
        sT.start();
        sYThread.start();

        //Creating Label and TextArea to display characters
        Label alphLabel = new Label("10,000 Random Letters");
        TextArea charList = new TextArea();
        charList.setEditable(false);

        //Set text to the value of the list created in the string Thread class
        charList.setText(String.valueOf(sT.strList));
        charList.setPrefWidth(500);
        charList.setPrefHeight(500);
        charList.setWrapText(true);
        //Setting position in grid
        gridPane.add(alphLabel, 0, 0);
        gridPane.add(charList, 0, 1);

        //Creating Label and TextArea to display numbers
        Label intLabel = new Label("10,000 Random Numbers");
        TextArea intList = new TextArea();
        intList.setEditable(false);

        //Set text to the value of the list created in the integer Thread class
        intList.setText(String.valueOf(iT.intList));
        intList.setPrefWidth(500);
        intList.setPrefHeight(500);
        intList.setWrapText(true);
        //Setting position in grid
        gridPane.add(intLabel, 1, 0);
        gridPane.add(intList, 1, 1);

        //Creating Label and TextArea to display symbols
        Label symbolLabel = new Label("10,000 Random Symbols");
        TextArea symbolList = new TextArea();
        symbolList.setEditable(false);

        //Set text to the value of the list created in the symbol Thread class
        symbolList.setText(String.valueOf(sYThread.symbolList));
        symbolList.setPrefWidth(500);
        symbolList.setPrefHeight(500);
        symbolList.setWrapText(true);

        //Setting position in grid
        gridPane.add(symbolLabel, 2, 0);
        gridPane.add(symbolList, 2, 1);

        //Setting vertical and horizontal gaps in grid and centering
        gridPane.setVgap(25);
        gridPane.setHgap(25);
        gridPane.setAlignment(Pos.CENTER);



        primaryStage.setTitle("Module 8 Programming Assignment");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();

    }
}


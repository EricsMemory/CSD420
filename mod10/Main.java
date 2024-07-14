package com.example.mod10assignment;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

//Eric Williams-Phillips Module 10 Programming Assignment
//The purpose of this assignment was to create a GUI that, with the use of buttons
//and user input, can display and update records in an SQL database
//I did this in one file for ease of submission

public class Main  extends Application {


    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage stage) throws Exception {

        //Node Creation
        Button display = new Button("Display");
        Button update = new Button("Update");
        Label response = new Label("Enter an ID number:");
        TextField displayRequest = new TextField();
        TextField updateRequest = new TextField();

        //Node Adjustment
        displayRequest.setPromptText("Enter ID");
        updateRequest.setPromptText("Enter changes..");
        response.setPrefSize(300, 50);

        //Grid Layout Creation and adjustment
        GridPane baseGrid = new GridPane();
        baseGrid.add(response, 0, 0);
        baseGrid.add(displayRequest, 0, 1);
        baseGrid.add(display, 0, 2);
        baseGrid.add(updateRequest, 0, 3);
        baseGrid.add(update, 0, 4);
        baseGrid.setVgap(25);
        baseGrid.setAlignment(Pos.CENTER);

        //Scene setup
        Scene scene = new Scene(baseGrid, 600, 600);

        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

        //Button actions
        display.setOnAction(e -> {

            Connection connection;
            Statement statement;

            //Creating try/catch for connecting
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");

                String url = "jdbc:mysql://localhost:3306/databasedb?";

                connection = DriverManager.getConnection(url + "user=student1&password=pass");

                statement = connection.createStatement();

                //Storing query into rs
                ResultSet rs = statement.executeQuery("SELECT favoriteteam, firstname, lastname FROM fans WHERE ID = " + displayRequest.getText());

                //Confirmation of successful connection
                System.out.println("Successfully connected to database.");

                //if ResultSet has records, access them and generate formatted response
                if(rs.next()){
                    response.setText(rs.getString(2) + " " + rs.getString(3) + "'s favorite team: " + rs.getString(1));
                   System.out.println(rs.getString(1));
                }

                //Clear input TextField
                updateRequest.clear();
                connection.close();
                statement.close();


            } catch(Exception error) {
                System.out.println("Error.");
                error.printStackTrace();
                System.exit(1);
            }
        });

        update.setOnAction(e -> {

            Connection connection;
            Statement statement;

            //Creating try/catch for connecting
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");

                String url = "jdbc:mysql://localhost:3306/databasedb?";

                connection = DriverManager.getConnection(url + "user=student1&password=pass");

                statement = connection.createStatement();

                //Executing query to update team in db with user input
                statement.executeUpdate("UPDATE fans SET favoriteteam = '" + updateRequest.getText() + "' WHERE ID = " + displayRequest.getText());
                //Confirmation of update
                System.out.println("Successfully updated records.");


                //Clear input TextField
                updateRequest.clear();
                connection.close();
                statement.close();


            } catch(Exception error) {
                System.out.println("Error.");
                error.printStackTrace();
                System.exit(1);
            }
        });

    }
}

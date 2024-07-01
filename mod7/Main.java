package com.example.mod7;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.io.IOException;

//Eric WP CSD420 Module 7 Programming Assignment
//The purpose of this assignment is to utilize an outside CSS file to style JavaFX
//windows by applying IDs and classes to each element.
//I created four circles and applied the required classes/IDs to each of them to
//replicate the example provided in our assignment directions

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        //Creating scene and setting size
        Pane holder = new Pane();
        Scene scene = new Scene(holder, 200, 800);

        //Adding style sheet to scene
        scene.getStylesheets().add("mystyle.css");

        //Creating circles in vertical alignment
        Circle circle = new Circle(100, 100, 75);

        Circle circle2 = new Circle(100, 300, 75);

        Circle circle3 = new Circle(100, 500, 75);

        Circle circle4 = new Circle(100, 700, 75);

        //Adding circles to main pane
        holder.getChildren().addAll(circle, circle2, circle3, circle4);

        //Applying classes and IDs to elements
        circle.getStyleClass().add("plaincircle");
        circle.getStyleClass().add("circleborder");
        circle2.getStyleClass().add("plaincircle");
        circle3.setId("redcircle");
        circle4.setId("greencircle");

        //Setting the stage to the scene and naming it
        stage.setScene(scene);
        stage.setTitle("Circles");
        stage.show();
    }

    public static void main(String[] args) {

        launch();
    }
}
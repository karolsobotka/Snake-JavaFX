package com.company;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.IOException;


public class Main extends Application {

    @Override
    public void start(Stage stage) {

        stage.setTitle("Menu");
        VBox vBox = new VBox();
        vBox.setSpacing(50);

         Button newGame = new Button("New Game");
         Button ranking = new Button("High Scores");
         Button exit = new Button("Exit");

        vBox.setAlignment(Pos.CENTER);

        newGame.setOnAction(event -> {
            stage.hide();
            Wymiary wymiary = new Wymiary();
        });

        ranking.setOnAction(event -> {
            Ranking ranking1 = new Ranking();

        });
         exit.setOnAction(event -> System.exit(0));


        vBox.getChildren().addAll(newGame, ranking, exit);


        Scene scene = new Scene(vBox, 500, 500);
       stage.setScene(scene);


        stage.show();

    }
    public static void main(String[] args) {
        launch(args);
    }
}

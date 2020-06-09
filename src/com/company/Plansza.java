package com.company;

import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.scene.control.*;
import javafx.scene.Scene;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.Timer;
import java.util.TimerTask;

public class Plansza {


    Label czasLabel;
    Label czasField;
    Label punktyLabel;
    Label punktyField;

    static int wymiar_bloku = 20;

    int width = Wymiary.getWidth();
    int height = Wymiary.getHeight();

    int poczatkowaDlugosc = 1;

    long then = System.nanoTime();
    Pole p;
    static AnimationTimer animationTimer;
    public Plansza(){
            this.czasLabel = new Label("Czas:");
            this.czasField = new Label();
            this.punktyLabel = new Label("Punkty: ");
            this.punktyField = new Label("0");

        BorderPane root = new BorderPane();
        HBox hBox = new HBox(10);
        root.setTop(hBox);
        Stage planszaStage = new Stage();
        Scene planszaScene = new Scene(root);
        hBox.getChildren().addAll( czasLabel, czasField, punktyLabel, punktyField);

         p = new Pole(width, height);
        root.setCenter(p);

        p.addSnake(new Snake(poczatkowaDlugosc));

         animationTimer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if(now - then > 1000000000/4){
                    p.update();
                    then = now;
                }
            }
        };
        animationTimer.start();

        planszaStage.setScene(planszaScene);
        planszaStage.setTitle("Snake the Great!!");
        planszaStage.show();

        start();

        planszaScene.setOnKeyPressed( e -> {
          if(e.getCode().equals(KeyCode.UP) && p.snake.getKierunek() != Blok.DOWN){
                p.snake.setKierunek(Blok.UP);
            }
            if(e.getCode().equals(KeyCode.DOWN)&& p.snake.getKierunek() != Blok.DOWN){
                p.snake.setKierunek(Blok.DOWN);
            }
            if(e.getCode().equals(KeyCode.LEFT)&& p.snake.getKierunek() != Blok.RIGHT){
                p.snake.setKierunek(Blok.LEFT);
            }
            if(e.getCode().equals(KeyCode.RIGHT)&& p.snake.getKierunek() != Blok.LEFT){
                p.snake.setKierunek(Blok.RIGHT);
            }

        });

        planszaStage.getScene().getAccelerators().put(
                KeyCombination.keyCombination("CTRL+SHIFT+Q"),
                () -> {
                    animationTimer.stop();
                    PoprosONazwe p = new PoprosONazwe();
                }
        );



}
    int sekundy;
    int minuty;

    Timer czas = new Timer();

    TimerTask timerTask = new TimerTask() {
        @Override
        public void run() {
            Platform.runLater(() -> {
                if(sekundy==59){
                    sekundy=0;
                    minuty++;

                    String str = minuty + ":"+ sekundy;
                    czasField.setText(str);
                }
                if(sekundy<60){
                    sekundy++;
                    String str = minuty + ":"+ sekundy;
                    czasField.setText(str);
                }
                if(p.isDead()){
                    Platform.runLater(() -> {
                        animationTimer.stop();
                        czas.cancel();
                        PoprosONazwe poprosONazwe = new PoprosONazwe();


                    });
                }
                punktyField.setText(Pole.getPunkty());
            });

        }
    };


    public void start(){
        czas.scheduleAtFixedRate(timerTask,1000,1000);
    }



}

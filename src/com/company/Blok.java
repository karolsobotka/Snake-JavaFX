package com.company;


import javafx.application.Platform;
import javafx.scene.shape.Rectangle;

public class Blok extends Rectangle {

    static final int UP = 0, RIGHT = 1, DOWN = 2, LEFT =3;

    int posX, posY, oldPosX, oldPosY;
    Blok poprzedni;

    int kierunek = LEFT;

    int maxX, maxY;

    public Blok(int x, int y, Blok p){
        super(Plansza.wymiar_bloku,Plansza.wymiar_bloku);
        posX = x;
        posY = y;

        setTranslateX(x*Plansza.wymiar_bloku);
        setTranslateY(y*Plansza.wymiar_bloku);
        poprzedni = p;

        maxX =  Wymiary.getWidth();
        maxY =  Wymiary.getHeight();
    }

    public void update(){
        oldPosX = posX;
        oldPosY = posY;
        if(poprzedni == null){
            switch(kierunek){
                case UP: moveUp(); break;
                case RIGHT: moveRight(); break;
                case DOWN: moveDown(); break;
                case LEFT: moveLeft(); break;
            }
        }
        else{
            posX = poprzedni.oldPosX;
            posY = poprzedni.oldPosY;
        }
        updatePosition();
    }

    private void moveUp() {
        posY--;
        if(posY < 0 ){

            endGame();
        }
    }
    private void moveRight() {
        posX++;
        if(posX >= maxX ){

            endGame();
        }
    }
    private void moveDown() {
        posY++;
        if(posY >= maxY ){

            endGame();
        }
    }
    private void moveLeft() {
        posX--;
        if(posX < 0 ){

            endGame();
        }
    }

    public void updatePosition(){
        setTranslateX(posX* Plansza.wymiar_bloku);
        setTranslateY(posY* Plansza.wymiar_bloku);
    }

    public void endGame(){

        Plansza.animationTimer.stop();

            Platform.runLater(() -> {
                PoprosONazwe poprosONazwe = new PoprosONazwe();
            });

    }




}

package com.company;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Jedzenie extends Rectangle {
    int posX, posY;

    public Jedzenie(int posX, int posY){
        super(Plansza.wymiar_bloku,Plansza.wymiar_bloku);
        this.posX = posX;
        this.posY = posY;

        setTranslateX( this.posX * Plansza.wymiar_bloku);
        setTranslateY( this.posY * Plansza.wymiar_bloku);

        setFill(Color.LIGHTGREEN);
        setStroke(Color.DARKGREEN);
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }
}

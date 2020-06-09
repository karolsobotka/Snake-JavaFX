package com.company;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class ZleJedzenie extends Rectangle {
    int posX, posY;

    public ZleJedzenie(int posX, int posY){
        super(Plansza.wymiar_bloku,Plansza.wymiar_bloku);
        this.posX = posX;
        this.posY = posY;

        setTranslateX( this.posX * Plansza.wymiar_bloku);
        setTranslateY( this.posY * Plansza.wymiar_bloku);

        setFill(Color.RED);
        setStroke(Color.PINK);
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }
}

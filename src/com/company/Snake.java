package com.company;

import javafx.scene.paint.Color;

import java.util.ArrayList;

public class Snake {

    ArrayList<Blok> bloki = new ArrayList<>();

    Blok glowa;
    Blok ogon;

    public Snake(int poczatkowaDlugosc){
        int poczatkowyX = Wymiary.getWidth()/2;
        int poczatkowyY = Wymiary.getHeight()/2;


        glowa = new Blok(poczatkowyX, poczatkowyY, null);
        bloki.add(glowa);

        ogon = glowa;

        glowa.setFill(Color.GREEN.desaturate());

        for (int i = 0; i < poczatkowaDlugosc; i++) {
            Blok b = new Blok(poczatkowyX+i, poczatkowyY+i, ogon);
            bloki.add(b);
            ogon = b;
        }
    }

    public void setKierunek(int kierunek ){
        glowa.kierunek = kierunek;
    }

    public int getKierunek(){
        return glowa.kierunek;
    }
}

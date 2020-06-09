package com.company;

import javafx.geometry.Insets;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.util.ArrayList;

import static javax.swing.UIManager.get;

public class Pole extends Pane {

    private int w,h;

    static ArrayList<Blok> listaBlokow = new ArrayList<>();
    static int punkty = 0;
    Jedzenie jedzenie;
    ZleJedzenie zleJedzenie;

    static Snake snake;

    public Pole(int width,int height){
        this.w = width;
        this.h = height;

        setPadding(new Insets(10,10,10,10));
        setMinSize(w*Plansza.wymiar_bloku,h*Plansza.wymiar_bloku);
        setBackground(new Background(new BackgroundFill(Color.WHITE,null, null)));
        setBorder(new Border(new BorderStroke(Color.BLACK,
                BorderStrokeStyle.SOLID,
                null, new BorderWidths(1))));


        addJedzenie();
        addZleJedzenie();
    }

    public static boolean isDead(){
        for(Blok blok :listaBlokow){
            if(blok != snake.glowa){
                if(blok.posX == snake.glowa.posX &&
                        blok.posY == snake.glowa.posY){
                    return true;
                }
            }
        }
        return false;
    }

    public void addSnake(Snake snake){
        this.snake = snake;

        for(Blok blok : snake.bloki){
            addBlok(blok);
        }
    }

    public void update(){
        for(Blok blok : listaBlokow){
            blok.update();
        }
        if(isJedzenieEaten(jedzenie)){
            punkty+=1;
            addJedzenie();
            addNewBlok();
        }
        if(isZleJedzenieEaten(zleJedzenie)){
            punkty-=1;
            addZleJedzenie();
            removeNewBlok();

        }
    }

    public void addNewBlok(){
        Blok b = new Blok(snake.ogon.oldPosX, snake.ogon.oldPosY,snake.ogon);
        snake.ogon = b;
        addBlok(b);
    }
    public void removeNewBlok(){
        Blok b = listaBlokow.get(listaBlokow.size()-1);
        snake.ogon = b;
        removeBlok(b);
    }

    private void addBlok(Blok blok){
        getChildren().add(blok);
        listaBlokow.add(blok);
    }
    private void removeBlok(Blok blok){
        getChildren().remove(blok);
        listaBlokow.remove(get(listaBlokow.size()-2));
    }


    public void addJedzenie(){
        int randomX = (int) (Math.random()*w);
        int randomY = (int) (Math.random()*h);

        Jedzenie jedzenie = new Jedzenie(randomX, randomY);
        getChildren().add(jedzenie);
        getChildren().remove(this.jedzenie);
        this.jedzenie = jedzenie;
    }
    public void addZleJedzenie(){
        int randomX = (int) (Math.random()*w);
        int randomY = (int) (Math.random()*h);

        ZleJedzenie zleJedzenie = new ZleJedzenie(randomX, randomY);
        getChildren().add(zleJedzenie);
        getChildren().remove(this.zleJedzenie);
        this.zleJedzenie = zleJedzenie;
    }

    public boolean isJedzenieEaten(Jedzenie jedzenie){
        if(jedzenie == null){
            return false;
        }
        return jedzenie.getPosX() == snake.glowa.posX &
         jedzenie.getPosY() == snake.glowa.posY;
    }
    public boolean isZleJedzenieEaten(ZleJedzenie zleJedzenie){
        if(zleJedzenie == null){
            return false;
        }
        return zleJedzenie.getPosX() == snake.glowa.posX &
         zleJedzenie.getPosY() == snake.glowa.posY;
    }

    public static String getPunkty() {
        return String.valueOf(punkty);
    }
}

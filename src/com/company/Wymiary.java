package com.company;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.util.Pair;

import java.util.Optional;

public class Wymiary {
    private static int height, width;

    public Wymiary() {


        //MOCNO INSPIROWANE PRZYKLADEM Z https://code.makery.ch/blog/javafx-dialogs-official/
        //PRZYZNAJE SIĘ BEZ BICIA ALE JEST PIEKNIE I TAK CHCIAłEM ŻEBY TO WYGLĄDAłO.

        Dialog<Pair<String, String>> dialog = new Dialog<>();
        dialog.setTitle("Wymiary");
        dialog.setHeaderText("Podaj Wymiary Planszy dla Snake'a!");

        ButtonType zatwierdzButtonType = new ButtonType("Potwierdź", ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(zatwierdzButtonType, ButtonType.CANCEL);

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 150, 10, 10));

        TextField wysokosc = new TextField();
        wysokosc.setPromptText("Wysokość");
        TextField szerokosc = new TextField();
        szerokosc.setPromptText("Szerokość");

        grid.add(new Label("Wysokość:"), 0, 0);
        grid.add(wysokosc, 1, 0);
        grid.add(new Label("Szerokość:"), 0, 1);
        grid.add(szerokosc, 1, 1);

        Node zatwierdzButton = dialog.getDialogPane().lookupButton(zatwierdzButtonType);
        zatwierdzButton.setDisable(true);

        wysokosc.textProperty().addListener((observable, oldValue, newValue) -> {
            zatwierdzButton.setDisable(newValue.trim().isEmpty());
        });

        dialog.getDialogPane().setContent(grid);

        Platform.runLater(wysokosc::requestFocus);



        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == zatwierdzButtonType) {
                return new Pair<>(wysokosc.getText(), szerokosc.getText());
            }
            return null;
        });

        Optional<Pair<String, String>> result = dialog.showAndWait();

        result.ifPresent(wysokoscSzerokosc -> System.out.println("Wysokość= " + wysokoscSzerokosc.getKey() +
                                                            ", Szerokosc= " + wysokoscSzerokosc.getValue()));

        boolean succes = false;

        try{
            this.height = Integer.parseInt(wysokosc.getText());
            this.width = Integer.parseInt(szerokosc.getText());

            succes = true;
        }
        catch (NumberFormatException e){
            System.out.println(e.getMessage());
            NotIntegerException notIntegerException = new NotIntegerException();

        }
        if(succes){

            Plansza plansza = new Plansza();

        }

        else{
            Wymiary wymiary = new Wymiary();
        }



    }

    public static int getHeight() {
        return height;
    }

    public static int getWidth() {
        return width;
    }
}

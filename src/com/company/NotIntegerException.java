package com.company;


import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Alert;


public class NotIntegerException extends NumberFormatException{

    public NotIntegerException(){
        super("Wprowadzane wartości musza byc w postaci liczb całkowitych.");
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("NotIntegerException");
        alert.setHeaderText("Podaj poprawne wartosci.");
        alert.setContentText("Wprowadzane wartości musza byc w postaci liczb całkowitych.");

        alert.showAndWait();

    }
}

package com.company;

import javafx.scene.control.TextInputDialog;
import java.util.Optional;

public class PoprosONazwe {

    private String nazwa;
    public PoprosONazwe() {

        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Nazwa");
        dialog.setHeaderText("Podaj swoja nazwe do zapisania w Rankingu");
        dialog.setContentText("Nazwa: ");


        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()){
            this.nazwa = result.get();
        }


}

    public String getNazwa() {
        return nazwa;
    }
}

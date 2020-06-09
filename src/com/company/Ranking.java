package com.company;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javax.swing.text.Element;
import javax.swing.text.html.ListView;
import java.io.*;
import java.util.ArrayList;

public class Ranking implements Serializable {

    PoprosONazwe poprosONazwe;

   private String nazwa = poprosONazwe.getNazwa();
    File file = new File("Ranking.dat");
    ArrayList<String> listaNazw = new ArrayList<>();

    public Ranking(){
        ListView listView = new ListView((Element) listaNazw);

        Pane root = new Pane();
        Stage stage = new Stage();
        Scene scene = new Scene(root);

        stage.setScene(scene);


    }



}

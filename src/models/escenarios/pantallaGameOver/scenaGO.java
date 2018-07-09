package models.escenarios.pantallaGameOver;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import models.controladores.GameValues;
import models.controladores.Gravedad;
import models.controladores.scenariosValues;
import models.escenarios.factory.ScenesType;
import models.escenarios.factory.sceneFactory;
import models.players.Player;


public class scenaGO extends Scene {
    private ImageView fondo=new ImageView();
    private Pane root;
    private boolean cambiandoVentana=true;

    public scenaGO(Pane root) {
        super(root, GameValues.dimension[0],GameValues.dimension[1]);
        this.root=root;

        scenariosValues.primaryStage.setScene(this);
        System.out.println(root);
        content();
    }

    public void content(){


        HBox hbox=new HBox();
        hbox.setLayoutX(500);
        hbox.setLayoutY(400);


        fondo.setImage(new Image(this.getClass().getResource("go.gif").toExternalForm()));
        fondo.setFitHeight(GameValues.dimension[1]);
        fondo.setFitWidth(GameValues.dimension[0]);
        fondo.setPreserveRatio(false);
        fondo.setLayoutX(0);fondo.setLayoutY(0);


        root.getChildren().addAll(fondo,hbox);


    }
}

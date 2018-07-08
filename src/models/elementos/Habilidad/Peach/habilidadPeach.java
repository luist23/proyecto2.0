package models.elementos.Habilidad.Peach;

import javafx.scene.image.ImageView;
import models.elementos.Habilidad.Base.habilidadBase;
import models.players.Player;

/**
 * Created by LuisT23 on 8/7/2018.
 */
public class habilidadPeach extends habilidadBase {

    public habilidadPeach(){
        habilidad=new ImageView(this.getClass().getResource("laserpeach.gif").toExternalForm());
        habilidad.setFitWidth(300);
        habilidad.setFitHeight(40);
        habilidad.setLayoutY(Player.getPlayer().getLayoutY());
        habilidad.setLayoutX(Player.getPlayer().getLayoutX());
        Player.getRoot().getChildren().addAll(habilidad);
        ejecutar();
    }
}
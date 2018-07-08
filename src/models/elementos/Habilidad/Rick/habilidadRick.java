package models.elementos.Habilidad.Rick;

import javafx.scene.image.ImageView;
import models.elementos.Habilidad.Base.habilidadBase;
import models.players.Player;

/**
 * Created by LuisT23 on 7/7/2018.
 */
public class habilidadRick extends habilidadBase{

    public habilidadRick(){
        habilidad=new ImageView(this.getClass().getResource("laser.gif").toExternalForm());
        habilidad.setFitWidth(300);
        habilidad.setFitHeight(40);
        habilidad.setLayoutY(Player.getPlayer().getLayoutY());
        habilidad.setLayoutX(Player.getPlayer().getLayoutX());
        Player.getRoot().getChildren().addAll(habilidad);
        ejecutar();
    }
}

package models.elementos.Habilidad.Goku;

import javafx.scene.image.ImageView;
import models.controladores.GameValues;
import models.elementos.Habilidad.Base.habilidadBase;
import models.players.Player;

/**
 * Created by LuisT23 on 8/7/2018.
 */
public class habilidadGoku extends habilidadBase {

    public habilidadGoku(){
        //habilidad=new ImageView(this.getClass().getResource("laserpeach.gif").toExternalForm());

        int direcccion= GameValues.direccion;

        if(direcccion>0){
            habilidad=new ImageView(this.getClass().getResource("lasergokuD.gif").toExternalForm());
            habilidad.setLayoutX(Player.getPlayer().getLayoutX());}
        else{
            habilidad=new ImageView(this.getClass().getResource("lasergokuIzq.gif").toExternalForm());
            habilidad.setLayoutX(Player.getPlayer().getLayoutX()-300);}
        habilidad.setLayoutY(Player.getPlayer().getLayoutY());
        habilidad.setFitWidth(300);
        habilidad.setFitHeight(40);
        Player.getRoot().getChildren().addAll(habilidad);
        ejecutar();
    }
}
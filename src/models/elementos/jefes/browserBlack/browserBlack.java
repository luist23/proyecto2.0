package models.elementos.jefes.browserBlack;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import models.controladores.GameValues;
import models.elementos.jefes.jefeBase;

/**
 * Created by LuisT23 on 7/7/2018.
 */
public class browserBlack extends jefeBase {
    public browserBlack(int x,int y){
        jefe=new ImageView(new Image(this.getClass().getResource("browserBlack.gif").toExternalForm()));
        jefe.setFitHeight(100);
        jefe.setPreserveRatio(true);
        jefe.setLayoutX(x);
        jefe.setLayoutY(y);
        habilidad=new ImageView(new Image(this.getClass().getResource("pisoFuego.gif").toExternalForm()));
        habilidad.setPreserveRatio(false);
        habilidad.setFitHeight(50);
        habilidad.setFitWidth(600);
        habilidad.setLayoutX(GameValues.dimension[0]+25);
        habilidad.setLayoutY(jefe.getLayoutY()+50);
        textVida.autosize();
        textVida.setDisable(true);
        vida=100;
        //textVida.setText("VIDA JEFE:  "+String.valueOf(Player.enemigo.getVida()));
        daño=23;
        iniciar();
    }
}

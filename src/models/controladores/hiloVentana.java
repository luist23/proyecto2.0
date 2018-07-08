package models.controladores;

import javafx.scene.image.ImageView;
import models.players.Player;


/**
 * Created by LuisT23 on 7/7/2018.
 */
public class hiloVentana {
    public hiloVentana(ImageView fondos){
        ImageView fondo=fondos;

        Thread centrarPantalla=new Thread(()->{
            while(Gravedad.exit){

                while (Gravedad.stop && Gravedad.exit){
                    System.out.println("controlo la ventana :v");
                    try {
                        Player.getRoot().setTranslateY(-Player.getPlayer().getLayoutY()+GameValues.dimension[1]/2);
                        fondo.setLayoutY(Player.getPlayer().getLayoutY()-GameValues.dimension[1]/2);
                        Player.box.setLayoutY(fondo.getLayoutY());
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }}});
        centrarPantalla.start();
    }
}

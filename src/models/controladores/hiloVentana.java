package models.controladores;

import javafx.application.Platform;
import javafx.scene.image.ImageView;
import models.elementos.explosivos.enemigos.bombaOMG.bombaOMB;
import models.elementos.explosivos.enemigos.bombaOMG.bombaOMBdatos;
import models.escenarios.pantallaJuego.playScene;
import models.players.Player;


/**
 * Created by LuisT23 on 7/7/2018.
 */
public class hiloVentana {
    public static int iterador=0;
    public hiloVentana(ImageView fondos){
        ImageView fondo=fondos;


        Thread centrarPantalla=new Thread(()->{
            while(Gravedad.exit){

                while (Gravedad.stop && Gravedad.exit) {
                    //System.out.println("controlo la ventana :v");
                    if (Player.getPlayer().getLayoutY() < GameValues.dimension[1] / 2) {
                        try {
                            Player.getRoot().setTranslateY(-Player.getPlayer().getLayoutY() + GameValues.dimension[1] / 2);
                            fondo.setLayoutY(Player.getPlayer().getLayoutY() - GameValues.dimension[1] / 2);
                            Player.box.setLayoutY(fondo.getLayoutY());
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        Player.getRoot().setTranslateY(0);
                        fondo.setLayoutY(0);
                        Player.box.setLayoutY(0);
                        try {
                            Thread.sleep(3000);
                            Player.dinero+=50;

                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }


                    //---------------creando enemigos----------
                    try {
                        Thread.sleep(10);
                        if (iterador > 0){
                            Gravedad.sleeping(50);
                            if (Player.enemigos > 1) {
                                Player.enemigos--;
                                System.out.println(Player.enemigos);
                                Gravedad.sleeping(50);
                                Platform.runLater(() ->playScene.getRocas().add(new bombaOMB(new bombaOMBdatos())));
                                Gravedad.sleeping(50);
                            }

                        }
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }



                    //---------------------------------------

                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        });
        centrarPantalla.start();
    }
}

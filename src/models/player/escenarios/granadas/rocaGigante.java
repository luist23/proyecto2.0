package models.player.escenarios.granadas;

import javafx.application.Platform;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import models.player.GameValues;
import models.player.PlayerRick.Gravedad;
import models.player.PlayerRick.Player;
import models.player.escenarios.granadas.granadaUno;

/**
 * Created by LuisT23 on 2/7/2018.
 */
public class rocaGigante {
    public static String[] rocaEfecto;
    private ImageView roca = new ImageView();
    private Thread uno;
    private boolean vida = true;


    public rocaGigante(){
        rocaEfecto =new String[]{"granadaDivina.gif","granadaDivinaExplocion.gif"};
        roca.setLayoutX(20);
        roca.setLayoutY(23);
        roca.setFitHeight(50);

        roca.setPreserveRatio(true);
        activar();



    }


    public void activar() {
        roca.setImage(new Image(this.getClass().getResource(rocaEfecto[0]).toExternalForm()));
        Player.getRoot().getChildren().addAll(roca);



        uno = new Thread(()->{
            int direccionRoca= GameValues.direccion;
            int tiempoExplosion=1;
            boolean explosion=true;


            while(roca!=null && vida){
                Gravedad.sleeping(15);

            if((GameValues.dimension[0] - granadaUno.dimension[1]) > roca.getLayoutX() && roca.getLayoutX()>0 && vida ){
                int direccionRocafinal=direccionRoca;
                //GameValues.permitirSalto=false;

                /*Platform.runLater(() -> roca.setLayoutY(roca.getLayoutY() - 10));*/

                Platform.runLater(() -> {
                    roca.setLayoutX(roca.getLayoutX() + (direccionRocafinal * 5));
                });

                //}
            }else if (vida){
                direccionRoca=direccionRoca*-1;
                roca.setLayoutX(roca.getLayoutX() + (direccionRoca * 5));

            }
                Gravedad.sleeping(5);

            if(Gravedad.efectoGravedad(roca) && vida){

                if((GameValues.dimension[1] - granadaUno.dimension[1]) > roca.getLayoutY()){

                    Platform.runLater(() -> roca.setLayoutY(roca.getLayoutY() +
                            5));

                }
/*
                tiempoExplosion++;
                Gravedad.sleeping(25);
                System.out.println(tiempoExplosion);

                if (tiempoExplosion>40){
                    explosion=false;
                    explosion();
                    break;
                }
*/



            }
            }


            /*while (explosion) {
                Gravedad.sleeping(25);
                tiempoExplosion++;
                if (tiempoExplosion>40){
                    explosion();
                    break;}

            }*/


            //g.setPosicionFinal(posicionFinal);


            //imageView.setImage(new Image(values.getClass().getResource(posicionFinal[0]).toExternalForm()));

        });
        uno.setDaemon(true);
        //thread.start();
        uno.start();
    }


    public ImageView getRoca() {
        return roca;
    }

    public void explosion(){
        vida=false;
        Thread explosion= new Thread(()->{


        Gravedad.sleeping(10);
        //uno.setDaemon(false);
        //uno.interrupt();
        //uno.interrupt();
        //uno.destroy();

       // roca.setImage(new Image(this.getClass().getResource(rocaEfecto[1]).toExternalForm()));

       // Gravedad.sleeping(3500);

        roca.setImage(new Image(this.getClass().getResource(rocaEfecto[1]).toExternalForm()));
        System.out.println("implosion");

        Gravedad.sleeping(1400);

        //granada.relocate(-25,-25);

        roca.setImage(null);
    });
    explosion.setDaemon(true);
    explosion.start();
    }

    public Thread getUno() {
        return uno;
    }


}

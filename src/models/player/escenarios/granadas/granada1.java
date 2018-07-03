package models.player.escenarios.granadas;

import javafx.application.Platform;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import models.player.GameValues;
import models.player.PlayerRick.Gravedad;
import models.player.PlayerRick.Player;
import models.player.peldannos.Peldanno;

public class granada1 implements granada <granadaUno>{
    public static String[] granadaEfecto;
    ImageView granada = new ImageView();
    Media implosion=new Media(this.getClass().getResource("HOLYGRENADE.WAV").toExternalForm());
    MediaPlayer player=new MediaPlayer(implosion);
    Media implosionFinal=new Media(this.getClass().getResource("explosion1.WAV").toExternalForm());
    MediaPlayer playerFinal=new MediaPlayer(implosionFinal);

    public granada1(){
        granadaEfecto=new String[]{"granadaDivina.gif","granadaDivinaTiempo.gif","granadaDivinaExplocion.gif"};
        granada.setLayoutX(Player.getPlayer().getLayoutX());
        granada.setLayoutY(Player.getPlayer().getLayoutY());
        granada.setFitHeight(50);

        granada.setPreserveRatio(true);
        activar();



    }

    @Override
    public void activar() {
        granada.setImage(new Image(this.getClass().getResource(granadaEfecto[0]).toExternalForm()));
        Player.getRoot().getChildren().addAll(granada);
        Thread uno = new Thread(()->{
            int direccion=GameValues.direccion;

            for (int i=1 ; i<15;i++){
                //GameValues.permitirSalto=false;

                Platform.runLater(() -> granada.setLayoutY(granada.getLayoutY() - 10));
                Platform.runLater(() -> granada.setLayoutX(granada.getLayoutX() + (5*direccion)));
                Gravedad.sleeping(25);
                //}
            }
            int tiempoExplosion=1;
            boolean explosion=true;
            while(Gravedad.efectoGravedad(granada)){

                if((GameValues.dimension[1] - granadaUno.dimension[1]) > granada.getLayoutY() || Gravedad.efectoGravedad(granada)){



                    if (GameValues.dimension[0] - granadaUno.dimension[0] > granada.getLayoutX()){
                        Platform.runLater(() -> granada.setLayoutX(granada.getLayoutX() +
                                (5*direccion)));
                    }
                    Platform.runLater(() -> granada.setLayoutY(granada.getLayoutY() +
                            5));

                }


            Gravedad.sleeping(25);
                tiempoExplosion++;
                //System.out.println(tiempoExplosion);

                if (tiempoExplosion>40){

                    if(!explosion(tiempoExplosion)){
                        explosion=false;
                    break;}
                }




        }


            while (explosion) {
                Gravedad.sleeping(25);
                tiempoExplosion++;
                if (tiempoExplosion>40){
                    if(!explosion(tiempoExplosion))
                        break;}

            }


            //g.setPosicionFinal(posicionFinal);


            //imageView.setImage(new Image(values.getClass().getResource(posicionFinal[0]).toExternalForm()));

        });
        uno.setDaemon(true);
        //thread.start();
        uno.start();
    }

    @Override
    public ImageView getGranada() {
        return null;
    }

    public boolean explosion(int i){
        //System.out.println(i);
        if(i==41){
        granada.setImage(new Image(this.getClass().getResource(granadaEfecto[1]).toExternalForm()));}


        if(i==120)
        player.play();

        if(i==190){
            Gravedad.sleeping(300);
            playerFinal.play();


        granada.setImage(new Image(this.getClass().getResource(granadaEfecto[2]).toExternalForm()));

        Gravedad.sleeping(1100);
            System.out.println("fatality");

        //granada.relocate(-25,-25);

        granada.setImage(null);
        return false;
        }
        return true;
    }


}

package models.player.escenarios.explosivos.granadas.base;

import javafx.application.Platform;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import models.player.GameValues;
import models.player.PlayerRick.Gravedad;
import models.player.PlayerRick.Player;
import models.player.escenarios.explosivos.enemigos.Base.roca;
import models.player.escenarios.playScene;

public abstract class granada1 <T>implements granada <T>{
    protected String[] granadaEfecto;
    protected ImageView granada;
    protected Media implosion;
    protected MediaPlayer player;
    protected Media implosionFinal;
    protected MediaPlayer playerFinal;
    protected int daño=50;
    protected T granadaBase;
    protected int[] dimensione;

    protected abstract void inicio();
    protected granada1(){}

    public void inicializar(){

        granada=new ImageView();
        granada.setLayoutX(Player.getPlayer().getLayoutX());
        granada.setLayoutY(Player.getPlayer().getLayoutY());
        granada.setFitHeight(dimensione[0]);
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
                if((granada.getLayoutX() + (5*direccion))>0 && (granada.getLayoutX() + (5*direccion))< GameValues.dimension[0])
                Platform.runLater(() -> granada.setLayoutX(granada.getLayoutX() + (5*direccion)));
                Gravedad.sleeping(25);
                //}
            }
            int tiempoExplosion=1;
            boolean explosion=true;
            while(Gravedad.efectoGravedad(granada)){

                if((GameValues.dimension[1] - dimensione[1]-5) > granada.getLayoutY() || Gravedad.efectoGravedad(granada)){


                    if((GameValues.dimension[1] - dimensione[1]-5) > granada.getLayoutY()){
                    if((granada.getLayoutX() + (5*direccion))>0 && (granada.getLayoutX() + 15)< GameValues.dimension[0]){
                        Platform.runLater(() -> granada.setLayoutX(granada.getLayoutX() +
                                (5*direccion)));
                    }


                    Platform.runLater(() -> granada.setLayoutY(granada.getLayoutY() +
                            5));}

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

    @Override
    public boolean explosion(int i){
        //System.out.println(i);
       return explotar(i);
    }

    protected abstract boolean explotar(int i);

    @Override
    public void destruir() {
        try {
            for (roca r : playScene.getRocas()) {
                if (Gravedad.overlapingImageView(r.getRoca(), granada)) {
                    r.setDaño(daño);
                    Gravedad.sleeping(15);
                }
            }
            if (Gravedad.overlapingImageView(granada, Player.getPlayer())) {
                Player.setDaño(daño);
            }
        } catch (Exception e) {
            System.out.println("error en revision de enemigos");

        }
        finally {
            Gravedad.sleeping(1100);
            granada.setImage(null);
        }
    }


}

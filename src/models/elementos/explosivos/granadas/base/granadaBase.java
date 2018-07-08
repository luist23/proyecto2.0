package models.elementos.explosivos.granadas.base;

import javafx.application.Platform;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import models.controladores.GameValues;
import models.controladores.Gravedad;
import models.elementos.explosivos.enemigos.Base.roca;
import models.players.Player;
import models.escenarios.pantallaJuego.playScene;

import java.util.ArrayList;

public abstract class granadaBase<T>implements granada <T>{
    protected String[] granadaEfecto;
    protected ImageView granada;
    protected Media implosion;
    protected MediaPlayer player;
    protected Media implosionFinal;
    protected MediaPlayer playerFinal;
    protected int daño;
    protected T granadaBase;
    protected int[] dimensione;

    protected abstract void inicio();
    protected granadaBase(){}

    public void inicializar(){

        granada=new ImageView();
        granada.setLayoutX(Player.getPlayer().getLayoutX());
        granada.setLayoutY(Player.getPlayer().getLayoutY());
        granada.setFitHeight(dimensione[0]);
        granada.setPreserveRatio(true);
        playerFinal=new MediaPlayer(implosionFinal);
        player=new MediaPlayer(implosion);
        activar();



    }

    @Override
    public void activar() {
        granada.setImage(new Image(this.getClass().getResource(granadaEfecto[0]).toExternalForm()));
        Player.getRoot().getChildren().addAll(granada);
        Thread uno = new Thread(()->{
            int direccion=GameValues.direccion;

            for (int i=1 ; i<7;i++){
                //GameValues.permitirSalto=false;

                Platform.runLater(() -> granada.setLayoutY(granada.getLayoutY() - 10));
                if((granada.getLayoutX() + (25*direccion))>0 && (granada.getLayoutX() + (25*direccion))< GameValues.dimension[0])
                Platform.runLater(() -> granada.setLayoutX(granada.getLayoutX() + (25*direccion)));
                Gravedad.sleeping(25);
                //}
            }
            int tiempoExplosion=1;
            boolean explosion=true;

            while(explosion){
            while(Gravedad.efectoGravedad(granada) && Gravedad.stop){

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


            while (explosion && Gravedad.stop) {
                Gravedad.sleeping(25);

                tiempoExplosion++;
                if (tiempoExplosion>40){
                    if(!explosion(tiempoExplosion))
                        explosion=false;
                        break;}

            }
            if(!Gravedad.stop){
            Gravedad.sleeping(1000);}

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
       return explotar(i);
    }

    protected abstract boolean explotar(int i);

    @Override
    public void destruir() {
        granada.setFitHeight(dimensione[0]*3);
        granada.setLayoutY(granada.getLayoutY()-dimensione[0]*2);
        granada.setLayoutX(granada.getLayoutX()-dimensione[0]);
        ArrayList<roca> destruidos=new ArrayList<>();
        try {
            for (roca r : playScene.getRocas()) {
                if (Gravedad.overlapingImageView(r.getRoca(), granada)) {
                    destruidos.add(r);
                    r.getRoca().setLayoutX(-300);
                }

            }

            for(roca d:destruidos){
                playScene.getRocas().remove(d);
                d.setDaño(daño);

            }
            destruidos.clear();
            if (Gravedad.overlapingImageView(granada, Player.getPlayer())) {
                Player.setDaño(daño);
            }
            if (Gravedad.overlapingImageView(Player.enemigo.getJefe(), Player.getPlayer())) {
                Player.enemigo.setDaño(daño);
            }
        } catch (Exception e) {
            System.out.println("error en revision de enemigos");

        }
        finally {
            Gravedad.sleeping(1100);
            granada.setImage(null);
            granada.setLayoutX(-300);
        }
    }


}

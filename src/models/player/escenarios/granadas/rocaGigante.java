package models.player.escenarios.granadas;

import javafx.application.Platform;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import models.player.GameValues;
import models.player.PlayerRick.Gravedad;
import models.player.PlayerRick.Player;
import models.player.escenarios.granadas.granadaUno;
import models.player.escenarios.playScene;

/**
 * Created by LuisT23 on 2/7/2018.
 */
public class rocaGigante {
    public static String[] rocaEfecto;
    private ImageView roca = new ImageView();
    private Thread uno;
    private boolean vida = true;
    private int totalVida=10;
    Media implosionFinal=new Media(this.getClass().getResource("explosion3.WAV").toExternalForm());
    MediaPlayer playerFinal=new MediaPlayer(implosionFinal);
    private int iterador=1;


    public rocaGigante(){
        rocaEfecto =new String[]{"bombaOmbDerecha.gif","bombaOmb.gif","granadaDivinaExplocion.gif"};
        roca.setLayoutX(20);
        roca.setLayoutY(23);
        roca.setFitHeight(50);

        roca.setPreserveRatio(true);
        activar();




    }
    private  boolean iterando(){
        if (iterador>15){
            iterador=1;
            return true;

        }
        return false;

    }


    public void activar() {
        roca.setImage(new Image(this.getClass().getResource(rocaEfecto[0]).toExternalForm()));
        Player.getRoot().getChildren().addAll(roca);




        uno = new Thread(()->{
            int direccionRoca= GameValues.direccion;
            int tiempoExplosion=1;
            boolean explosion=true;
            int dimension=GameValues.dimension[0] - granadaUno.dimension[1];
            int cambiardireccion=1;



            while(roca!=null && vida){
                Gravedad.sleeping(15);

            if(dimension > roca.getLayoutX() && roca.getLayoutX()>0 && vida ){
                int direccionRocafinal=direccionRoca;
                //GameValues.permitirSalto=false;

                /*Platform.runLater(() -> roca.setLayoutY(roca.getLayoutY() - 10));*/

                Platform.runLater(() -> {
                    roca.setLayoutX(roca.getLayoutX() + (direccionRocafinal * 5));
                    if(roca.getLayoutX()<0){roca.setLayoutX(5);}
                    if(roca.getLayoutX()>dimension)roca.setLayoutX(dimension-5);
                });

                //}
            }else
                if (vida){
                direccionRoca=direccionRoca*-1;
                    if(direccionRoca==1){
                        roca.setImage(new Image(this.getClass().getResource(rocaEfecto[0]).toExternalForm()));
                    }
                    else{
                        roca.setImage(new Image(this.getClass().getResource(rocaEfecto[1]).toExternalForm()));
                    }
                roca.setLayoutX(roca.getLayoutX() + (direccionRoca * 5));

            }
                Gravedad.sleeping(5);

            if(Gravedad.efectoGravedad(roca) && vida){

                if((GameValues.dimension[1] - granadaUno.dimension[1]) > roca.getLayoutY()){

                    Platform.runLater(() -> roca.setLayoutY(roca.getLayoutY() +
                            5));
                    //System.out.println(cambiardireccion);
                    iterador++;




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

            }else {
                    if(iterando()){
                        //cambiardireccion=1;
                        direccionRoca*=-1;
                        if(direccionRoca==1){
                            roca.setImage(new Image(this.getClass().getResource(rocaEfecto[0]).toExternalForm()));
                        }
                        else{
                            roca.setImage(new Image(this.getClass().getResource(rocaEfecto[1]).toExternalForm()));
                        }
                    }
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
        Thread dos=new Thread(()->{




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

        roca.setImage(new Image(this.getClass().getResource(rocaEfecto[2]).toExternalForm()));
        //System.out.println("implosion");
            playerFinal.play();

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

    public void setDaño(int daño){
        totalVida-=daño;
        if(totalVida<0){
            desactivar();

        }
    }
    private void desactivar(){
        vida=false;
        for (rocaGigante r:playScene.getRocas()){
            if(r==this){
                playScene.getRocas().remove(this);
                break;
            }
        }
        roca.setImage(null);

    }


}

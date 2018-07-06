package models.elementos.explosivos.enemigos.Base;

import javafx.application.Platform;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import models.controladores.GameValues;
import models.controladores.Gravedad;
import models.players.PlayerRick.Player;

/**
 * Created by LuisT23 on 2/7/2018.
 */
public abstract class rocaGigante <T>implements  roca <T>{
    public static String[] rocaEfecto;

    protected Thread uno;
    protected boolean vida = true;
    protected int totalVida=10;
    protected T gran;
    protected ImageView roca;
    protected int[] dimensione;
    protected Media implosionFinal;
    protected MediaPlayer playerFinal;
    protected int iterador=1;
    private int[] azar={1,-1,1,-1,-1};
    private  Boolean stop=true;


    public int aleatorio(){
        return azar[(int)(Math.random()*4)];
    }


    protected rocaGigante(){

    }

    @Override
    public void setPausa(boolean pause) {
        if (pause){
            stop=false;
        }
        else{stop=true;
        }
    }

    protected void inicializar(){

        roca.setLayoutX(20);
        roca.setLayoutY(23);
        playerFinal=new MediaPlayer(implosionFinal);

        roca.setPreserveRatio(true);
        activar();

    }
    protected abstract void inicio();
    protected   boolean iterando(){
        if (iterador>15){
            iterador=1;
            return true;

        }
        return false;

    }

    @Override
    public void activar() {
        roca.setImage(new Image(this.getClass().getResource(rocaEfecto[0]).toExternalForm()));
        Player.getRoot().getChildren().addAll(roca);




        uno = new Thread(()->{

            int direccionRoca= GameValues.direccion;
            //int tiempoExplosion=1;
            //boolean explosion=true;
            int dimension=GameValues.dimension[0] - dimensione[1];
            //int cambiardireccion=1;

            while (vida){
                while(Gravedad.stop && vida && stop){
            while(roca!=null && vida && Gravedad.stop && stop){

                Gravedad.sleeping(15);

            if(dimension > roca.getLayoutX() && roca.getLayoutX()>0 && vida ){
                int direccionRocafinal=direccionRoca;
                Platform.runLater(() -> {
                    roca.setLayoutX(roca.getLayoutX() + (direccionRocafinal * 5));
                    if(roca.getLayoutX()<0){roca.setLayoutX(5);}
                    if(roca.getLayoutX()>dimension)roca.setLayoutX(dimension-5);
                });

                //}
            }else
                if (vida){
                direccionRoca=direccionRoca*-1;
                    //System.out.println(direccionRoca);
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

                if((GameValues.dimension[1] - dimensione[1]) > roca.getLayoutY()){

                    Platform.runLater(() -> roca.setLayoutY(roca.getLayoutY() +
                            5));
                    //System.out.println(cambiardireccion);
                    iterador++;
                }

            }else {
                    if(iterando()){
                        //cambiardireccion=1;
                        direccionRoca*=aleatorio();
                        if(direccionRoca==1){
                            roca.setImage(new Image(this.getClass().getResource(rocaEfecto[0]).toExternalForm()));
                        }
                        else{
                            roca.setImage(new Image(this.getClass().getResource(rocaEfecto[1]).toExternalForm()));
                        }
                    }
                }



            }
        }Gravedad.sleeping(1000);
            }
        });
        //Thread dos=new Thread(()->{           });


        uno.setDaemon(true);
        //thread.start();
        uno.start();
    }

    @Override
    public ImageView getRoca() {
        return roca;
    }

    @Override
    public void explosion(){
        vida=false;
        Thread explosion= new Thread(()->{
        Gravedad.sleeping(10);
        roca.setImage(new Image(this.getClass().getResource(rocaEfecto[2]).toExternalForm()));
            playerFinal.play();
        Gravedad.sleeping(1400);
        roca.setImage(null);
    });
    explosion.setDaemon(true);
    explosion.start();
    }



    //@Override     public Thread getUno() {     return uno;    }

    @Override
    public void setDaño(int daño){
        totalVida-=daño;
        if(totalVida<0){
            desactivar();
        }
    }


    protected void desactivar(){
        vida=false;
        roca.setImage(null);
        Player.enemigos++;
    }

    /*
    @Override
    public  void pausar(){
        stop=false;
    }
    @Override
    public  void resume(){
        stop=true;
    }*/


}

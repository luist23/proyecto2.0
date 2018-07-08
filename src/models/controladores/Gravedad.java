package models.controladores;

import javafx.application.Platform;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import models.players.Player;
import models.escenarios.pantallaJuego.playScene;
import models.elementos.peldannos.Peldanno;
import models.players.Base.Players;


import java.util.ArrayList;

public class Gravedad  extends Thread {
    private ImageView player;
    private ArrayList<ImageView> bombas;
    private ArrayList<ImageView> peldanho;
    private boolean efecto;
    private Players values;
    private String[] posicionFinal;
    public static boolean stop=true;
    private boolean pausar=true;
    public static boolean exit=true;

    public Gravedad(ImageView player,Players values){

        this.player=player;
        this.values=values;
        bombas=new ArrayList<>();
        peldanho=new ArrayList<>();
        efecto=true;
    }

    public void setBombas(ImageView bomba){
        bombas.add(bomba);
    }

    public void overlapingPeldanno(){
        for(ImageView e:peldanho){
        if(player.getBoundsInParent().intersects(e.getBoundsInParent())){
            System.out.println("overlapping :v");
            efecto=false;
        }}}


        public void setPosicionFinal(String[] pocision){
        this.posicionFinal=pocision;
            //System.out.println(posicionFinal[0]);
        }

        public static void sleeping(int sleep){
            try {
                Thread.sleep(sleep);


            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }


    @Override
    public void run()  {


        int i=1;
        while(exit){

            //System.out.println("pausado");

        while(stop && exit){
            //System.out.println("sigovivoGravedad");

        while(efectoGravedad(Player.getPlayer()) && stop){


            if((GameValues.dimension[1] - values.getSizePlayer()[1]) > player.getLayoutY()){
            Platform.runLater(() -> player.setLayoutY(player.getLayoutY() +
                   5));

        }


            sleeping(25);



        }
            i++;
            sleeping(100);
            if(i>15 && !GameValues.gravedad && stop){
                i=1;

                player.setImage(new Image(values.getClass().getResource(posicionFinal[0]).toExternalForm()));
            }
            //System.out.println("sigo aqui");


        }
            sleeping(1000);
    }}

    public static boolean efectoGravedad(ImageView elemento){

        for (Peldanno p: playScene.getPeldannos()){
            if(overlapingPeldanno(p,elemento)){
                GameValues.permitirSalto=true;
                return false;}
        }

        return true;
    }

    public static boolean overlapingPeldanno(Peldanno p, ImageView elemento){

        if(overlapingImageView(p.getPeldanno(),elemento)){
            GameValues.gravedad=false;
            return true;

        }
        GameValues.gravedad=true;
            return false;

    }

    public static boolean overlapingImageView(ImageView imagen,ImageView elemento){

        //imagen.getBoundsInParent().intersects(elemento.getBoundsInParent());
        return imagen.getBoundsInParent().intersects(elemento.getBoundsInParent());
    }

    public static void setStop(boolean stope){
        stop=stope;
    }

    /*
    public void pausar(){
        stop=false;

    }

    public void resumir(){
        stop=true;
    }
    public Boolean getStop(){
        return stop;
    }*/


}

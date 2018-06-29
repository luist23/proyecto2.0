package models.player.PlayerRick;

import com.sun.jmx.snmp.tasks.ThreadService;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import models.player.GameValues;
import models.player.escenarios.playScene;
import models.player.peldannos.Peldanno;


import java.util.ArrayList;

public class Gravedad <PlayerValuesRick>extends Thread {
    private ImageView player;
    private ArrayList<ImageView> bombas;
    private ArrayList<ImageView> peldanho;
    private boolean efecto;
    private PlayerValuesRick values;
    private String[] posicionFinal;

    public Gravedad(ImageView player,PlayerValuesRick values){

        this.player=player;
        this.values=values;
        bombas=new ArrayList<>();
        peldanho=new ArrayList<>();
        efecto=true;
    }

    public void setBombas(ImageView bomba){
        bombas.add(bomba);
    }

    public void overlaping(){
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
        while(true){

        while(efectoGravedad()){


            if((GameValues.dimension[1] - models.player.PlayerRick.PlayerValuesRick.sizePlayer[1]) > player.getLayoutY()){
            Platform.runLater(() -> player.setLayoutY(player.getLayoutY() +
                   5));

        }else {
                break;
            }


            sleeping(25);



        }
            i++;
            sleeping(100);
            if(i>15 && !GameValues.gravedad){
                i=1;
                //models.player.PlayerRick.PlayerValuesRick.action=true;
                player.setImage(new Image(values.getClass().getResource(posicionFinal[0]).toExternalForm()));
            }


        }
    }

    public boolean efectoGravedad(){
        //sleeping(25);
        //boolean efecto=true;
        for (Peldanno p: playScene.getPeldannos()){
            if(overlaping(p)){
                models.player.PlayerRick.PlayerValuesRick.action=true;
                return false;}
        }
        return true;
    }

    public boolean overlaping(Peldanno p){
        if(p.getPeldanno().getBoundsInParent().intersects(Player.getPlayer().getBoundsInParent())){
            GameValues.gravedad=false;
            return true;

        }
        GameValues.gravedad=true;
            return false;

    }
}

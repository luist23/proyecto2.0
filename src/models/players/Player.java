package models.players;

import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import models.elementos.jefes.Jefe;
import models.players.Base.Players;

public class Player {

    private static Player ourInstance;
    private static ImageView player;
    private static Pane root;
    public static boolean salto=true;
    private static int vida;
    public static int enemigos=15;
    public static int granadasEnPocesion=5;
    public static Players playerBase;
    public static boolean action=true;
    public static int pasosTotales=4;
    public static int tiempoPaso=300;
    public static int distanciaPaso=5;
    public static TextField textVida =new TextField();
    public static HBox box =new HBox();
    public static Jefe enemigo;
    public static int dinero=2300;


    private Player() {}
    public static Player getInstance() {
        if(ourInstance==null){
            ourInstance= new Player();
            textVida.autosize();
            textVida.setDisable(true);
            player = new ImageView();
            player.setFitHeight(playerBase.getSizePlayer()[0]);
            player.setFitWidth(playerBase.getSizePlayer()[1]);
            player.setPreserveRatio(true);
            root=new Pane();
            root.setMinSize(playerBase.getSizePlayer()[0],playerBase.getSizePlayer()[1]*5);
            vida=23;
            jugador();


        }
        return ourInstance;
    }


    public static void setPlayer(ImageView player) { Player.player = player;}


    public static ImageView getPlayer() {  return player;}
    public static Pane getRoot() { return root;}
    public static int getVida() {
        return vida;
    }
    public static Players getPlayerBase(){  return playerBase;   }



    private static void jugador(){
        player.setImage(new Image(playerBase.getClass().getResource(playerBase.getDerecha()[0]).toExternalForm()));
        player.setLayoutX(10);
        player.setLayoutY(103);
    }

    public static void setDaño(int Daño) {
        System.out.println("me hirieron :´v");
        vida -= Daño;
        textVida.setText("VIDA RESTANTE:  "+vida);
    }
    public static void setVida(int vid){
        vida+=vid;
        
    }
    
    


}

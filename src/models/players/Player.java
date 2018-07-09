package models.players;

import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import models.controladores.GameValues;
import models.elementos.explosivos.granadas.factory.granadaType;
import models.elementos.jefes.Jefe;
import models.players.Base.Players;
import models.players.factory.playerType;

import java.util.ArrayList;

public class Player {

    private static Player ourInstance;
    private static ImageView player;
    private static Pane root;
    public static boolean salto=true;
    public static int vida=100;
    public static int enemigos=15;
    public static int granadasEnPocesion=5;
    public static Players playerBase;
    public static boolean action=true;
    public static int pasosTotales=4;
    public static int tiempoPaso=300;
    public static int distanciaPaso=5;
    public static TextField textVida =new TextField();
    public static TextField textDinero =new TextField();
    public static HBox box =new HBox();
    public static Jefe enemigo;
    public static int dinero=5000;
    public static ArrayList<granadaType> granadasDisponibles=new ArrayList<>();
    public static playerType personaje=playerType.GOKU;
    public static Scene playScene;
    public static int especial=3;



    private Player() {}
    public static Player getInstance() {
        if(ourInstance==null){
            ourInstance= new Player();
            textVida.autosize();
            textVida.setDisable(true);
            textDinero.autosize();
            textDinero.setDisable(true);
            player = new ImageView();
            player.setFitHeight(playerBase.getSizePlayer()[0]);
            player.setFitWidth(playerBase.getSizePlayer()[1]);
            player.setPreserveRatio(true);
            root=new Pane();
            root.setMinSize(playerBase.getSizePlayer()[0],playerBase.getSizePlayer()[1]*5);

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
        player.setLayoutX(70);
        player.setLayoutY(GameValues.dimension[1]-125);
    }

    public static void setDaño(int Daño) {
        System.out.println("me hirieron :´v");
        vida -= Daño;
        textVida.setText("VIDA RESTANTE:  "+vida);
    }
    public static int setVida(int vid){
        vida+=vid;
        return vida;
    }
    public static void setRoot(){
        root=new Pane();
    }
    
    


}

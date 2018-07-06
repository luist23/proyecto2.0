package models.players.PlayerRick;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import models.players.Players;

public class Player {

    private static Player ourInstance;
    private static ImageView player;
    private static Pane root;
    public static boolean salto=true;
    private static int vida;
    public static int enemigos=15;
    public static int granadasEnPocesion=5;
    private static Players playerBase;


    private Player() {}
    public static Player getInstance() {
        if(ourInstance==null){
            ourInstance= new Player();
            player = new ImageView();
            playerBase=new Rick();
            player.setFitHeight(playerBase.getSizePlayer()[0]);
            player.setFitWidth(playerBase.getSizePlayer()[1]);
            player.setPreserveRatio(true);
            root=new Pane();
            vida=23;
            jugador();


        }
        return ourInstance;
    }


    public static void setPlayer(ImageView player) { Player.player = player;}
    public static void setRoot(Pane root) { root = root;}


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
        Player.vida -= Daño;
    }


}

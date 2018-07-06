package models.players.PlayerRick;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class Player {

    private static Player ourInstance;
    private static ImageView player;
    private static Pane root;
    public static boolean salto=true;
    private static int vida;
    public static int enemigos=15;
    public static int granadasEnPocesion=5;



    public static Player getInstance() {
        if(ourInstance==null){
            ourInstance= new Player();
            player = new ImageView();
            player.setFitHeight(PlayerValuesRick.sizePlayer[0]);
            player.setFitWidth(PlayerValuesRick.sizePlayer[1]);
            player.setPreserveRatio(true);
            root=new Pane();
            vida=23;
            /*ScrollPane scrollPane = new ScrollPane();
            scrollPane.setPannable(true);
            scrollPane.setContent(players);
            scrollPane.setVisible(true);
            scrollPane.
            root.getChildren().add(scrollPane);*/
            jugador();


        }
        return ourInstance;
    }

    private Player() {}

    public static ImageView getPlayer() {  return player;}

    public static void setPlayer(ImageView player) { Player.player = player;}

    public static Pane getRoot() { return root;}

    public static void setRoot(Pane root) { root = root;}

    private static void jugador(){
        player.setImage(new Image(PlayerValuesRick.getInstance().getClass().getResource(PlayerValuesRick.derecha[0]).toExternalForm()));
        player.setLayoutX(10);
        player.setLayoutY(103);
    }

    public static int getVida() {
        return vida;
    }

    public static void setDaño(int Daño) {
        System.out.println("me hirieron :´v");
        Player.vida -= Daño;
    }
}
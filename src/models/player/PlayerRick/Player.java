package models.player.PlayerRick;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class Player {

    private static Player ourInstance;
    private static ImageView player;
    private static Pane root;



    public static Player getInstance() {
        if(ourInstance==null){
            ourInstance= new Player();
            player = new ImageView();
            player.setFitHeight(PlayerValuesRick.sizePlayer[0]);
            player.setFitWidth(PlayerValuesRick.sizePlayer[1]);
            player.setPreserveRatio(true);
            root=new Pane();
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
}

package models.player.peldannos;


import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import models.player.GameValues;
import models.player.PlayerRick.Player;

public class Peldanno {
    private ImageView peldanno;
    public Peldanno(int X, int Y){

        peldanno=new ImageView();
        peldanno.setFitHeight(10);
        peldanno.setFitWidth(900);
        peldanno.setPreserveRatio(true);
        peldanno.setImage(new Image(GameValues.getInstance().getClass().getResource("peldanno.png").toExternalForm()));
        peldanno.setLayoutX(X);
        peldanno.setLayoutY(Y);
        Player.getRoot().getChildren().addAll(peldanno);

    }

    public ImageView getPeldanno() {
        return peldanno;
    }

    public void setPeldanno(ImageView peldanno) {
        this.peldanno = peldanno;
    }
}

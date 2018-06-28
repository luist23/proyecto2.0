package models.player.peldannos;


import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import models.player.GameValues;
import models.player.PlayerRick.Player;

public class Peldanno {
    private ImageView peldanno;
    public Peldanno(int a, int b){

        peldanno=new ImageView();
        peldanno.setFitHeight(50);
        peldanno.setFitWidth(800);
        peldanno.setPreserveRatio(true);
        peldanno.setImage(new Image(GameValues.getInstance().getClass().getResource("peldanno.png").toExternalForm()));
        peldanno.setLayoutX(a);
        peldanno.setLayoutY(b);
        Player.getRoot().getChildren().addAll(peldanno);

    }

    public ImageView getPeldanno() {
        return peldanno;
    }

    public void setPeldanno(ImageView peldanno) {
        this.peldanno = peldanno;
    }
}

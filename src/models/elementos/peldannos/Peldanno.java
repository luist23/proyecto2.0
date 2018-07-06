package models.elementos.peldannos;


import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import models.players.PlayerRick.Player;

public class Peldanno {
    private ImageView peldanno;
    public Peldanno(int X, int Y){

        peldanno=new ImageView();
        peldanno.setFitHeight(10);
        peldanno.setFitWidth(900);
        peldanno.setPreserveRatio(true);
        peldanno.setImage(new Image(this.getClass().getResource("Peldanno.png").toExternalForm()));
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

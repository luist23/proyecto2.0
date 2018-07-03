package models.player.escenarios;

import javafx.scene.image.ImageView;
import models.player.PlayerRick.Gravedad;
import models.player.PlayerRick.Player;

import java.util.ArrayList;

/**
 * Created by LuisT23 on 2/7/2018.
 */
public class gravedadAumentada extends Thread{
    private ImageView player= Player.getInstance().getPlayer();
    private ArrayList<ImageView> elementos=new ArrayList<>();
    @Override
    public void run() {
        while (true){
            if(Gravedad.efectoGravedad(player)){
                player.setLayoutY(player.getLayoutY()+5);
            }
            for (ImageView e: elementos){
                if(Gravedad.efectoGravedad(e)){
                    e.setLayoutY(e.getLayoutY()+5);
                }
            }
            try {
                sleep(25);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }
    }
}

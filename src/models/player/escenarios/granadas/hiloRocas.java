package models.player.escenarios.granadas;

import models.player.PlayerRick.Gravedad;
import models.player.PlayerRick.Player;
import models.player.escenarios.playScene;

/**
 * Created by LuisT23 on 2/7/2018.
 */
public class hiloRocas extends Thread {


    public void run(){
    while (true) {

        if(true){
            for (rocaGigante r : playScene.getRocas()) {
                if (Gravedad.overlapingImageView(r.getRoca(), Player.getPlayer())) {

                    playScene.getRocas().remove(r);

                    System.out.println("contacto");
                    Gravedad.sleeping(15);
                    //r.getUno().interrupt();
                    r.explosion();
                    System.out.println("next element");
                    break;


                }
            }
        }
    Gravedad.sleeping(25);
    }
    }

    }


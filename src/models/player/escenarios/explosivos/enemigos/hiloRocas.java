package models.player.escenarios.explosivos.enemigos;

import models.player.PlayerRick.Gravedad;
import models.player.PlayerRick.Player;
import models.player.escenarios.explosivos.enemigos.Base.roca;
import models.player.escenarios.playScene;

/**
 * Created by LuisT23 on 2/7/2018.
 */
public class hiloRocas extends Thread {


    public void run(){
    while (true) {

        if(true){
            for (roca r : playScene.getRocas()) {
                if(r.getRoca()==null){
                    Gravedad.sleeping(25);
                    //playScene.getRocas().remove(r);
                    System.out.println("removido nullo");
                    break;
                }
                if (Gravedad.overlapingImageView(r.getRoca(), Player.getPlayer())) {


                    playScene.getRocas().remove(r);

                    //System.out.println("contacto");
                    Gravedad.sleeping(15);
                    //r.getUno().interrupt();
                    r.explosion();
                    Player.setDaño(5);
                    //System.out.println("next element");
                    System.out.println(Player.getVida());
                    Player.enemigos++;
                    break;


                }
            }
        }
    Gravedad.sleeping(25);
    }
    }

    }


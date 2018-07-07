package models.elementos.explosivos.enemigos.controlador;

import models.controladores.Gravedad;
import models.elementos.explosivos.enemigos.Base.roca;
import models.players.Player;
import models.escenarios.playScene;

/**
 * Created by LuisT23 on 2/7/2018.
 */
public class hiloRocas extends Thread {
    private boolean stop=true;
    public static boolean exit=true;


    public void run(){
    while (exit) {
        while(Gravedad.stop && exit){

        if(true){
            for (roca r : playScene.getRocas()) {
                if(r.getRoca()==null){
                    Gravedad.sleeping(25);
                    System.out.println("removido nullo");
                    break;
                }
                if (Gravedad.overlapingImageView(r.getRoca(), Player.getPlayer())) {
                    playScene.getRocas().remove(r);
                    Gravedad.sleeping(15);
                    r.explosion();
                    Player.setDaño(5);

                    System.out.println(Player.getVida());
                    Player.enemigos++;
                    break;
                }
            }
        }
    Gravedad.sleeping(25);
    }
    Gravedad.sleeping(1000);
    }}

    /*
    public boolean isStop() {
        return stop;
    }
    public void pausar(){
        stop=false;
        for(roca r:playScene.getRocas()){
            r.pausar();
        }
    }
    public void resumir(){
        stop=true;
        for(roca r:playScene.getRocas()){
            r.resume();
        }
    }*/
}


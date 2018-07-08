package models.elementos.explosivos.enemigos.controlador;

import models.controladores.Gravedad;
import models.elementos.explosivos.enemigos.Base.roca;
import models.elementos.peldannos.Peldanno;
import models.players.Player;
import models.escenarios.pantallaJuego.playScene;

import java.util.ArrayList;

/**
 * Created by LuisT23 on 2/7/2018.
 */
public class hiloRocas extends Thread {
    private boolean stop=true;
    public static boolean exit=true;
    public static ArrayList<Peldanno> peldanos=new ArrayList<>();


    public void run(){
        boolean flag=true;
    while (exit) {
        while(Gravedad.stop && exit){

        if(true){
            for (roca r : playScene.getRocas()) {
                for(Peldanno p:peldanos){
                    if(p.getPeldanno().getBoundsInParent().intersects(r.getRoca().getBoundsInParent())){
                        try {
                            r.getRoca().setLayoutX(-500);
                            Thread.sleep(10);
                            r.setDaño(100);   flag=false;
                            Thread.sleep(10);
                            playScene.getRocas().remove(r);
                            Thread.sleep(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        break;
                    }
                }
                if(!flag){
                    flag=true;
                    break;
                }
                if(r.getRoca()==null){Gravedad.sleeping(25);System.out.println("removido nullo");  break;}

                if (Gravedad.overlapingImageView(r.getRoca(), Player.getPlayer()) || r.getRoca().getLayoutY()> Player.getPlayer().getLayoutY()+600) {

                    try {    Thread.sleep(10);  } catch (InterruptedException e) {  e.printStackTrace();   }

                    if(r.getRoca().getLayoutY()> Player.getPlayer().getLayoutY()+600){  r.setDaño(100);   break;    }
                    //flag=true;




                    Player.setDaño(r.getDaño());
                    playScene.getRocas().remove(r);
                    Gravedad.sleeping(15);
                    r.explosion();
                    System.out.println(Player.getVida());
                    Player.enemigos++;
                    break;
                }

            }

        }Gravedad.sleeping(25);

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


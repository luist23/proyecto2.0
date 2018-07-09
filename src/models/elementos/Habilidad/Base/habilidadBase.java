package models.elementos.Habilidad.Base;


import javafx.scene.image.ImageView;
import models.controladores.GameValues;
import models.controladores.Gravedad;
import models.elementos.explosivos.enemigos.Base.roca;
import models.escenarios.pantallaJuego.playScene;
import models.players.Player;

import java.util.ArrayList;

/**
 * Created by LuisT23 on 7/7/2018.
 */
public class habilidadBase implements Habilidades {
    protected ImageView habilidad;
    @Override
    public void ejecutar() {
        Gravedad.stop=false;

        Thread habi= new Thread(()->{
            //int direcccion=GameValues.direccion;
            //System.out.println("habimladj");
            ArrayList<roca> rocas=new ArrayList<>();
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (roca r: playScene.getRocas()){
                if(habilidad.getBoundsInParent().intersects(r.getRoca().getBoundsInParent())){
                rocas.add(r);}
            }
            for (roca r:rocas){
                playScene.getRocas().remove(r);
                r.setDaño(100);
                r.getRoca().setLayoutX(-300);
            }
            if(habilidad.getBoundsInParent().intersects(Player.enemigo.getJefe().getBoundsInParent())){
                Player.enemigo.setDaño(100);
            }

            rocas.clear();
            try {
                Thread.sleep(100);
                habilidad.setLayoutX(GameValues.dimension[0]+100);
                habilidad.setImage(null);
                Gravedad.stop=true;
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }



        }
        );
        habi.start();

    }
}

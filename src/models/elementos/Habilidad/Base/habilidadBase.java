package models.elementos.Habilidad.Base;


import javafx.scene.image.ImageView;
import models.controladores.Gravedad;
import models.elementos.explosivos.enemigos.Base.roca;
import models.escenarios.pantallaJuego.playScene;

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
            System.out.println("habimladj");
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

            rocas.clear();
            Gravedad.stop=true;


        }
        );
        habi.start();

    }
}

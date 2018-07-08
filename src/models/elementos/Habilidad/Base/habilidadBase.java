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
            ArrayList<roca> rocas=new ArrayList<>();
            for (roca r: playScene.getRocas()){
                if(habilidad.getBoundsInParent().intersects(r.getRoca().getBoundsInParent())){
                rocas.add(r);}
            }
            for (roca r:rocas){
                playScene.getRocas().remove(r);
                r.setDaño(100);
            }

            rocas.clear();


        }
        );

    }
}

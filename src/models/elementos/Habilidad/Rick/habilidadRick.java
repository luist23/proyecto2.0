package models.elementos.Habilidad.Rick;

import javafx.scene.image.ImageView;
import models.elementos.Habilidad.Base.habilidadBase;

/**
 * Created by LuisT23 on 7/7/2018.
 */
public class habilidadRick extends habilidadBase{

    public habilidadRick(){
        habilidad=new ImageView(this.getClass().getResource("lazerRick.gif").toExternalForm());
    }
}

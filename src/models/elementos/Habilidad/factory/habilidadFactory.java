package models.elementos.Habilidad.factory;

import models.elementos.Habilidad.Base.Habilidades;
import models.elementos.Habilidad.Rick.habilidadRick;

/**
 * Created by LuisT23 on 7/7/2018.
 */
public class habilidadFactory {
    private static habilidadFactory ourInstance = new habilidadFactory();

    public static habilidadFactory getInstance() {
        return ourInstance;
    }

    private habilidadFactory() {    }

    public static Habilidades getHabilidad(habilidadesType type){
        switch (type){
            case RICK:
                return new habilidadRick();
        }


        return null;

    }

}

package models.elementos.Habilidad.factory;

import models.elementos.Habilidad.Base.Habilidades;
import models.elementos.Habilidad.Peach.habilidadPeach;
import models.elementos.Habilidad.Rick.habilidadRick;
import models.players.Player;

/**
 * Created by LuisT23 on 7/7/2018.
 */
public class habilidadFactory {
    private static habilidadFactory ourInstance = new habilidadFactory();

    public static habilidadFactory getInstance() {
        return ourInstance;
    }

    private habilidadFactory() {    }

    public static Habilidades getHabilidad(){
        switch (Player.personaje){
            case RICK:
                return new habilidadRick();
            case PEACH:
                return new habilidadPeach();
        }


        return null;

    }

}

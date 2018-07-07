package models.elementos.explosivos.granadas.factory;

import models.elementos.explosivos.granadas.holyGranade.holyGranade;
import models.elementos.explosivos.granadas.base.granada;
import models.elementos.explosivos.granadas.blackHole.blackHole;
import models.elementos.explosivos.granadas.blackHole.blackHoleDatos;
import models.elementos.explosivos.granadas.holyGranade.holyGranadeDatos;
import models.elementos.explosivos.granadas.veneno.veneno;
import models.elementos.explosivos.granadas.veneno.venenoDatos;

/**
 * Created by LuisT23 on 5/7/2018.
 */
public class granadaFactory {
    private static granadaFactory ourInstance = new granadaFactory();
    public static granadaFactory getInstance() {
        return ourInstance;
    }
    private granadaFactory() {}
    public static granada getGranada(granadaType type){
        switch (type){
            case VENENO:
                return new veneno(new venenoDatos());
            case HOLYGRANADE:
                return new holyGranade(new holyGranadeDatos());
                case BLACKHOLE:
                    return new blackHole(new blackHoleDatos());
                    
        }
        return null;
    }
}

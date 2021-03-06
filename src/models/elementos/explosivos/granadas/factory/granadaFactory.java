package models.elementos.explosivos.granadas.factory;

import javafx.scene.image.Image;
import models.controladores.GameValues;
import models.elementos.explosivos.granadas.congelacion.Congelacion;
import models.elementos.explosivos.granadas.congelacion.congelacionDatos;
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
            case CONGELACION:
                return new Congelacion(new congelacionDatos());
                    
        }
        return null;
    }
    public static Image getGranadaImagen(granadaType type){
        switch (type){
            case VENENO:
                return new Image(new venenoDatos().getClass().getResource("veneno.gif").toExternalForm());

            case HOLYGRANADE:
                return new Image(new holyGranadeDatos().getClass().getResource("granadaDivina.gif").toExternalForm());

            case BLACKHOLE:
                return new Image(new blackHoleDatos().getClass().getResource("blackHoleLanzar.gif").toExternalForm());
            case CONGELACION:
                return new Image(new congelacionDatos().getClass().getResource("hielo.gif").toExternalForm());


        }
        return null;
    }
}

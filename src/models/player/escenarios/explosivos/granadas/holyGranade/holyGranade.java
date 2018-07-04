package models.player.escenarios.explosivos.granadas.holyGranade;

import models.player.escenarios.explosivos.granadas.base.granada1;

/**
 * Created by LuisT23 on 4/7/2018.
 */
public class holyGranade  extends granada1<granadaUno> {

    public holyGranade(granadaUno granda){
        granadaBase=granda;
        granadaEfecto=granadaBase.getVisual();
        dimensione=granadaBase.getDimension();
        inicializar();
    }
    @Override
    protected void inicio() {


    }
}

package models.players.PlayerRick;

import models.players.Base.Players;

/**
 * Created by LuisT23 on 6/7/2018.
 */
public class Rick implements Players {
    private int[] sizePlayer= {40,40};
    private int distanciaPaso=5;
    private int pasosTotales=4;
    private int tiempoPaso=300;
    private boolean action=true;

    private String[] derecha={"Rick_derecha.png"};
    private String[] pasoDerecha={"Rick_corriendo_derecha.png","Rick_corriendo_3_derecha.png",
            "Rick_corriendo_2_derecha.png","Rick_corriendo_1_derecha.png"};
    private String[] saltoDerecha={"Rick_salto_1_derecha.png"};


    private String[] izquierda={"Rick.png"};
    private String[] pasoIzquierda={"Rick_corriendo.png","Rick_corriendo_3.png",
            "Rick_corriendo_2.png","Rick_corriendo_1.png"};
    private String[] saltoIzquierda={"Rick_salto_1.png"};

    public Rick(){}

    @Override
    public int[] getSizePlayer() {
        return sizePlayer;
    }

    @Override
    public int getDistanciaPaso() {
        return distanciaPaso;
    }

    @Override
    public int getPasosTotales() {
        return pasosTotales;
    }

    @Override
    public int getTiempoPaso() {
        return tiempoPaso;
    }

    @Override
    public boolean isAction() {
        return action;
    }

    @Override
    public String[] getDerecha() {
        return derecha;
    }

    @Override
    public String[] getPasoDerecha() {
        return pasoDerecha;
    }

    @Override
    public String[] getSaltoDerecha() {
        return saltoDerecha;
    }

    @Override
    public String[] getIzquierda() {
        return izquierda;
    }

    @Override
    public String[] getPasoIzquierda() {
        return pasoIzquierda;
    }

    @Override
    public String[] getSaltoIzquierda() {
        return saltoIzquierda;
    }
}

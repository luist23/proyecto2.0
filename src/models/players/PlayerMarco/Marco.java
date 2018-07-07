package models.players.PlayerMarco;

import models.players.Players;

/**
 * Created by LuisT23 on 7/7/2018.
 */
public class Marco implements Players {
    private int[] sizePlayer= {40,40};
    private int distanciaPaso=5;
    private int pasosTotales=4;
    private int tiempoPaso=300;
    private boolean action=true;

    private String[] derecha={"marco.gif"};
    private String[] pasoDerecha={"marco.gif","marco.gif",
            "marco.gif","marco.gif"};
    private String[] saltoDerecha={"marco.gif"};


    private String[] izquierda={"marcoI.gif"};
    private String[] pasoIzquierda={"marcoI.gif","marcoI.gif",
            "marcoI.gif","marcoI.gif"};
    private String[] saltoIzquierda={"marcoI.gif"};

    public Marco(){}

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
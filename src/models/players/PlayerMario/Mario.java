package models.players.PlayerMario;

import models.players.Base.Players;

/**
 * Created by LuisT23 on 7/7/2018.
 */
public class Mario implements Players {
    private int[] sizePlayer= {40,40};
    private int distanciaPaso=5;
    private int pasosTotales=4;
    private int tiempoPaso=300;
    private boolean action=true;

    private String[] derecha={"marioDerecha.gif"};
    private String[] pasoDerecha={"marioDerecha.gif","marioDerecha.gif",
            "marioDerecha.gif","marioDerecha.gif"};
    private String[] saltoDerecha={"salto_1.gif"};


    private String[] izquierda={"marioIzquierda.gif"};
    private String[] pasoIzquierda={"marioIzquierda.gif","marioIzquierda.gif",
            "marioIzquierda.gif","marioIzquierda.gif"};
    private String[] saltoIzquierda={"salto_2.gif"};

    public Mario(){}

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
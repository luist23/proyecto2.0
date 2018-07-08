package models.players.PlayerGoku;

import models.players.Base.Players;

/**
 * Created by LuisT23 on 7/7/2018.
 */
public class Goku implements Players {
    private int[] sizePlayer= {40,40};
    private int distanciaPaso=5;
    private int pasosTotales=4;
    private int tiempoPaso=300;
    private boolean action=true;

    private String[] derecha={"gokuParado.png"};
    private String[] pasoDerecha={"gokuCaminando.gif","gokuCaminando.gif",
            "gokuCaminando.gif","gokuCaminando.gif"};
    private String[] saltoDerecha={"gokuCaminando.gif"};


    private String[] izquierda={"gokuParado.png"};
    private String[] pasoIzquierda={"gokuCaminandoI.gif","gokuCaminandoI.gif",
            "gokuCaminandoI.gif","gokuCaminandoI.gif"};
    private String[] saltoIzquierda={"gokuCaminandoI.gif"};

    public Goku(){}

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
package models.players.Base;

public interface Players{
    int[] getSizePlayer();
    int getDistanciaPaso();
    int getPasosTotales();
    int getTiempoPaso();
    boolean isAction();
    String[] getDerecha();
    String[] getPasoDerecha();
    String[] getSaltoDerecha();
    String[] getIzquierda();
    String[] getPasoIzquierda();
    String[] getSaltoIzquierda();
}

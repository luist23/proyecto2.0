package models.player;

import models.player.peldannos.Peldanno;

import java.util.ArrayList;

public class GameValues {

    public static int[] dimension={1280,720};
    public static boolean gravedad=true;
    public static boolean permitirSalto =true;
    public static int direccion=1;


    private static GameValues ourInstance = new GameValues();

    public static GameValues getInstance() {
        return ourInstance;
    }



    private GameValues() {
    }
}

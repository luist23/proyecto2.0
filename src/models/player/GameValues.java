package models.player;

public class GameValues {

    public static int[] dimension={1048,720};
    public static boolean gravedad=true;
    private static GameValues ourInstance = new GameValues();

    public static GameValues getInstance() {
        return ourInstance;
    }

    private GameValues() {
    }
}

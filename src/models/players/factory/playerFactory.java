package models.players.factory;

import models.players.Player;
import models.players.PlayerGoku.Goku;
import models.players.PlayerMarco.Marco;
import models.players.PlayerMario.Mario;
import models.players.PlayerPeach.Peach;
import models.players.PlayerRick.Rick;
import models.players.Base.Players;

/**
 * Created by LuisT23 on 7/7/2018.
 */
public class playerFactory {
    private static playerFactory ourInstance = new playerFactory();

    public static playerFactory getInstance() {
        return ourInstance;
    }

    private playerFactory() {}

    public static void getPlayer(){
        System.out.println(Player.personaje);
        Players player=new Goku();
        switch (Player.personaje){
            case GOKU:
                player=new Goku();
                break;
            case RICK:
                player=new Rick();
                break;
            case MARCO:
                player=new Marco();
                break;
            case MARIO:
                player=new Mario();
                break;
            case PEACH:
                player=new Peach();
                break;
        }
        Player.playerBase=player;
        //System.out.println(player);

    }





}

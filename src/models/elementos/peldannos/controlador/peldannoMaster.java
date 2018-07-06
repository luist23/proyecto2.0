package models.elementos.peldannos.controlador;

import models.controladores.GameValues;
import models.elementos.peldannos.Peldanno;
import models.escenarios.playScene;

import java.util.ArrayList;

/**
 * Created by LuisT23 on 6/7/2018.
 */
public class peldannoMaster {



    private peldannoMaster() {}
    private peldannoMaster getInstance(){return this;}
    private static ArrayList<Peldanno> peldannos= playScene.getPeldannos();
    private static int[] posicionX={0,GameValues.dimension[0]/3,(2*GameValues.dimension[0])/3};

    public static int aleatorio(){
        return posicionX[(int)(Math.random()*3)];
    }

    public static void iniciar(){
        int[] peldan={1,2,1,2,2,1,1,1,2,2,1};

        peldannos.add(new Peldanno(0, GameValues.dimension[1]-15));
        peldannos.add(new Peldanno(posicionX[1], GameValues.dimension[1]-15));
        peldannos.add(new Peldanno(posicionX[2], GameValues.dimension[1]-15));


        //int elseY=GameValues.dimension[1];
        for (int i=GameValues.dimension[1];i>0;i-=120){
            for(int k=0;k<peldan[(int)(Math.random()*11)];k++){
                peldannos.add(new Peldanno(aleatorio(),i));
            }

        }


        /*peldannos.add(new Peldanno(0,300));
        peldannos.add(new Peldanno(600,400));
        peldannos.add(new Peldanno(230,500));
        //peldannos.add(new Peldanno(190,900));
        //peldannos.add(new Peldanno(700,600));
        peldannos.add(new Peldanno(80,600));
        peldannos.add(new Peldanno(290,500));
        peldannos.add(new Peldanno(700,250));
        peldannos.add(new Peldanno(600,200));*/


    }

}

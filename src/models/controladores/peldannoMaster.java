package models.controladores;

import models.elementos.explosivos.enemigos.controlador.hiloRocas;
import models.elementos.jefes.browserBlack.browserBlack;
import models.elementos.peldannos.Peldanno;
import models.escenarios.pantallaJuego.playScene;
import models.players.Player;

import java.util.ArrayList;

/**
 * Created by LuisT23 on 6/7/2018.
 */
public class peldannoMaster {



    private peldannoMaster() {}
    private peldannoMaster getInstance(){return this;}
    public static ArrayList<Peldanno> peldannos= playScene.getPeldannos();
    private static int[] posicionX={0,GameValues.dimension[0]/3,(2*GameValues.dimension[0])/3};
    public static int aleatorio(){
        return posicionX[(int)(Math.random()*3)];
    }

    public static void iniciar(){
        int[] peldan={1,2,1,2,2,1,1,1,2,2,1};
        int i;

        peldannos.add(new Peldanno(0, GameValues.dimension[1]-15));
        peldannos.add(new Peldanno(posicionX[1], GameValues.dimension[1]-15));
        peldannos.add(new Peldanno(posicionX[2], GameValues.dimension[1]-15));
        hiloRocas.peldanos.addAll(peldannos);


        //int elseY=GameValues.dimension[1];
        for (i=GameValues.dimension[1]-130;i>GameValues.alturaNivel;i-=130){
            int total=peldan[(int)(Math.random()*11)];
            for(int k=0;k<total;k++){
                int suerte=aleatorio();
                peldannos.add(new Peldanno(suerte,i));
                if(total==1 && suerte==0 || total==1 && suerte==posicionX[2]){
                    //System.out.println("rwllwnando");
                    peldannos.add(new Peldanno(posicionX[1],i));
                }

            }

        }

        peldannos.add(new Peldanno(posicionX[1], i));
        Player.enemigo=new browserBlack( posicionX[1]+200,i-100);


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

package models.elementos.explosivos.enemigos.jefes;

import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import models.controladores.GameValues;
import models.controladores.Gravedad;
import models.players.PlayerRick.Player;


/**
 * Created by LuisT23 on 7/7/2018.
 */
public abstract class jefeBase implements Jefe {
    protected ImageView jefe;
    protected ImageView habilidad;
    protected int vida;
    protected int daño;
    public static  TextField textVida =new TextField();

    @Override
    public ImageView getJefe() {
        return jefe;
    }

    @Override
    public int getVida() {
        return 0;
    }

    @Override
    public int getDaño() {
        return 0;
    }

    public void iniciar(){
        textVida.setText("VIDA JEFE:  "+String.valueOf(vida));
        Player.getRoot().getChildren().add(jefe);
        Player.box.getChildren().addAll(jefeBase.textVida);
        Player.getRoot().getChildren().addAll(habilidad);

        Thread jefet = new Thread(()->{
            int habilidadAc=1;
            while (vida>0 && Gravedad.exit){
                //System.out.println("sigo vivojefe");
                if(jefe.getBoundsInParent().intersects(Player.getPlayer().getBoundsInParent())){
                    Player.setDaño(daño);
                    //textVida.setText("VIDA JEFE:  "+String.valueOf(vida));
                    Player.getPlayer().setLayoutX(Player.getPlayer().getLayoutX()+300);
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                habilidadAc++;
                if(habilidadAc>7){
                    try {
                    habilidad.setLayoutX(jefe.getLayoutX()-250);
                        Thread.sleep(150);
                    if(habilidad.getBoundsInParent().intersects(Player.getPlayer().getBoundsInParent())){

                            Player.setDaño(daño+15);
                            Thread.sleep(300);
                            Player.getPlayer().setLayoutX(jefe.getLayoutX()-300);
                        Thread.sleep(150);
                            habilidad.setLayoutX(GameValues.dimension[0]+25);
                            Thread.sleep(150);


                    }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    habilidadAc=0;
                }


            }
        });
        jefet.start();
    }

        @Override
    public void  setDaño(int daño) {
        vida-=daño;
        textVida.setText("VIDA JEFE:  "+String.valueOf(vida));
    }
}

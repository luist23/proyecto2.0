package input;

import javafx.animation.AnimationTimer;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.event.Event;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import models.player.PlayerRick.Gravedad;


import java.awt.event.KeyListener;

public class Keyboard {

	private BooleanProperty upPressed = new SimpleBooleanProperty();
	private BooleanProperty wPressed = new SimpleBooleanProperty();
	private BooleanProperty downPressed = new SimpleBooleanProperty();
	private BooleanProperty sPressed = new SimpleBooleanProperty();
	private BooleanProperty rightPressed = new SimpleBooleanProperty();
	private BooleanProperty dPressed = new SimpleBooleanProperty();
	private BooleanProperty leftPressed = new SimpleBooleanProperty();
	private BooleanProperty aPressed = new SimpleBooleanProperty();
	private BooleanProperty spacePressed = new SimpleBooleanProperty();
	private BooleanProperty xPressed = new SimpleBooleanProperty();
	private BooleanProperty zPressed = new SimpleBooleanProperty();
	private boolean limitarZ,limitarX,limitarSpace;
	private boolean pussh=true,presing=true;

	private BooleanBinding anyPressed = upPressed.or(wPressed).or(downPressed).or(sPressed).or(rightPressed).or(dPressed).or(leftPressed).or(aPressed).or(spacePressed).or(zPressed).or(xPressed);



	public Keyboard(AnimationTimer timer){

	anyPressed.addListener((obs, wasPressed, isNowPressed) -> {
		if (isNowPressed) {
			timer.start();
		} else {
			timer.stop();
		}
	});

		/*System.out.println("por aqui imbe...");
		Thread limitador=new Thread(()->{
			int i=1,j=1,k=1;
			boolean in=true,jn=true, kn=true;
			System.out.println("antes de iniciar");
			while(true){
				//System.out.println("jodiendo la vida");
				System.out.println(presing);
				while (!presing){
					//pussh=false;
					//presing=false;
					Gravedad.sleeping(50);
					System.out.println("estoy aqui");
					presing=true;
				}
				Gravedad.sleeping(1000);

			}
		});
		//limitador.setDaemon(true);
		//limitador.start();*/

}

	public void keyPressed(KeyEvent event){
		if (event.getCode() == KeyCode.W) {
			wPressed.set(true);
		}
		if (event.getCode() == KeyCode.UP) {
			upPressed.set(true);
		}
		if (event.getCode() == KeyCode.DOWN) {
			downPressed.set(true);
		}
		if (event.getCode() == KeyCode.S) {
			sPressed.set(true);
		}
		if (event.getCode() == KeyCode.RIGHT) {
			rightPressed.set(true);
		}
		if (event.getCode() == KeyCode.D) {
			dPressed.set(true);
		}
		if (event.getCode() == KeyCode.LEFT) {
			leftPressed.set(true);
		}
		if (event.getCode() == KeyCode.A) {
			aPressed.set(true);
		}
		if (event.getCode() == KeyCode.SPACE) {
			Gravedad.sleeping(15);
			//spacePressed.set(true);
			//presing=false;
		}
		if (event.getCode() == KeyCode.Z ) {

			zPressed.set(true);
			//presing=false;
		}
		if (event.getCode() == KeyCode.X ) {
			//presing=false;
			//Gravedad.sleeping(15);
			xPressed.set(true);

		}
		//pussh=true;

	}

	public void keyRealssed(KeyEvent event){
		if (event.getCode() == KeyCode.W) {
			wPressed.set(false);
		}
		if (event.getCode() == KeyCode.UP) {
			upPressed.set(false);
		}

		if (event.getCode() == KeyCode.DOWN) {
			downPressed.set(false);
		}
		if (event.getCode() == KeyCode.S) {
			sPressed.set(false);
		}
		if (event.getCode() == KeyCode.RIGHT) {
			rightPressed.set(false);
		}
		if (event.getCode() == KeyCode.D) {
			dPressed.set(false);
		}
		if (event.getCode() == KeyCode.LEFT) {
			leftPressed.set(false);
		}
		if (event.getCode() == KeyCode.A) {
			aPressed.set(false);
		}
		if (event.getCode() == KeyCode.SPACE) {
			spacePressed.set(false);
		}
		if (event.getCode() == KeyCode.Z) {
			zPressed.set(false);
		}
		if (event.getCode() == KeyCode.X) {
			xPressed.set(false);
		}
		//pussh=false;
		//presing=false;
	}


	public boolean isUpPressed() {
		return upPressed.get();
	}

	public boolean iswPressed() {
		return wPressed.get();
	}


	public boolean isDownPressed() {
		return downPressed.get();
	}


	public boolean issPressed() {
		return sPressed.get();
	}


	public boolean isRightPressed() {
		return rightPressed.get();
	}


	public boolean isdPressed() {
		return dPressed.get();
	}


	public boolean isLeftPressed() {
		return leftPressed.get();
	}

	public boolean isaPressed() {
		return aPressed.get();
	}

	public boolean isSpacePressed() {
		return spacePressed.get();
	}

	public Boolean getAnyPressed() {
		return anyPressed.get();
	}

	public boolean isxPressed() {
		return xPressed.get();
	}

	public boolean iszPressed() {
		return zPressed.get();
	}

}

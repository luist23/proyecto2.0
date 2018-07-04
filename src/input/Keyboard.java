package input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard implements KeyListener {
	
	private boolean[] keys = new boolean[120]; //120 is enough to this game
	public boolean up, down, left, right, space,bomb,rock,jump,doJump;
	
	public void update() {
		up = keys[KeyEvent.VK_UP] || keys[KeyEvent.VK_W];
		down = keys[KeyEvent.VK_DOWN] || keys[KeyEvent.VK_S];
		left = keys[KeyEvent.VK_LEFT] || keys[KeyEvent.VK_A];
		right = keys[KeyEvent.VK_RIGHT] || keys[KeyEvent.VK_D];
		space = keys[KeyEvent.VK_SPACE] || keys[KeyEvent.VK_X];
		bomb = keys[KeyEvent.VK_Z] /*|| keys[KeyEvent.VK_X]*/;
		rock = keys[KeyEvent.VK_X] /*|| keys[KeyEvent.VK_X]*/;
		jump = keys[KeyEvent.VK_M] ;
		doJump = keys[KeyEvent.VK_N];

	}

	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
		
	}

}
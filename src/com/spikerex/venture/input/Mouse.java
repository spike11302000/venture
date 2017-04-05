package com.spikerex.venture.input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Mouse implements MouseListener, MouseMotionListener {
	private static int mouseX = -1;
	private static int mouseY = -1;
	private static int mouseB = -1;

	public static int getX() {
		return mouseX;
	}

	public static int getY() {
		return mouseY;
	}
	public static int getGX(){
		return mouseX/3;
	}
	public static int getGY(){
		return mouseY/3;
	}
	public static int getButton() {
		return mouseB;
	}

	public void mouseDragged(MouseEvent arg0) {

	}

	public void mouseMoved(MouseEvent e) {
		mouseX = e.getX();
		mouseY = e.getY();
	}

	public void mouseClicked(MouseEvent arg0) {

	}

	public void mouseEntered(MouseEvent arg0) {

	}

	public void mouseExited(MouseEvent arg0) {

	}

	public void mousePressed(MouseEvent e) {
		mouseB = e.getButton();
		
	}

	public void mouseReleased(MouseEvent arg0) {
		mouseB = -1;
	}

}

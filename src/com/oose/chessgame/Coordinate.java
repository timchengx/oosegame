package com.oose.chessgame;

public class Coordinate {
	private static int resultX = -1;
	private static int resultY = -1;
	public static void convertToBoard(int x, int y) {
		if (x < 235) {
			if (x < 22) { //error
				x = -1;
			} else if (x > 231){
				x = 4;
			} else {
				x = (x - 22) / 42;
			}
		} else { //x: 235~468
			if (x > 446) {
				x = -1;
			} else if (x < 244){
				x = 9;
			} else {
				x = (x - 25) / 42;
			}
		}
		
		if (y < 22 || y > 399) { //error
			y = -1;
		} else {
			y = (y - 22) / 42;
		}

	}
	public static int getX() {
		return resultX;
	}
	public static int getY() {
		return resultY;
	}
	public static void convertToScreen(int x, int y) {
		switch(x) {
		default:
			x = -1;
		}
		switch(y) {
		default:
			y = -1;
		}
	}
}

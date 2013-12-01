package com.oose.chessgame;

public class ChineseChessCoordinate extends Coordinate{
	private int resultX = -1;
	private int resultY = -1;
	public void convertToBoard(int x, int y) {
		if (x < 235) {
			if (x < 22) { //error
				resultX = -1;
			} else if (x > 231){
				resultX = 4;
			} else {
				resultX = (x - 22) / 42;
			}
		} else { //x: 235~468
			if (x > 446) {
				resultX = -1;
			} else if (x < 244){
				resultX = 9;
			} else {
				resultX = (x - 25) / 42;
			}
		}
		
		if (y < 22 || y > 399) { //error
			resultY = -1;
		} else {
			resultY = (y - 22) / 42;
		}

	}
	public int getX() {
		return resultX;
	}
	public int getY() {
		return resultY;
	}
	public void convertToScreen(int x, int y) {
		switch(x) {
		case 0:
			resultX = 27;
			break;
		case 1:
			resultX = 68;
			break;
		case 2:
			resultX = 110;
			break;
		case 3:
			resultX = 152;
			break;
		case 4:
			resultX = 193;
			break;
		case 5:
			resultX = 240;
			break;
		case 6:
			resultX = 281;
			break;
		case 7:
			resultX = 323;
			break;
		case 8:
			resultX = 365;
			break;
		case 9:
			resultX = 407;
			break;
		default:
			x = -1;
			break;
		}
		switch(y) {
		case 0:
			resultY = 27;
			break;
		case 1:
			resultY = 68;
			break;
		case 2:
			resultY = 110;
			break;
		case 3:
			resultY = 151;
			break;
		case 4:
			resultY = 193;
			break;
		case 5:
			resultY = 234;
			break;
		case 6:
			resultY = 276;
			break;
		case 7:
			resultY = 318;
			break;
		case 8:
			resultY = 360;
			break;
		default:
			y = -1;
		}
	}
}

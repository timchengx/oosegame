package com.oose.chessgame;

import android.graphics.Canvas;

public abstract class ChessGame {
	protected ChessBoard board;
	protected GameState status;
	protected Coordinate coord;
	abstract public void save();
	abstract public void refreshBoard(Canvas c);
	abstract public void select(int x, int y);
	abstract protected void move(int x, int y);
	abstract protected void eat(int x, int y);
	public ChessGame(){
		
	}
	public ChessGame(SaveFile s){
		
	}
}

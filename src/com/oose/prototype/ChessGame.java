package com.oose.prototype;

import java.io.Serializable;

import android.graphics.Canvas;

public abstract class ChessGame implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3804242090043209356L;
	protected ChessBoard board;
	protected GameState status;
	protected Coordinate coord;
	
	abstract public void save();
	abstract public void refreshBoard(Canvas c);
	abstract public void select(int x, int y);
	abstract protected boolean move(int x, int y);
	abstract protected boolean eat(int x, int y);
	abstract protected boolean fallback();
	public GameState getStatus() {
		return status;
	}
	public ChessGame(){
		
	}
	public ChessGame(SaveFile s){
		
	}
}

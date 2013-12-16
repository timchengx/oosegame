package com.oose.prototype;

import android.graphics.Canvas;

public abstract class ChessGame {
	protected ChessBoard board;
	protected GameState status;
	protected Coordinate coord;
	
	public static final int NONEED_REDRAW = 1;
	public static final int NEED_REDRAW = 0;
//	public static final int OPERATION_FAIL = -1;
//	public static final int OPERATION_OK = 0;
//	public static final int OPERATION_UNKNOWN = -1;
	abstract public void save();
	abstract public void refreshBoard(Canvas c);
	abstract public boolean select(int x, int y);
	abstract protected boolean move(int x, int y);
	abstract protected boolean eat(int x, int y);
	public ChessGame(){
		
	}
	public ChessGame(SaveFile s){
		
	}
}

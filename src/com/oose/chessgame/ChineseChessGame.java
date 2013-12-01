package com.oose.chessgame;

import android.graphics.Canvas;
import android.util.Log;

public class ChineseChessGame extends ChessGame {
	//protected ChineseChessBoard board;
	private ChessMan selected;
	private boolean isSelected;
	public ChineseChessGame() {
		board = new ChineseChessBoard();
		status = new ChineseChessGameState();
		coord = new ChineseChessCoordinate();
		isSelected = false;
	}
	@Override
	public void save() {
	}

	@Override
	public void refreshBoard(Canvas c) {
		if(board.getBackground() != null)
			c.drawBitmap(board.getBackground(), 0, 0, null);
		for(ChessMan b : board) {
			if(b == null) continue;
			coord.convertToScreen(b.getX(), b.getY());
			//Log.d("kerker", coord.getX()+" "+coord.getY());
			c.drawBitmap(b.icon, coord.getX(), coord.getY(), null);
		}
	}

	@Override
	public void select(int x, int y) {
		coord.convertToBoard(x, y);
		Log.d("timcheng", coord.getX()+" "+ coord.getY());
		if(!isSelected) {
			if(board.hasChess(coord.getX(), coord.getY())) {
				this.selected = board.getChess(coord.getX(), coord.getY());
				isSelected = true;
				Log.d("timcheng", "selectok!");
			}
		}
		else {
			if(board.hasChess(coord.getX(), coord.getY())) {
				if(board.getChess(coord.getX(), coord.getY()) == selected) {
					Log.d("timcheng","same chess.");
					isSelected = false;
					selected = null;
				}
				else
					eat(coord.getX(), coord.getY());
			}
			else {
				move(coord.getX(), coord.getY());
			}
		}
	}

	@Override
	protected void move(int x, int y) {
		if(x < 10 && x > 0 && y < 9 && y > 0) {
			board.removeChess(selected.getX(),selected.getY());
			board.setBoard(x, y, selected);
			selected.setXY(x, y);
			Log.d("timcheng", "moveok!");
		}
		else
			Log.d("timcheng", "nomove!");
		isSelected = false;
		selected = null;
	}
	@Override
	protected void eat(int x, int y) {
		Log.d("timcheng", "eat.");
		//Log.d("timcheng", board.getChess(x, y).toString());
		board.removeChess(selected.getX(),selected.getY());
		board.setBoard(x, y, selected);
		selected.setXY(x, y);
		isSelected = false;
		selected = null;
	}

}

package com.oose.darkchess;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.util.Log;

import com.oose.chinesechess.ChineseChessBoard;
import com.oose.chinesechess.ChineseChessCoordinate;
import com.oose.chinesechess.ChineseChessGameState;
import com.oose.prototype.ChessGame;
import com.oose.prototype.ChessMan;

public class DarkChessGame extends ChessGame{

	private static final long serialVersionUID = 5954468991685346851L;

	private ChessMan selectedChess;
	private boolean isSelected;

	public DarkChessGame(String one, String two, Bitmap pOne, Bitmap pTwo,
			int fallback, int timeLimit) {
		board = new ChineseChessBoard();
		status = new ChineseChessGameState(one, two, pOne, pTwo, fallback,
				timeLimit);
		coord = new ChineseChessCoordinate();
		selectedChess = null;
		isSelected = false;
	}

	private void cleanSelected() {
		selectedChess = null;
		isSelected = false;
	}

	@Override
	public void refreshBoard(Canvas c) {
		if (board.getBackGround() != null)
			c.drawBitmap(board.getBackGround(), 0, 0, null);
		for (ChessMan b : board) {
			if (b == null)
				continue;
			coord.convertToScreen(b.getX(), b.getY());
			if (b == selectedChess)
				c.drawBitmap(b.getSelectedIcon(), coord.getX(), coord.getY(),
						null);
			else
				c.drawBitmap(b.getIcon(), coord.getX(), coord.getY(), null);
		}
	}

	@Override
	public void select(int x, int y) {
		coord.convertToBoard(x, y);

		Log.d("timcheng",
				new String("select enter Who's turn " + status.whosTurn()));
		Log.d("timcheng", coord.getX() + " " + coord.getY());

		if (!isSelected) {
			if (board.hasChess(coord.getX(), coord.getY())) {

				selectedChess = board.getChess(coord.getX(), coord.getY());

				if (selectedChess.getBelong() == status.whosTurn()) // Log.d("timcheng",
																	// "hasSelectChess!");
					isSelected = true;
				else
					selectedChess = null;
			}
		} else {
			boolean moveResult = false;
			try {
				board.copy();
			} catch (CloneNotSupportedException e) {
			}
			if (board.hasChess(coord.getX(), coord.getY())) {
				if (board.getChess(coord.getX(), coord.getY()) == selectedChess) // Log.d("timcheng","same chess.");
					cleanSelected();
				else
					moveResult = eat(coord.getX(), coord.getY());
			} else {
				moveResult = move(coord.getX(), coord.getY());
			}

			if (moveResult) {// Log.d("timcheng", "change to "
								// +status.whosTurn());
				status.changeTurn();
				board.savePreviousBoard();
			}
		}
	}

	@Override
	protected boolean eat(int x, int y) {
		boolean result = false;
		Log.d("timcheng", "eat.");
		if (selectedChess.getBelong() != board.getChess(x, y).getBelong()
				&& selectedChess.eat(x, y)) {
			result = true;
		} else {
			Log.d("timcheng", "want to eat your own buddy?");
			result = false;
		}
		cleanSelected();
		return result;
	}

	@Override
	protected boolean move(int x, int y) {
		boolean result = false;
		if (x < 9 && x >= 0 && y < 10 && y >= 0 && selectedChess.move(x, y)) {
			Log.d("timcheng", "moveok!");
			result = true;
		} else {
			Log.d("timcheng", "no move");
			result = false;
		}
		cleanSelected();
		return result;
	}

	@Override
	public boolean fallback() {
		if(canFallback()) {
			board.fallback();
			status.fallback();
			return true;
		}
		return false;
	}

	@Override
	public boolean canFallback() {
		return board.canFallback() && status.canFallback();
	}


}

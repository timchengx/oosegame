package com.oose.chessgame;

import android.graphics.Canvas;
import android.util.Log;

public class ChineseChessGame extends ChessGame {
	// protected ChineseChessBoard board;
	private ChessMan selectedChess;
	private boolean isSelected;
	private boolean firstOpen=true;
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
		if (board.getBackGround() != null)
			c.drawBitmap(board.getBackGround(), 0, 0, null);
		for (ChessMan b : board) {
			if (b == null)
				continue;
			coord.convertToScreen(b.getX(), b.getY());
			c.drawBitmap(b.icon, coord.getX(), coord.getY(), null);
		}
	}

	@Override
	public int select(int x, int y) {
		coord.convertToBoard(x, y);
		Log.d("timcheng",
				new String("select enter Who's turn " + status.whosTurn()));
		Log.d("timcheng", coord.getX() + " " + coord.getY());
		if (!isSelected) {
			if (board.hasChess(coord.getX(), coord.getY())) {
				this.selectedChess = board.getChess(coord.getX(), coord.getY());
				if (selectedChess.getBelong() == status.whosTurn()
						|| !(selectedChess.isVisible())) {
					Log.d("timcheng", "hasSelectChess!");
					isSelected = true;
				} else
					selectedChess = null;

			}
			return NONEED_REDRAW;
		} else {
			int resultCode = OPERATION_UNKNOWN;
			if (board.hasChess(coord.getX(), coord.getY())) {
				if (board.getChess(coord.getX(), coord.getY()) == selectedChess) {
					if (!selectedChess.isVisible()) {
						resultCode = open(coord.getX(), coord.getY());
						if(firstOpen&&board.getChess(coord.getX(), coord.getY()).belongTo==2){resultCode=OPERATION_FAIL;isSelected = false;selectedChess = null;return NEED_REDRAW;}
						firstOpen=false;
					} else {
						isSelected = false;
						selectedChess = null;
						Log.d("timcheng", "same chess.");
					}
				} else
					resultCode = eat(coord.getX(), coord.getY());
			} else {
				resultCode = move(coord.getX(), coord.getY());
			}

			if (resultCode == OPERATION_OK) {
				status.changeTurn();
				Log.d("timcheng", "change to " + status.whosTurn());
				return NEED_REDRAW;
			}
		}
		return NONEED_REDRAW;
	}

	@Override
	protected int eat(int x, int y) {
		int result = OPERATION_UNKNOWN;
		Log.d("timcheng", "eat.");
		if (selectedChess.belongTo != board.getChess(x, y).getBelong()
				&& selectedChess.eatValid(x, y)) {
			board.removeChess(selectedChess.getX(), selectedChess.getY());
			board.setBoard(x, y, selectedChess);
			selectedChess.setXY(x, y);
			result = OPERATION_OK;
		} else {
			Log.d("timcheng", "want to eat your own buddy?");
			result = OPERATION_FAIL;
		}
		isSelected = false;
		selectedChess = null;
		return result;
	}

	@Override
	protected int move(int x, int y) {
		int result = OPERATION_UNKNOWN;
		if (x < 4 && x >= 0 && y < 8 && y >= 0 && selectedChess.moveValid(x, y)) {
			board.removeChess(selectedChess.getX(), selectedChess.getY());
			board.setBoard(x, y, selectedChess);
			selectedChess.setXY(x, y);
			Log.d("timcheng", "moveok!");
			result = OPERATION_OK;
		} else {
			Log.d("timcheng", "no move");
			result = OPERATION_FAIL;
		}
		isSelected = false;
		selectedChess = null;
		return result;
	}

	protected int open(int x, int y) {
		int result = OPERATION_UNKNOWN;
		board.getChess(x, y).open();
		//board.removeChess(selectedChess.getX(), selectedChess.getY());
		//board.setBoard(x, y, selectedChess);
		selectedChess.setXY(x, y);
		Log.d("LC", "open a chess!");
		result = OPERATION_OK;

		isSelected = false;
		selectedChess = null;
		return result;
	}
}

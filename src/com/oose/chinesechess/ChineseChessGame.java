package com.oose.chinesechess;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.util.Log;

import com.oose.chessgame.chinesechessman.RedGeneral;
import com.oose.chessgame.chinesechessman.BlackGeneral;
import com.oose.prototype.ChessGame;
import com.oose.prototype.ChessMan;
import com.oose.prototype.GameState;

public class ChineseChessGame extends ChessGame {

	private static final long serialVersionUID = 5954468991685346851L;

	private ChessMan selectedChess;
	private boolean isSelected;

	public ChineseChessGame(String one, String two, Bitmap pOne, Bitmap pTwo,
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
	public int select(int x, int y) {
		int gameOver = GAMECONTINUE;
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
				gameOver = isEnd();
				status.changeTurn();
				board.savePreviousBoard();
			}
		}
		return gameOver;
	}
	
	@Override
	protected int isEnd() {
		int player = status.whosTurn();
		String RedGeneral = RedGeneral.class.getName();
		String BlackGeneral = BlackGeneral.class.getName();
		String rivalGeneral;
		boolean isLookingEachOther = false;
		boolean hasBeenEaten = true;
		
		if(player == GameState.PLAYERONE)
			rivalGeneral = BlackGeneral;
		else
			rivalGeneral = RedGeneral;
		
		for(ChessMan b : board) {
			if(b != null) {
				if (b.getClass().getName().equals(BlackGeneral)) {
					boolean hasChess = false;
					for (int Y = b.getY() + 1; Y < 10; Y++) {
						if (board.hasChess(b.getX(), Y)) {
							if(!hasChess) {
								hasChess = true;
								if (board.getChess(b.getX(), Y).getClass().getName().equals(RedGeneral)) {
									isLookingEachOther = true;
								}
							}
						}
					}
				}
			}
		}
		
		for(ChessMan b : board)
			if(b != null)
				if(b.getClass().getName().equals(rivalGeneral))
					hasBeenEaten = false;
		
		if(isLookingEachOther || hasBeenEaten) {
			if(isLookingEachOther) {
				if(player == GameState.PLAYERONE)
					return GameState.PLAYERTWO;
				else
					return player;
			}
			else
				return player;
		}
		return GAMECONTINUE;
		
//		for (ChessMan b : board) {
//			if (b != null) {
//				if (b.getClass().getName().equals(BlackGeneral)) {
//					for (int Y = b.getY() + 1; Y < 10; Y++) {
//						if (board.hasChess(b.getX(), Y)) {
//							if (board.getChess(b.getX(), Y).getClass().getName().equals(RedGeneral)) {
//								if (player == GameState.PLAYERONE)
//									return GameState.PLAYERTWO;
//								return GameState.PLAYERONE;
//							}
//							else
//								return GAMECONTINUE;
//						}
//					}
//					return GAMECONTINUE;
//				}
//			}
//		}
//		
//		for (ChessMan b : board) {
//			if (b != null) {
//				if (b.getClass().getName().equals(BlackGeneral))
//					if (player == GameState.PLAYERONE)
//						return GAMECONTINUE;
//				if (b.getClass().getName().equals(RedGeneral))
//					if (player == GameState.PLAYERTWO)
//						return GAMECONTINUE;
//			}
//		}
//		
//		return player;
	}
	
//	protected int isEnd() {
//		int player = status.whosTurn();
//		boolean isLookingEachOther = false;
//		boolean isAnotherDie = false;
//		String rivalGeneral;
//		String RedGeneral = RedGeneral.class.getName();
//		String BlackGeneral = BlackGeneral.class.getName();
//		
//		for (ChessMan b : board)
//			if (b != null)
//				if (b.getClass().getName().equals(BlackGeneral))
//					for (int Y = b.getY() + 1; Y < 10; Y++)
//						if (board.hasChess(b.getX(), Y))
//							if (board.getChess(b.getX(), Y).getClass().getName().equals(RedGeneral))
//								isLookingEachOther = true;
//		
//		
//		if(player == GameState.PLAYERONE)
//			rivalGeneral = BlackGeneral;
//		else
//			rivalGeneral = RedGeneral;
//		
//		for (ChessMan b : board)
//			if (b != null)
//				if (b.getClass().getName().equals(rivalGeneral))
//						isAnotherDie = true;
//		
//		if(isLookingEachOther || isAnotherDie) {
//			if(isLookingEachOther) {
//				if(player == GameState.PLAYERONE)
//					return GameState.PLAYERTWO;
//				else
//					return GameState.PLAYERONE;
//			}
//			else
//				return player;
//		}
//			
//		return GAMECONTINUE;
//	}

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

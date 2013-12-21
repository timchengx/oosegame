package com.oose.chessgame.darkchessman;
import android.graphics.Bitmap;





import com.oose.darkchess.DarkChessBoard;
import com.oose.darkchess.DarkChessMan;
import com.oose.factory.ChineseChessPictureList;
import com.oose.prototype.ChessMan;
public class BlackSoldier extends DarkChessMan{

	private static final long serialVersionUID = -7365495055614093258L;
	public BlackSoldier(int x, int y, DarkChessBoard board) {
		super(x, y, ChessMan.BLACK, board);
	}
	
	public BlackSoldier(BlackSoldier bs) {
		super(bs);
	}
	
	@Override
	public BlackSoldier clone() throws CloneNotSupportedException {
		return new BlackSoldier(this);
	}
	@Override
	public Bitmap getIcon() {
		return ChineseChessPictureList.getIcon(this.getClass().getName());
	}

	@Override
	public Bitmap getSelectedIcon() {
		return ChineseChessPictureList.getIcon(this.getClass().getName() + "SELECTED");
	}
	@Override
	public boolean move(int x, int y) { 
		inBoardMoveChess(x, y);
		return true;

	}
	@Override
	public boolean eat(int x, int y) {
		inBoardMoveChess(x, y);
		return true;
//		if(moveValid(x, y) == true){
//			return true;			
//		}else{
//			return false;
//		}
	}

}

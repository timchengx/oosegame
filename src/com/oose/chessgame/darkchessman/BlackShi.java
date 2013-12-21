package com.oose.chessgame.darkchessman;
import android.graphics.Bitmap;





import com.oose.darkchess.DarkChessBoard;
import com.oose.darkchess.DarkChessMan;
import com.oose.factory.ChineseChessPictureList;
import com.oose.prototype.ChessMan;
public class BlackShi extends DarkChessMan{

	private static final long serialVersionUID = 5287378310377711625L;
	public BlackShi(int x, int y, DarkChessBoard board) {
		super(x, y, ChessMan.BLACK, board);
	}
	
	public BlackShi(BlackShi bs) {
		super(bs);
	}
	
	@Override
	public BlackShi clone() throws CloneNotSupportedException {
		return new BlackShi(this);
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
//		if(((0<=x && x<=2) || (7<=x && x<=9)) && (3<=y && y<=5))
//		{
//			if((Math.abs(x-currentX) == 1) && (Math.abs(y-currentY) == 1))
//			{
//				return true;
//			}
//		}
//		return false;
	}
	@Override
	public boolean eat(int x, int y) {
		return move(x,y);
	}

}

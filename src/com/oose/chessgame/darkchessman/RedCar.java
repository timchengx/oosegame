package com.oose.chessgame.darkchessman;
import android.graphics.Bitmap;






import com.oose.darkchess.DarkChessBoard;
import com.oose.darkchess.DarkChessMan;
import com.oose.factory.DarkChessPictureList;
import com.oose.prototype.ChessMan;
public class RedCar extends DarkChessMan{

	private static final long serialVersionUID = -6745629377144249069L;
	public RedCar(int x, int y, DarkChessBoard board) {
		super(x, y, ChessMan.RED, board, 4);
	}
	
	public RedCar(RedCar rc) {
		super(rc);
	}
	
	@Override
	public RedCar clone() throws CloneNotSupportedException {
		return new RedCar(this);
	}
	@Override
	public Bitmap getIcon() {
	
		if (this.visible)
			return DarkChessPictureList.getIcon(this.getClass().getName());
		
		else
			return DarkChessPictureList.getIcon("com.oose.chessgame.darkchessman.UnFlip");
		}
	@Override
	public Bitmap getSelectedIcon() {
		if (this.visible)
		return DarkChessPictureList.getIcon(this.getClass().getName() + "SELECTED");
		else
			return DarkChessPictureList.getIcon("com.oose.chessgame.darkchessman.UnFlip" + "SELECTED");
	}
	
		


}

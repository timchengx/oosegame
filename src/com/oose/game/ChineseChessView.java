package com.oose.game;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.oose.chessgame.ChessGame;
import com.oose.chessgame.ChineseChessGame;

public class ChineseChessView extends SurfaceView implements SurfaceHolder.Callback{//, Runnable {
	//Bitmap ChessBoard;
	//Bitmap cannon;
	SurfaceHolder holder;
	Resources r;
	//int xAxis[] = {50,91,133,175,216,263,304,346,388,430};
	//int yAxis[] = {133,174,216,257,299,341,383};
	//int x = 0;
	//int y = 0;
	ChessGame chineseChess;
	public ChineseChessView(Context context) {
		super(context);
		r = getResources();
		//ChessBoard = BitmapFactory.decodeResource(r, R.drawable.chinesechessboard);
		//cannon = BitmapFactory.decodeResource(r, R.drawable.red_cannon);
		chineseChess = new ChineseChessGame();
		holder = getHolder();
		holder.addCallback(this);
	}

	@Override
	public void surfaceCreated(SurfaceHolder sh) {
		Canvas c = holder.lockCanvas();
		//c.drawBitmap(ChessBoard, 0, 0, null);
		chineseChess.refreshBoard(c);
		holder.unlockCanvasAndPost(c);
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
	
		//Canvas c = holder.lockCanvas();
		//c.drawBitmap(ChessBoard, 0, 0, null);
		//c.drawBitmap(cannon, 33, 33, null);
			//Thread.sleep(300);
		//holder.unlockCanvasAndPost(c);
		return true;
	}

	@Override
	public void surfaceChanged(SurfaceHolder arg0, int arg1, int arg2, int arg3) {
	}
	@Override
	public void surfaceDestroyed(SurfaceHolder arg0) {
	}
/*
	@Override
	public void run() {
		//for time count down(thread)
	}
*/
}

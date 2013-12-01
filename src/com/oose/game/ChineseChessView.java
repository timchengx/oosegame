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
	SurfaceHolder holder;
	Resources r;
	ChessGame chineseChess;
	public ChineseChessView(Context context) {
		super(context);
		r = getResources();
		chineseChess = new ChineseChessGame();
		holder = getHolder();
		holder.addCallback(this);
	}

	@Override
	public void surfaceCreated(SurfaceHolder sh) {
		Canvas c = holder.lockCanvas();
		chineseChess.refreshBoard(c);
		holder.unlockCanvasAndPost(c);
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
	
		
		if(event.getAction() == MotionEvent.ACTION_DOWN)
			chineseChess.select((int)event.getX(), (int)event.getY());
		Canvas c = holder.lockCanvas();
		chineseChess.refreshBoard(c);
		holder.unlockCanvasAndPost(c);
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

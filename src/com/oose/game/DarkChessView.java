package com.oose.game;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.oose.darkchess.DarkChessGame;
import com.oose.prototype.ChessGame;
import com.oose.prototype.Observable;
import com.oose.prototype.Observer;

public class DarkChessView extends SurfaceView implements SurfaceHolder.Callback, Observable {// , Runnable {
	SurfaceHolder holder;
	DarkChessGame darkChess;
	Paint namePaint;
	Observer mainActivity;

	public DarkChessView(Context context, Intent intent, DarkChessGame ch, DarkChessMain mA) {
		super(context);

		namePaint = new Paint();
		namePaint.setColor(Color.WHITE);
		namePaint.setTextSize(18);

		darkChess = ch;
		mainActivity = mA;
		holder = getHolder();
		holder.addCallback(this);
	}

	public void refreshScreen() {
		Canvas c = holder.lockCanvas();
		darkChess.refreshBoard(c);
		c.drawText(darkChess.getStatus().getPlayerOneName(), 20, 47,
				namePaint);
		c.drawText(darkChess.getStatus().getPlayerTwoName(), 20, 547,
				namePaint);
		c.drawBitmap(darkChess.getStatus().getPlayerOnePic(), 20, 105, null);
		c.drawBitmap(darkChess.getStatus().getPlayerTwoPic(), 20, 605, null);
		holder.unlockCanvasAndPost(c);
	}

	@Override
	public void surfaceCreated(SurfaceHolder sh) {
		refreshScreen();
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		int gameResult = ChessGame.GAMECONTINUE;
		if (event.getAction() == MotionEvent.ACTION_DOWN) {
			gameResult = darkChess.select((int) event.getX(), (int) event.getY());
			refreshScreen();
		}
		if(gameResult != ChessGame.GAMECONTINUE)
			notifyObservers(Integer.valueOf(gameResult));
		return true;
	}

	@Override
	public void surfaceChanged(SurfaceHolder arg0, int arg1, int arg2, int arg3) {
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder arg0) {
	}
	/*
	 * @Override public void run() { //for time count down(thread) }
	 */

	@Override
	public void notifyObservers(Object carry) {
		mainActivity.update(this, carry);
	}
}
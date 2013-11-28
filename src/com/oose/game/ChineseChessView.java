package com.oose.game;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class ChineseChessView extends SurfaceView implements SurfaceHolder.Callback{//, Runnable {

	Bitmap ChessBoard;
	Bitmap pow;
	SurfaceHolder holder;
	Resources r;
	int xAxis[] = {50,91,133,175,216,263,304,346,388,430};
	int yAxis[] = {133,174,216,257,299,341,383};
	int x = 0;
	int y = 0;
	public ChineseChessView(Context context) {
		super(context);
		r = getResources();
		ChessBoard = BitmapFactory.decodeResource(r, R.drawable.chinesechessboard);
		pow =BitmapFactory.decodeResource(r, R.drawable.pow);
		holder = getHolder();
		holder.addCallback(this);
	}

	@Override
	public void surfaceCreated(SurfaceHolder sh) {
		Canvas c = holder.lockCanvas();
		c.drawBitmap(ChessBoard, 6, 6, null);
		holder.unlockCanvasAndPost(c);
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
	
		Canvas c = holder.lockCanvas();
		c.drawBitmap(ChessBoard, 6, 6, null);
		c.drawBitmap(pow, 33, 33, null);
			//Thread.sleep(300);
		holder.unlockCanvasAndPost(c);
		x++;
		if(x < 9) {
			y++;
			x = 0;
		}
		if(y < 6) {
			x = 0;
			y = 0;
		}
		
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

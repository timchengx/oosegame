package com.oose.game;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;

public class DrawChessTest extends View {
	//Bitmap test = ((BitmapDrawable) getResources().getDrawable(R.drawable.fulltable)).getBitmap();
	//Bitmap stst = ((BitmapDrawable) getResources().getDrawable(R.drawable.untitled)).getBitmap();

	public DrawChessTest(Context context) {
		super(context);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		//canvas.drawBitmap(test, 0, 0, null);
		//canvas.drawBitmap(stst, 30, 60, null);
	}

}

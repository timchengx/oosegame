package com.oose.game;

import android.app.Activity;
import android.os.Bundle;


public class ChineseChessMain extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ChineseChessView mainView = new ChineseChessView(this, getIntent());
		setContentView(mainView);
	}
}

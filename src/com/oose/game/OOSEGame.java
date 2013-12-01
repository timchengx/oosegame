package com.oose.game;

import android.app.Application;
import android.content.res.Resources;

public class OOSEGame extends Application {
	
	private static Resources res;
	@Override
	public void onCreate() {
		super.onCreate();
		res = this.getResources();
	}
	public static Resources getRes() {
		return res;
	}
}

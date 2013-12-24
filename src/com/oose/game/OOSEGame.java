package com.oose.game;

import android.app.Application;
import android.content.res.Resources;

/*
 * Android Resources getter class
 * Let res able to retrieve everywhere
 */
public class OOSEGame extends Application {

	private static Resources res;

	@Override
	public void onCreate() {
		super.onCreate();
		res = this.getResources();
	}

	/* res getter */
	public static Resources getRes() {
		return res;
	}
}

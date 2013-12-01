package com.oose.chessgame;

import java.util.Iterator;

import android.graphics.Bitmap;

public abstract class ChessBoard implements Iterable<ChessMan> {
	ChessMan nowBoard[][];
	ChessMan previousBoard[][];
	ChessMan previousPreviousBoard[][];
	Bitmap backGround;
	abstract class ChessIterator implements Iterator<ChessMan>{
	}
	abstract public Bitmap getBackground();
}

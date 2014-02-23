/*******************************************************************************
 * Copyright (c) 2013 AUTHORS.txt
 * All rights reserved. Distributed under the terms of the MIT License.
 ******************************************************************************/
package com.oose.chinesechess;

import android.graphics.Bitmap;

import com.oose.prototype.GameState;

public class ChineseChessGameState extends GameState {

  private static final long serialVersionUID = 4937630102339990622L;

  public ChineseChessGameState(String pOne, String pTwo, Bitmap pOnePic, Bitmap pTwoPic,
      int fallback, int timeLimit) {
    super(pOne, pTwo, pOnePic, pTwoPic, fallback, timeLimit);
  }

}

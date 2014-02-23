/*******************************************************************************
 * Copyright (c) 2013 AUTHORS.txt
 * All rights reserved. Distributed under the terms of the MIT License.
 ******************************************************************************/
package com.oose.prototype;

import java.io.Serializable;

import android.graphics.Bitmap;

/* MVC's Model */
abstract public class GameState implements Serializable, Fallback {
  private static final long serialVersionUID = -8642239316987428479L;
  public static final int PLAYERONE = 1;
  public static final int PLAYERTWO = 2;

  private int currentPlayer;
  private String playerOneName;
  private String playerTwoName;
  private SerializableBitmap playerOnePic;
  private SerializableBitmap playerTwoPic;
  private int playerOneFallbackCount;
  private int playerTwoFallbackCount;
  private int playerOneTime;
  private int playerTwoTime;

  public GameState(String pOne, String pTwo, Bitmap pOnePic, Bitmap pTwoPic, int fallback,
      int timeLimit) {

    this.currentPlayer = GameState.PLAYERONE;
    this.playerOneName = pOne;
    this.playerTwoName = pTwo;
    this.playerOnePic = new SerializableBitmap(pOnePic);
    this.playerTwoPic = new SerializableBitmap(pTwoPic);
    this.playerOneFallbackCount = fallback;
    this.playerTwoFallbackCount = fallback;
    this.playerOneTime = timeLimit;
    this.playerTwoTime = timeLimit;

  }

  public int getCurrentUserFallbackCount() {
    if (currentPlayer == PLAYERONE)
      return playerOneFallbackCount;
    return playerTwoFallbackCount;
  }

  public String getPlayerOneName() {
    return playerOneName;
  }

  public String getPlayerTwoName() {
    return playerTwoName;
  }

  public Bitmap getPlayerOnePic() {
    return playerOnePic.getImage();
  }

  public Bitmap getPlayerTwoPic() {
    return playerTwoPic.getImage();
  }

  public int getPlayerOneTime() {
    return playerOneTime;
  }

  public int getPlayerTwoTime() {
    return playerTwoTime;
  }

  public void decreasePlayerOneTime() {
    playerOneTime--;
  }

  public void decreasePlayerTwoTime() {
    playerTwoTime--;
  }

  public int whosTurn() {
    return currentPlayer;
  }

  public void changeTurn() {
    if (currentPlayer == PLAYERONE)
      currentPlayer = GameState.PLAYERTWO;
    else
      currentPlayer = GameState.PLAYERONE;
  }

  @Override
  public boolean canFallback() {
    if (currentPlayer == PLAYERONE) {
      if (playerOneFallbackCount > 0)
        return true;
    } else if (playerTwoFallbackCount > 0)
      return true;
    return false;
  }

  @Override
  public boolean fallback() {
    if (currentPlayer == PLAYERONE)
      playerOneFallbackCount--;
    else
      playerTwoFallbackCount--;
    return true;
  }
}

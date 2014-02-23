/*******************************************************************************
 * Copyright (c) 2013 AUTHORS.txt
 * All rights reserved. Distributed under the terms of the MIT License.
 ******************************************************************************/
package com.oose.chessgame.darkchessman;

import android.graphics.Bitmap;

import com.oose.darkchess.DarkChessBoard;
import com.oose.darkchess.DarkChessMan;
import com.oose.factory.DarkChessPictureList;
import com.oose.prototype.ChessMan;

public class BlackHorse extends DarkChessMan {
  private static final long serialVersionUID = -1409206149650707436L;

  public BlackHorse(int x, int y, DarkChessBoard board) {
    super(x, y, ChessMan.BLACK, board, 3);
  }

  public BlackHorse(BlackHorse bh) {
    super(bh);
  }

  @Override
  public BlackHorse clone() throws CloneNotSupportedException {
    return new BlackHorse(this);
  }

  @Override
  public Bitmap getIcon() {

    if (this.visible)
      return DarkChessPictureList.getIcon(this.getClass().getName());

    else
      return DarkChessPictureList.getIcon("com.oose.chessgame.darkchessman.UnFlip");
  }

  @Override
  public Bitmap getSelectedIcon() {
    if (this.visible)
      return DarkChessPictureList.getIcon(this.getClass().getName() + "SELECTED");
    else
      return DarkChessPictureList.getIcon("com.oose.chessgame.darkchessman.UnFlip" + "SELECTED");
  }
}

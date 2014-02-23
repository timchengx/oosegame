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

public class BlackElephant extends DarkChessMan {

  private static final long serialVersionUID = 587763541630849072L;

  public BlackElephant(int x, int y, DarkChessBoard board) {
    super(x, y, ChessMan.BLACK, board, 5);
  }

  public BlackElephant(BlackElephant be) {
    super(be);
  }

  @Override
  public BlackElephant clone() throws CloneNotSupportedException {
    return new BlackElephant(this);
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

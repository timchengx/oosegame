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

public class BlackShi extends DarkChessMan {

  private static final long serialVersionUID = 5287378310377711625L;

  public BlackShi(int x, int y, DarkChessBoard board) {
    super(x, y, ChessMan.BLACK, board, 6);
  }

  public BlackShi(BlackShi bs) {
    super(bs);
  }

  @Override
  public BlackShi clone() throws CloneNotSupportedException {
    return new BlackShi(this);
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

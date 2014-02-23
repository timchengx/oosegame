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

public class RedHorse extends DarkChessMan {

  private static final long serialVersionUID = -6934211629145832437L;

  public RedHorse(int x, int y, DarkChessBoard board) {
    super(x, y, ChessMan.RED, board, 3);
  }

  public RedHorse(RedHorse redShi) {
    super(redShi);
  }

  @Override
  public RedHorse clone() throws CloneNotSupportedException {
    return new RedHorse(this);
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

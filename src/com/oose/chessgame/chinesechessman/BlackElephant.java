/*******************************************************************************
 * Copyright (c) 2013 AUTHORS.txt
 * All rights reserved. Distributed under the terms of the MIT License.
 ******************************************************************************/
package com.oose.chessgame.chinesechessman;

import android.graphics.Bitmap;

import com.oose.chinesechess.ChineseChessBoard;
import com.oose.chinesechess.ChineseChessMan;
import com.oose.factory.ChineseChessPictureList;
import com.oose.prototype.ChessMan;

public class BlackElephant extends ChineseChessMan {

  private static final long serialVersionUID = 587763541630849072L;

  public BlackElephant(int x, int y, ChineseChessBoard board) {
    super(x, y, ChessMan.BLACK, board);
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
    return ChineseChessPictureList.getIcon(this.getClass().getName());
  }

  @Override
  public Bitmap getSelectedIcon() {
    return ChineseChessPictureList.getIcon(this.getClass().getName() + "SELECTED");
  }

  @Override
  public boolean move(int x, int y) {
    if (0 <= x && x <= 8 && 0 <= y && y <= 4)
      if (Math.abs((currentX - x)) == 2 && Math.abs((currentY - y)) == 2)
        if (!board.hasChess((x + currentX) / 2, (y + currentY) / 2)) {
          inBoardMoveChess(x, y);
          return true;
        }

    return false;
  }

  @Override
  public boolean eat(int x, int y) {
    return move(x, y);
  }

}

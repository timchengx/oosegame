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

public class RedSoldier extends ChineseChessMan {

  private static final long serialVersionUID = 1042800279641311800L;

  public RedSoldier(int x, int y, ChineseChessBoard board) {
    super(x, y, ChessMan.RED, board);
  }

  public RedSoldier(RedSoldier rs) {
    super(rs);
  }

  public Bitmap getIcon() {
    return ChineseChessPictureList.getIcon(this.getClass().getName());
  }

  public Bitmap getSelectedIcon() {
    return ChineseChessPictureList.getIcon(this.getClass().getName() + "SELECTED");
  }

  @Override
  public RedSoldier clone() throws CloneNotSupportedException {
    return new RedSoldier(this);
  }

  @Override
  public boolean move(int x, int y) {
    if (currentY >= 5) {// 過河前
      if (currentY - y == 1 && x == currentX) {
        inBoardMoveChess(x, y);
        return true;
      }
    } else {// 過河後
      if ((Math.abs(y - currentY) + Math.abs(x - currentX)) == 1 && y <= currentY) {
        inBoardMoveChess(x, y);
        return true;
      }
    }
    return false;
  }

  @Override
  public boolean eat(int x, int y) {
    return move(x, y);
  }

}

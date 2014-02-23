/*******************************************************************************
 * Copyright (c) 2013 AUTHORS.txt
 * All rights reserved. Distributed under the terms of the MIT License.
 ******************************************************************************/
package com.oose.prototype;

/* Observer/Observable Design Pattern */
public interface Observable {
  public void notifyObservers(Object carry);
}

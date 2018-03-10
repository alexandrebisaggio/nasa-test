/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bisaggio.nasa.business;

import bisaggio.nasa.domain.Direction;
import bisaggio.nasa.domain.Turn;

/**
 *
 * @author bisaggio
 */
public interface Location extends Turn{
    
    public Number getX();
    public Number getY();
    public void setY(Number y);
    public void setX(Number x);
    public Direction getDirection();
    public void setDirection(Direction direction);
    
}

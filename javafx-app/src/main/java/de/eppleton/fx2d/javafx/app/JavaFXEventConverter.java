/**
 * This file is part of FXGameEngine 
 * A Game Engine written in JavaFX
 * Copyright (C) 2012 Anton Epple <info@eppleton.de>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, version 2 of the License.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. Look for COPYING file in the top folder.
 * If not, see http://opensource.org/licenses/GPL-2.0.
 * 
 * For alternative licensing or use in closed source projects contact Anton Epple 
 * <info@eppleton.de>
 */
package de.eppleton.fx2d.javafx.app;

import de.eppleton.fx2d.event.Event;
import de.eppleton.fx2d.event.KeyCode;
import de.eppleton.fx2d.event.KeyEvent;
import de.eppleton.fx2d.event.MouseEvent;
import javafx.event.EventType;

/**
 *
 * @author antonepple
 */
public class JavaFXEventConverter  {

    
    public static Event.Type convertEventType(EventType eventType) {
        if (eventType == javafx.scene.input.MouseEvent.ANY) {
            return MouseEvent.ANY;
        } else if (eventType == javafx.scene.input.MouseEvent.MOUSE_CLICKED) {
            return MouseEvent.MOUSE_CLICKED;
        } else if (eventType == javafx.scene.input.MouseEvent.MOUSE_DRAGGED) {
            return MouseEvent.MOUSE_DRAGGED;
        } else if (eventType == javafx.scene.input.MouseEvent.MOUSE_ENTERED) {
            return MouseEvent.MOUSE_ENTERED;
        } else if (eventType == javafx.scene.input.MouseEvent.MOUSE_ENTERED_TARGET) {
            return MouseEvent.MOUSE_ENTERED_TARGET;
        } else if (eventType == javafx.scene.input.MouseEvent.MOUSE_EXITED) {
            return MouseEvent.MOUSE_EXITED_TARGET;
        } else if (eventType == javafx.scene.input.MouseEvent.MOUSE_MOVED) {
            return MouseEvent.MOUSE_MOVED;
        } else if (eventType == javafx.scene.input.MouseEvent.MOUSE_PRESSED) {
            return MouseEvent.MOUSE_PRESSED;
        } else if (eventType == javafx.scene.input.MouseEvent.MOUSE_RELEASED) {
            return MouseEvent.MOUSE_RELEASED;
        } else if (eventType == javafx.scene.input.KeyEvent.ANY) {
            return KeyEvent.ANY;
        } else if (eventType == javafx.scene.input.KeyEvent.KEY_PRESSED) {
            return KeyEvent.KEY_PRESSED;
        } else if (eventType == javafx.scene.input.KeyEvent.KEY_RELEASED) {
            return KeyEvent.KEY_RELEASED;
        } else if (eventType == javafx.scene.input.KeyEvent.KEY_TYPED) {
            return KeyEvent.KEY_TYPED;
        }

        return Event.ANY;
    }

    public static Event copyForGame(javafx.event.Event event) {
        if (event instanceof javafx.scene.input.InputEvent) {
            if (event instanceof javafx.scene.input.MouseEvent) {
                javafx.scene.input.MouseEvent me = (javafx.scene.input.MouseEvent) event;

                Event copied = new MouseEvent(event.getSource(), convertEventType(event.getEventType()), me.getX(), me.getY());
                return copied;
            }else if (event instanceof javafx.scene.input.KeyEvent) {
                javafx.scene.input.KeyEvent ke = (javafx.scene.input.KeyEvent) event;

                Event copied = new KeyEvent(event.getSource(), convertEventType(event.getEventType()), KeyCode.getKeyCode(ke.getCode().getName()));
                return copied;
            }
        }
        return null;
    }
}

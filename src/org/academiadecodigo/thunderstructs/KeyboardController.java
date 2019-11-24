package org.academiadecodigo.thunderstructs;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class KeyboardController implements KeyboardHandler {

    private Keyboard keyboard;
    private KeyboardEvent spacePressed;
    private KeyboardEvent spaceReleased;
    private Cursor cursor;

    public KeyboardController(Cursor cursor){
        keyboard = new Keyboard(this);
        spacePressed = new KeyboardEvent();
        spaceReleased = new KeyboardEvent();
        this.cursor = cursor;
        initKeyboard();
    }

    public void initKeyboard(){

        spacePressed.setKey(KeyboardEvent.KEY_SPACE);
        spacePressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        spaceReleased.setKey(KeyboardEvent.KEY_SPACE);
        spaceReleased.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

        keyboard.addEventListener(spacePressed);
        keyboard.addEventListener(spaceReleased);
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_SPACE) {
            cursor.setPainting(true);
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_SPACE) {
            cursor.setPainting(false);
        }
    }
}

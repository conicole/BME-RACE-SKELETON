import java.awt.event.KeyEvent;

import java.awt.event.KeyListener;
public class KeyboardInput implements KeyListener {

	private static final int KEY_COUNT = 256;

	//keyboard states
	private enum KeyState {

		RELEASED, // Not down

		PRESSED,  // Down, but not the first time

		ONCE      // Down for the first time

	}



	// Current state of the keyboard

	private boolean[] currentKeys = null;



	// Polled keyboard state

	private KeyState[] keys = null;

//constructor

	public KeyboardInput() {

		currentKeys = new boolean[ KEY_COUNT ];

		keys = new KeyState[ KEY_COUNT ];

		for( int i = 0; i < KEY_COUNT; ++i ) {

			keys[ i ] = KeyState.RELEASED;

		}

	}


//waits for keyboard press
	public synchronized void poll() {
		for( int i = 0; i < KEY_COUNT; ++i ) {


			// Set the key state

			if( currentKeys[ i ] ) {




				// If the key is down now, but was not

				// down last frame, set it to ONCE,

				// otherwise, set it to PRESSED

				if( keys[ i ] == KeyState.RELEASED )

					keys[ i ] = KeyState.ONCE;

				else

					keys[ i ] = KeyState.PRESSED;

			} else {

				keys[ i ] = KeyState.RELEASED;

			}

		}

	}


//keydown event
	public boolean keyDown( int keyCode ) {

		return keys[ keyCode ] == KeyState.ONCE ||

				keys[ keyCode ] == KeyState.PRESSED;

	}

//keydownonce event

	public boolean keyDownOnce( int keyCode ) {
		return keys[ keyCode ] == KeyState.ONCE;

	}


//keypressevent
	public synchronized void keyPressed( KeyEvent e ) {
		int keyCode = e.getKeyCode();
		if( keyCode >= 0 && keyCode < KEY_COUNT ) {

			currentKeys[ keyCode ] = true;

		}

	}



//key release event
	public synchronized void keyReleased( KeyEvent e ) {

		int keyCode = e.getKeyCode();

		if( keyCode >= 0 && keyCode < KEY_COUNT ) {

			currentKeys[ keyCode ] = false;

		}

	}



	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}
}
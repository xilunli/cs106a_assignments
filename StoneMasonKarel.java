/*
 * File: StoneMasonKarel.java
 * --------------------------
 * The StoneMasonKarel subclass as it appears here does nothing.
 * When you finish writing it, it should solve the "repair the quad"
 * problem from Assignment 1.  In addition to editing the program,
 * you should be sure to edit this comment so that it no longer
 * indicates that the program does nothing.
 */

import stanford.karel.*;

public class StoneMasonKarel extends SuperKarel {

	/*
	 * function: main program, fixing the arches, place all the missing "stones"
	 * pre-condition: Karel starts at 1st Avenue and 1st Street, facing east;
	 * post-condition: Karel standing at the 1st Street and the last Avenue, facing east; 
	 */
	public void run() {
		fixingArches();
	}
	
	/*
	 * function: place missing beepers for each column recursively
	 * pre-condition: Karel starts at 1st Avenue and 1st Street, facing east;
	 * post-condition: Karel standing at the 1st Street and the last Avenue, facing east; 
	 */
	private void fixingArches() {
		//fix 1 column;
		goFixing();
		//go back to the starting point of current column;
		goBack();
		//move to the next column and do the fixing;
		if (frontIsClear()) {
			moveToNextColumn();
			fixingArches();			
		}
	}

	/*
	 * function: place missing beepers for 1 column;
	 * pre-condition: standing at 1st street and facing east at the current column;
	 * post-condition: standing at the last street of the current column with all missing beepers placed, facing east;
	 */
	private void goFixing() {
		turnLeft();
		while (frontIsClear()) {
			if (noBeepersPresent()) {
				putBeeper();
			}
			move();
		}
		if (noBeepersPresent()) {
			putBeeper();
		}		
	}
	
	/*
	 *function: go back to the staring point of current column;
	 * pre-condition: standing at the last street of the current column, facing east;
	 * post-condition: standing at the 1st street of the current column, facing east;
	 */
	private void goBack() {
		turnAround();
		while(frontIsClear()) {
			move();
		}
		turnLeft();
	}
	
	/*
	 * function: move to the next column;
	 * pre-condition: standing at the 1st street of the current column, facing east;
	 * post-condition: standing at the 1st street of the next column, facing east;
	 */
	private void moveToNextColumn() {
		for (int i=0;i<4;i++) {
			move();
		}
	}
}

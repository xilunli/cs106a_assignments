/*
 * File: CheckerboardKarel.java
 * ----------------------------
 * When you finish writing it, the CheckerboardKarel class should draw
 * a checkerboard using beepers, as described in Assignment 1.  You
 * should make sure that your program works for all of the sample
 * worlds supplied in the starter folder.
 */

import stanford.karel.*;

public class CheckerboardKarel extends SuperKarel {

	/*
	 *function: Karel create a checkerboard pattern
	 * pre-condition: Karel standing at 1st avenue and 1st street;
	 * post-condition: Karel complete checkerboard pattern creation,standing at the last street 1st avenue (even number of streets) or last avenue (odd number of streets)
	 */
	public void run() {
		putBeeper();
		completeOneRow();
		
	}
	/*
	 * function: making checkerboard pattern recursively;
	 * pre-condition: Karel standing at the 2nd avenue and 1st street with beeper present at 1st avenue and 1st street;
	 * post-condition: Karel complete checkerboard pattern creation,standing at the last street 1st avenue (even number of streets) or last avenue (odd number of streets)
	 */
	private void completeOneRow() {
		moveAndPutBeeper();
		moveToNextRow();
		if (facingEast() || facingWest()){
			completeOneRow();
		}
	}
	/*
	 * function: put beepers alternately until reach the wall;
	 * pre-condition: Karel standing with backside against wall, 
	 * post-condition: Karel stadning against wall, facing wall.
	 */
	private void moveAndPutBeeper() {
		while (frontIsClear()) {
			if (beepersPresent()) {
				move();
			}
			else {
				move();
				putBeeper();
			}
		}

	}
	/*
	 * function: Karel move to the next row and put beeper at at the first point of the row if necessary.
	 * pre-condition: Karel standing against wall, facing wall
	 * post-condition: Karel standing with backside against wall,
	 */
	private void moveToNextRow() {
		//deal with facing east case;
		if (facingEast()) {
			turnLeft();
			//check if beeper present at the last point of the last row, if beeper not present, put a beeper at the first point of next row;
			if (frontIsClear()) {
				if (beepersPresent()) {
					move();
					turnLeft();
				} else {
					move();
					turnLeft();
					putBeeper();
				}
			}
		}
		//deal with facing west case;
		else if (facingWest()) {
			turnRight();
			if (frontIsClear()) {
				//check if beeper present at the last point of the last row, if beeper not present, put a beeper at the first point of next row;
				if (beepersPresent()) {
					move();
					turnRight();
				} else {
					move();
					turnRight();
					putBeeper();
				}
			}
		}
		//else return;
	}

}

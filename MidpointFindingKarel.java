/*
 * File: MidpointFindingKarel.java
 * -------------------------------
 * When you finish writing it, the MidpointFindingKarel class should
 * leave a beeper on the corner closest to the center of 1st Street
 * (or either of the two central corners if 1st Street has an even
 * number of corners).  Karel can put down additional beepers as it
 * looks for the midpoint, but must pick them up again before it
 * stops.  The world may be of any size, but you are allowed to
 * assume that it is at least as tall as it is wide.
 */

import stanford.karel.*;

public class MidpointFindingKarel extends SuperKarel {

	/*
	 * function: find the mid point of the first street and put a beeper there with Karel standing on it.
	 * pre-condition: Karel standing at 1st avenue and 1st street;
	 * post-condition: Karel standing on a beeper at the mid point of 1st street;
	 */
	public void run() {
		putEndBeeper();
		findMidPoint();
	}
	
	/*
	 *function: find the mid point recursively, using beeper as a marker, whenever reach a beeper, turn around and pick up the beeper,
	 *move 1 step forward if no beeper present, repeat this process, otherwise we have reach the mid point, stop
	 *pre-condition: Karel standing with 1 beeper right behind it, facing east or west;
	 *post-condition:  Karel standing with 1 beeper right behind it, facing east or west, or Karel standing on a beeper.
	 */
	private void findMidPoint() {
		while (frontIsClear() && noBeepersPresent()) {
			move();
		}
		pickBeeper();
		turnAround();
		move();
		if (noBeepersPresent()) {
			putBeeper();
			move();
			findMidPoint();
		}
		
	}	
	/*
	 * function: put 1 beeper at the 2 ends of the 1st street
	 * pre-condition: Karel standing at 1st avenue and 1st street, facing east;
	 * post-condition: Karel standing at the second last avenue and 1st street, facing west, with 1 beeper at each end of 1st street;
	 */
	public void putEndBeeper() {
		putBeeper();
		moveToWall();
		putBeeper();
		turnAround();
		move();
	}
	
	public void moveToWall() {
		while(frontIsClear()) {
			move();
		}
	}

}

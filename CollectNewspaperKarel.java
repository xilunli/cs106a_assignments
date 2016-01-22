/*
 * File: CollectNewspaperKarel.java
 * --------------------------------
 * At present, the CollectNewspaperKarel subclass does nothing.
 * Your job in the assignment is to add the necessary code to
 * instruct Karel to walk to the door of its house, pick up the
 * newspaper (represented by a beeper, of course), and then return
 * to its initial position in the upper left corner of the house.
 */

import stanford.karel.*;


public class CollectNewspaperKarel extends SuperKarel {
	
	/*
	 * function: main program including 3 steps, first move to the paper, 
	 *then pick it up and return to the original position;
	 *pre-condition: Karel facing east at the northwest corner of its house;
	 *post-condition: Karel facing east at the northwest corner of its house;
	*/
	public void run() {
		moveToPaper();
		pickUpPaper();
		returnToStart();
	}

	/*
	 * function: Karel move to the paper.
	 * pre-condition: Karel facing east at the northwest corner of its house;
	 * post-condition: Karel stading on the paper, facing east;
	 */
	private void moveToPaper() {
		move();
		move();
		turnRight();
		move();
		turnLeft();
		move();
	}
	
	//function: pick up the paper.
	private void pickUpPaper() {
		pickBeeper();
	}
	
	/*
	 * function: return to the original starting point.
	 * pre-condition: Karel facing east at the door way;
	 * post-condition: Karel facing east at the northwest corner of its house;
	 */
	private void returnToStart() {
		turnAround();
		move();
		move();
		move();
		turnRight();
		move();
		turnRight();
	}
}
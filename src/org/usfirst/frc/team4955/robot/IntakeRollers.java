package org.usfirst.frc.team4955.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Talon;

/**
 * This class is to be used for creating IntakeRollers objects, which will allow the tele-operator to
 * manipulate the intake rollers with an inward and outward suction.
 * The intake rollers are controlled via an Attack 3 Joystick. The mapping is as follows:
 * Button 8 -------> Intake out
 * Button 7 -------> Intake in
*/
public class IntakeRollers {
	
	private Talon left, right;
	
	IntakeRollers (int leftPWM, int rightPWM) {
    	left = new Talon(leftPWM);
    	right = new Talon(rightPWM);
	}
	
	void run(Joystick controlStick) {
		
	        if (controlStick.getRawButton(Constants.EIGHT_BUTTON_ATTACK3)) {
	        	System.out.println("Intake out (Button 8)");
	        	left.set(1.0);
	        	right.set(-1.0);
	        	
	        } else if (controlStick.getRawButton(Constants.SEVEN_BUTTON_ATTACK3)) {
	        	System.out.println("Intake in (Button 7)");
	        	left.set(-1.0);
	        	right.set(1.0);
	        	
	        } else {
	        	left.set(0);
	        	right.set(0);
	        } 
	}
}


package org.usfirst.frc.team4955.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Talon;

public class IntakeRollers {
	
	private Talon left, right;
	
	IntakeRollers(int leftPWM, int rightPWM) {
    	left = new Talon(leftPWM);
    	right = new Talon(rightPWM);
	}
	
	void run(Joystick controlStick) {
		
	        if(controlStick.getRawButton(Constants.EIGHT_BUTTON_ATTACK3)) {
	        	System.out.println("Intake out (Button 8)");
	        	left.set(1.0);
	        	right.set(-1.0);
	        	
	        } else if(controlStick.getRawButton(Constants.SEVEN_BUTTON_ATTACK3)) {
	        	System.out.println("Intake in (Button 7)");
	        	left.set(-1.0);
	        	right.set(1.0);
	        	
	        } else {
	        	left.set(0);
	        	right.set(0);
	        } 
	}
}


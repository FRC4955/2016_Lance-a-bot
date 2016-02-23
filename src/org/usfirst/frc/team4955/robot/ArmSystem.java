package org.usfirst.frc.team4955.robot;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.DigitalInput;

public class ArmSystem {

	private CANTalon armExtension, armPitch;
	private Talon armYaw;
	private DigitalInput leftSwitch, rightSwitch, pitchSwitch, extendSwitch;
	

	ArmSystem() {
		armExtension = new CANTalon(Constants.ARM_EXTENSION);
		armPitch = new CANTalon(Constants.ARM_PITCH);
		armYaw = new Talon(Constants.ARM_YAW);
		leftSwitch = new DigitalInput(Constants.YAW_LEFT_SWITCH);
		rightSwitch = new DigitalInput(Constants.YAW_RIGHT_SWITCH);
		pitchSwitch = new DigitalInput(Constants.PITCH_SWITCH);
		extendSwitch = new DigitalInput(Constants.EXTEND_SWITCH);
	}

	void run(Joystick controlStick) {
		double z_input = controlStick.getRawAxis(Constants.Z_AXIS_XBOX);
		if (Math.abs(z_input) > Constants.JOYSTICK_ZERO_THRESHOLD) {
			System.out.println("Arm yaw movement");
			//
			if(!leftSwitch.get() && !rightSwitch.get() ||
					leftSwitch.get() && z_input < 0 ||
					rightSwitch.get() && z_input > 0
				){
				armYaw.set(z_input);
			}
			//
		} else {
			/*
			 * Set Yaw control to 0 if right joystick X axis value is less than
			 * or equal to zero threshold
			 */
			armYaw.set(0.0);
		}

		// Pitch Control (Left Joystick Y axis)
		double left_y = controlStick.getRawAxis(Constants.LEFT_Y_AXIS_XBOX);
		if (Math.abs(left_y) > Constants.JOYSTICK_ZERO_THRESHOLD) {
			System.out.println("Arm pitch movement");
			if(!pitchSwitch.get() || pitchSwitch.get() && left_y < 0){
				armPitch.set(controlStick.getRawAxis(Constants.LEFT_Y_AXIS_XBOX));
			}
		} else {
			/*
			 * Set Yaw control to 0 if right joystick X axis value is less than
			 * or equal to zero threshold
			 */
			armPitch.set(0.0);
		}

		// Extension Control (Right Joystick Y axis)
		double right_y = controlStick.getRawAxis(Constants.RIGHT_Y_AXIS_XBOX);
		if (Math.abs(right_y) > Constants.JOYSTICK_ZERO_THRESHOLD) {
			System.out.println("Arm extension movement");
			if(!extendSwitch.get() || extendSwitch.get() && right_y < 0){
				armExtension.set(right_y);
			}
		} else {
			/*
			 * Set Yaw control to 0 if right joystick X axis value is less than
			 * or equal to zero threshold
			 */
			armExtension.set(0.0);
		}

	}
	
	//Set control mode of all motors to PercentVbus (Teleop)
	void setControlModePercent () {
		armExtension.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
		armPitch.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
	}
	//Set control mode of all motors to Position (Autonomous)
	void setControlModePosition () {
		armExtension.changeControlMode(CANTalon.TalonControlMode.Position);
		armPitch.changeControlMode(CANTalon.TalonControlMode.Position);
	}
}

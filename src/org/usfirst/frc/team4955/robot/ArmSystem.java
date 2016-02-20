package org.usfirst.frc.team4955.robot;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Joystick;

public class ArmSystem {

	private CANTalon armExtension, armPitch;
	private Talon armYaw;

	ArmSystem(int armExtensionId, int armPitchId, int armYawPWM) {
		armExtension = new CANTalon(Constants.ARM_EXTENSION);
		armPitch = new CANTalon(Constants.ARM_PITCH);
		armYaw = new Talon(Constants.ARM_YAW);
	}

	void run(Joystick controlStick) {
		// Yaw Control (LT or RT)
		if (Math.abs(controlStick.getRawAxis(Constants.Z_AXIS_XBOX)) > 
				Constants.JOYSTICK_ZERO_THRESHOLD) {
			System.out.println("Arm yaw movement");
			armYaw.set(controlStick.getRawAxis(Constants.Z_AXIS_XBOX));
		} else {
			/*
			 * Set Yaw control to 0 if right joystick X axis value is less than
			 * or equal to zero threshold
			 */
			armYaw.set(0.0);
		}

		// Pitch Control (Left Joystick Y axis)
		if (Math.abs(controlStick.getRawAxis(Constants.ARM_PITCH)) > 
				Constants.JOYSTICK_ZERO_THRESHOLD) {
			System.out.println("Arm pitch movement");
			armPitch.set(controlStick.getRawAxis(Constants.ARM_PITCH));
		} else {
			/*
			 * Set Yaw control to 0 if right joystick X axis value is less than
			 * or equal to zero threshold
			 */
			armPitch.set(0.0);
		}

		// Extension Control (Right Joystick Y axis)
		if (Math.abs(controlStick.getRawAxis(Constants.ARM_EXTENSION)) > 
				Constants.JOYSTICK_ZERO_THRESHOLD) {
			System.out.println("Arm extension movement");
			armExtension.set(controlStick.getRawAxis(Constants.ARM_EXTENSION));
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

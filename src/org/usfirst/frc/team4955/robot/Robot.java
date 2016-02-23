package org.usfirst.frc.team4955.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	
	//---------Object Declarations---------- 
	
	//Drive Base
	RobotDrive myRobot;
	
	//Driver Controls
	Joystick driveStickLeft, driveStickRight, controlStick;
		
	//Checks amount of loops (for autonomous)
	int autoLoopCounter;
	
	// System objects
	IntakeRollers intake;
	ArmSystem armSystem;
	
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    	
    	//---------Object Instantiations----------
    	
    	//Initialize drive base with motor controllers in order:
    	//front left, rear left, front right and rear right
    	myRobot = new RobotDrive(Constants.FRONT_LEFT, Constants.REAR_LEFT,
    			Constants.FRONT_RIGHT, Constants.REAR_RIGHT);
    	driveStickLeft = new Joystick(0);
    	driveStickRight = new Joystick(1);
    	controlStick = new Joystick(2);
    	
    	//Intialize subsystems with respective arguments:
    	//intake -------> left motor PWM, right motor PWM
    	//arm system ---> extender motor Talon SRX ID, pitch control motor Talon SRX ID, yaw control motor Talon ID
    	intake = new IntakeRollers(Constants.LEFT_INTAKE, Constants.RIGHT_INTAKE);
    	armSystem = new ArmSystem();
    }
    
    /**
     * This function is run once each time the robot enters autonomous mode
     */
    public void autonomousInit() {
    	autoLoopCounter = 0;
    	
    	//Change arm system Talon SRX control mode to Position
    	armSystem.setControlModePosition();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
    	if(autoLoopCounter < 100) //Check if we've completed 100 loops (approximately 2 seconds)
		{
			myRobot.drive(-0.5, 0.0); 	// drive forwards half speed
			autoLoopCounter++;
			} else {
			myRobot.drive(0.0, 0.0); 	// stop robot
		}
    }
    
    /**
     * This function is called once each time the robot enters tele-operated mode
     */
    public void teleopInit(){
    	
    	//Change arm system Talon SRX control mode to PercentVbus
    	armSystem.setControlModePercent();
    	
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
    	
        myRobot.tankDrive(driveStickLeft, driveStickRight);

    	//Arm system
    	armSystem.run(controlStick);
    	
    	//Intake rollers
    	intake.run(controlStick);
    	
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    	LiveWindow.run();
    }
    
}

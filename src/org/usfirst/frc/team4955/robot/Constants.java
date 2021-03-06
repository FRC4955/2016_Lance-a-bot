package org.usfirst.frc.team4955.robot;

/**
 * This class is to be referred to for all constants referencing system I/O port numbers, IDs, joystick
 * button and axes numbers. 
*/
//TODO: 
//Replicate team 254's implementation for their constants class, so that
//we have the following unobtusive constants editing system: 
//Modify all constants on one text file, then have the compiler read them from the
//file.

public class Constants {

	//---------Buttons and Axes---------- 
	
	//XBOX controller
	public static final int A_BUTTON_XBOX = 1;
	public static final int B_BUTTON_XBOX = 2;
	public static final int Y_BUTTON_XBOX = 4;
	public static final int X_BUTTON_XBOX = 3;
	public static final int LB_BUTTON_XBOX = 5;
	public static final int RB_BUTTON_XBOX = 6;
	
	public static final int Z_AXIS_XBOX = 3;// LT -> POSITIVE, RT -> NEGATIVE
	public static final int LEFT_X_AXIS_XBOX = 1;
	public static final int LEFT_Y_AXIS_XBOX = 2;
	public static final int RIGHT_X_AXIS_XBOX = 4;
	public static final int RIGHT_Y_AXIS_XBOX = 5;
	public static final int D_PAD_AXIS_XBOX = 6;		

	//ATTACK3 joystick
	public static final int TRIGGER_BUTTON_ATTACK3 = 1;
	public static final int TWO_BUTTON_ATTACK3 = 2;
	public static final int THREE_BUTTON_ATTACK3 = 3;
	public static final int FOUR_BUTTON_ATTACK3 = 4;
	public static final int FIVE_BUTTON_ATTACK3 = 5;
	public static final int SIX_BUTTON_ATTACK3 = 6;
	public static final int SEVEN_BUTTON_ATTACK3 = 7;
	public static final int EIGHT_BUTTON_ATTACK3 = 8;
	public static final int NINE_BUTTON_ATTACK3 = 9;
	public static final int TEN_BUTTON_ATTACK3 = 10;
	public static final int ELEVEN_BUTTON_ATTACK3 = 11;
	public static final int X_AXIS_ATTACK3 = 1;
	public static final int Y_AXIS_ATTACK3 = 2;
	public static final int Z_AXIS_ATTACK3 = 3; //Throttle
	
	//---------Systems---------- 
	
	//Drivebase, Talons
	public static final int FRONT_LEFT = 0;
	public static final int REAR_LEFT = 1;
	public static final int FRONT_RIGHT = 2; 
	public static final int REAR_RIGHT = 3;
	
	//Intake System, Talons
	public static final int LEFT_INTAKE = 4;
	public static final int RIGHT_INTAKE = 5;
	
	//Arm System, TalonSRX IDs (Refer to Robo-RIO config webpage for devide IDs)
	public static final int ARM_EXTENSION = 0;
	public static final int ARM_PITCH = 1;
	
	//Arm System, Talons
	public static final int ARM_YAW = 2;

	// Arm system limit switches
	public static final int YAW_LEFT_SWITCH = 0;
	public static final int YAW_RIGHT_SWITCH = 1;
	public static final int PITCH_SWITCH = 2;
	public static final int EXTEND_SWITCH = 3;
	
	//---------Miscellaneous---------- 
	public static final double JOYSTICK_ZERO_THRESHOLD = 0.1;
}

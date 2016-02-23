package org.usfirst.frc.team4955.robot;
import edu.wpi.first.wpilibj.CANTalon;

public class EncoderConversions {
  
  public double getEncPosRel (CANTalon motor) {
    double encPosRel = motor.getEncPosition();
    return encPosRel;
  }
  
  public double getEncVelRel (CANTalon motor) {
    double encVelRel = motor.getEncVelocty();
    return encVelRel;
  }
  
  public double getEncPosAbs (CANTalon motor) {
    double encPosAbs = motor.getPulseWidthPosition();
    return encPosAbs;
  }
  
  public double getEncVelAbs (CANTalon motor) {
    double encVelAbs = motor.getPulseWidthVelocty();
    return encVelAbs;
  }

}

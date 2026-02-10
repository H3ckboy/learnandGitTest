// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;


import edu.wpi.first.wpilibj2.command.SubsystemBase;

//Bring SparkMAX library into the Subsystem
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.PersistMode;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.ResetMode;

//Bringing different levels of the Constants files in the Subsystem
import frc.robot.Constants.MotorConstants;
import frc.robot.Constants;

public class ExampleSubsystem extends SubsystemBase {

    //create a new motor with the CANBus ID 9, and a "brushless" motor type (NEO is always brushless)
    private final SparkMax exampleMotor = new SparkMax(9, MotorType.kBrushless);
    //creates a new motor with the CANBus ID 10, using kNEO varible created in Constants
    private final SparkMax testMotor = new SparkMax(10, MotorConstants.kNEO);


    public RelativeEncoder testMotorEncoder = testMotor.getEncoder();

  /** Creates a new ExampleSubsystem. */
  public ExampleSubsystem() {
    /* Applying the motor Configs set up in Constants file.
     * 
    */
    exampleMotor.configure(
      Constants.kTwntyAmpConfig, 
      ResetMode.kResetSafeParameters, 
      PersistMode.kPersistParameters);

    testMotor.configure(
      Constants.kFrtyAmpConfig, 
      ResetMode.kResetSafeParameters, 
      PersistMode.kPersistParameters);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  //Creates a function that controls the speed of a motor on a scale of 0.0 (0%) - 1.0 (100%)
  public void motorSpeed(double motorSpeed){
    exampleMotor.set(motorSpeed);
  }

  //Creates a function that reads the encoder value of the testMotor
  public double encoderReading(){
    double testTicks = testMotorEncoder.getPosition();

    return testTicks;
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}

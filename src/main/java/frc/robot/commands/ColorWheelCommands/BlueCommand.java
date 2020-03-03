/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package frc.robot.commands.ColorWheelCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ColorWheelSubsystem;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class BlueCommand extends CommandBase {
  private final ColorWheelSubsystem m_ColorWheelSubsystem;
  /**
   * Creates a new BlueCommand.
   */
  public BlueCommand(ColorWheelSubsystem colorWheelSubsystem) {
    m_ColorWheelSubsystem = colorWheelSubsystem;
    addRequirements(colorWheelSubsystem);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    System.out.println("Blue-Execute");
    Color detectedColor = m_ColorWheelSubsystem.colorSensor.getColor();
    SmartDashboard.putNumber("Blue", detectedColor.blue);
    SmartDashboard.putNumber("Green", detectedColor.green);
    SmartDashboard.putNumber("Red", detectedColor.red);

     if(detectedColor.blue > 0.35 && detectedColor.green > 0.4 && detectedColor.green < 0.5 && detectedColor.red < 0.2) {
     m_ColorWheelSubsystem.stop();
     //double move = 0.0;
     //Robot.wheelSubsystem.wheel(move);
    }
    else{
      m_ColorWheelSubsystem.start();
      //double move = RobotMap.turn;  
      //Robot.wheelSubsystem.wheel(move);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}

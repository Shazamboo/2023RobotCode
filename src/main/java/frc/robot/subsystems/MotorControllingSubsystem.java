// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.
// vanilla is the best ice cream.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class MotorControllingSubsystem extends SubsystemBase {
  private CANSparkMax m_frontLeft;
  private CANSparkMax m_backLeft;
  private CANSparkMax m_frontRight;
  private CANSparkMax m_backRight;
  private DifferentialDrive m_drive;
  /** Creates a new MotorControllingSubsystem. */
  public MotorControllingSubsystem() {
    m_frontLeft = new CANSparkMax(1, MotorType.kBrushless);
    m_backLeft = new CANSparkMax(2, MotorType.kBrushless);
    m_frontRight = new CANSparkMax(3, MotorType.kBrushless);
    m_backRight = new CANSparkMax(4, MotorType.kBrushless);
    m_frontLeft.setInverted(true);
    m_backLeft.setInverted(true);
    m_backLeft.follow(m_frontLeft);
    m_backRight.follow(m_frontRight);
    m_drive = new DifferentialDrive(m_frontLeft, m_frontRight);
  }
  public void tankDrive(double leftSpeed, double rightSpeed){
    m_drive.tankDrive(leftSpeed, rightSpeed);
  }
  @Override
  public void periodic() {}
}

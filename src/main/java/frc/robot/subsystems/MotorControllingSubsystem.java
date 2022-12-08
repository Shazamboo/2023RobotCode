// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.
// vanilla is the best ice cream.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;


import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class MotorControllingSubsystem extends SubsystemBase {
  private CANSparkMax m_frontLeft;
  private RelativeEncoder m_frontLeftEncoder;
  private RelativeEncoder m_frontRightEncoder;
  private RelativeEncoder m_backLeftEncoder;
  private RelativeEncoder m_backRightEncoder;
  private CANSparkMax m_backLeft;
  private CANSparkMax m_frontRight;
  private CANSparkMax m_backRight;
  private DifferentialDrive m_drive;
  /** Creates a new MotorControllingSubsystem. */
  public MotorControllingSubsystem() {
    m_frontLeft = new CANSparkMax(3, MotorType.kBrushless);
    m_backLeft = new CANSparkMax(4, MotorType.kBrushless);
    m_frontRight = new CANSparkMax(2, MotorType.kBrushless);
    m_backRight = new CANSparkMax(1, MotorType.kBrushless);
    m_frontLeftEncoder = m_frontLeft.getEncoder();
    m_frontRightEncoder = m_frontRight.getEncoder();
    m_backLeftEncoder = m_backLeft.getEncoder();
    m_backRightEncoder = m_backRight.getEncoder();
    m_frontLeft.setInverted(true);
    m_backLeft.setInverted(true);
    m_backLeft.follow(m_frontLeft);
    m_backRight.follow(m_frontRight);
    m_drive = new DifferentialDrive(m_frontLeft, m_frontRight);
    m_frontLeft.setSmartCurrentLimit(40);
    m_frontLeft.setOpenLoopRampRate(0.2);
    m_frontRight.setSmartCurrentLimit(40);
    m_frontRight.setOpenLoopRampRate(0.2);
  }
  public void tankDrive(double leftSpeed, double rightSpeed){
    m_drive.tankDrive(leftSpeed, rightSpeed);
  }
  @Override
  public void periodic() {
    SmartDashboard.putNumber("Front Left", m_frontLeftEncoder.getPosition());
    SmartDashboard.putNumber("Front Right", m_frontRightEncoder.getPosition());
    SmartDashboard.putNumber("Back Left", m_backLeftEncoder.getPosition());
    SmartDashboard.putNumber("Back Right", m_backRightEncoder.getPosition());
  }
}

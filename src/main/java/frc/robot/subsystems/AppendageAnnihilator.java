// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.SparkMaxPIDController;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase; 
public class AppendageAnnihilator extends SubsystemBase {
  private CANSparkMax m_appendageAnnihilator;
  private SparkMaxPIDController m_PIDController;
  private boolean toggle;
  /** Creates a new AppendageAnnihilator. */
  public AppendageAnnihilator() {
    m_appendageAnnihilator = new CANSparkMax(5, MotorType.kBrushless);
    m_PIDController = m_appendageAnnihilator.getPIDController();
    m_PIDController.setP(1);
    m_PIDController.setI(0);
    m_PIDController.setD(0);
    m_PIDController.setFF(0);
    SmartDashboard.putNumber("P", m_PIDController.getP());
    SmartDashboard.putNumber("I", m_PIDController.getI());
    SmartDashboard.putNumber("D", m_PIDController.getD());
    SmartDashboard.putNumber("FF", m_PIDController.getFF());
    SmartDashboard.putBoolean("Update PID", false);
    m_PIDController.setReference(0, CANSparkMax.ControlType.kPosition);
  }
  public void moveAnnihilator(){
    toggle ^= true;
    if (toggle) {
      m_PIDController.setReference(50, CANSparkMax.ControlType.kPosition);
    } else if (toggle == false) {
      m_PIDController.setReference(0, CANSparkMax.ControlType.kPosition);
    }
  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    if (SmartDashboard.getBoolean("Update PID", false)){
      m_PIDController.setP(SmartDashboard.getNumber("P", m_PIDController.getP()));
      m_PIDController.setI(SmartDashboard.getNumber("I", m_PIDController.getI()));
      m_PIDController.setD(SmartDashboard.getNumber("D", m_PIDController.getD()));
      m_PIDController.setFF(SmartDashboard.getNumber("FF", m_PIDController.getFF()));
    }
  }
}


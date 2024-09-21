// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.util.sendable.Sendable;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.Constants.IntakeConstants;
import frc.robot.LimelightHelpers;
import frc.robot.LimelightHelpers.LimelightResults;
import frc.robot.Main;
import frc.robot.subsystems.Elevator;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Limelight;
import frc.robot.subsystems.Outtake;
import frc.robot.subsystems.SwerveDrive;
import frc.robot.subsystems.Wrist;
import frc.robot.RobotContainer;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.XboxController.Axis;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.SwerveModule;



public class ChaseTag extends Command {
    private PIDController pidController;
    private static NetworkTable table;
    private SwerveDrive swerve;
    double tx = table.getEntry("tx").getDouble(0);
    
    
    public ChaseTag() {
        //ALIGN APRILTAG TO CENTER OF VISION (tx == 0???)
        SmartDashboard.putBoolean("target", Limelight.canSeeTarget());
        
        pidController = new PIDController(11, 0, 0.01);
        pidController.reset();
    } 

  @Override
  public void initialize() {}

  @Override
  public void execute() {
        new RotateToAngle(tx, swerve);
  }
}
//SmartDashboard.putData("target",canSeeTarget());    
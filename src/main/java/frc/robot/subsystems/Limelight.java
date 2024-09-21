// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.LimelightHelpers;
import frc.robot.Constants.LimelightConstants;



public class Limelight extends SubsystemBase {
  

  private String limelightName;
  private static NetworkTable table;
  
  public Limelight(String limelightName){
    this.limelightName = limelightName;
  }
  double tx = table.getEntry("tx").getDouble(0);
  }


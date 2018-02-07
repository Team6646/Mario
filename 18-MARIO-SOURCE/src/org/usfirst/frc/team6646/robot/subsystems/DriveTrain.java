package org.usfirst.frc.team6646.robot.subsystems;

import org.usfirst.frc.team6646.robot.RobotMap;
import org.usfirst.frc.team6646.robot.commands.ArcadeDrive;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 *
 */
public class DriveTrain extends Subsystem {
	
	// Initialize Drive Talons
	WPI_TalonSRX driveTalonLF, driveTalonLB, driveTalonRB, driveTalonRF;
	
	// Initialize DifferentialDrive Object
	DifferentialDrive drive;
	
	// Initialize Speed Controller Group objects for both sides of the drivetrain
	SpeedControllerGroup leftMotors, rightMotors;

    public DriveTrain() {
    	
    	// Assign talon objects to variables
    	driveTalonLF = new WPI_TalonSRX(RobotMap.driveTalonLF);
		driveTalonLB = new WPI_TalonSRX(RobotMap.driveTalonLB);
		driveTalonRB = new WPI_TalonSRX(RobotMap.driveTalonRB);
		driveTalonRF = new WPI_TalonSRX(RobotMap.driveTalonRF);
		
		// Create SpeedControllerGroup objects
		leftMotors = new SpeedControllerGroup(driveTalonLF, driveTalonLB);
		rightMotors = new SpeedControllerGroup(driveTalonRF, driveTalonRB);
		
		// Create DifferentialDrive object
		drive = new DifferentialDrive(leftMotors, rightMotors);
		
    }
    
    // Arcade Drive Function
    public void arcadeDrive(double x, double y) {
    	// Call ArcadeDrive Method
    	drive.arcadeDrive(x, y, true);
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new ArcadeDrive());
    }
}


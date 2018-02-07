package org.usfirst.frc.team6646.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import org.usfirst.frc.team6646.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 *	DuelTalons is a subsystem that consists of two TalonSRX motor controllers on the test board. 
 *	@author Evan Seils
 *
 */
public class DuelTalons extends Subsystem {
	
	// Initialize Test Board Talons
	
	WPI_TalonSRX driveTalonLF, driveTalonLB, driveTalonRB, driveTalonRF;
	
	public DuelTalons() {
		
		// Assign WPI_TalonSRX objects to each initialized variable
		driveTalonLF = new WPI_TalonSRX(RobotMap.driveTalonLF);
		driveTalonLB = new WPI_TalonSRX(RobotMap.driveTalonLB);
		driveTalonRB = new WPI_TalonSRX(RobotMap.driveTalonRB);
		driveTalonRF = new WPI_TalonSRX(RobotMap.driveTalonRF);
		
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    // Set Both Test Motors Forward
    public void fullForward() {
    	driveTalonLF.set(1);
    	driveTalonLB.set(1);
    	driveTalonRB.set(1);
    	driveTalonRF.set(1);
    }
    
    // Set Both Test Motors In Reverse
    public void fullReverse() {
    	driveTalonLF.set(-1);
    	driveTalonLB.set(-1);
    	driveTalonRB.set(-1);
    	driveTalonRF.set(-1);
    }
    
    public void alternateMotors(Boolean flipped) {
    	Integer defaultSpeed;
    	
    	// Flip Motor Inputs Based on Function Input
    	if(flipped == true) {
    		defaultSpeed = 1;
    	} else {
    		defaultSpeed = -1;
    	}
    	
    	// Pass the input into the TalonSRX input function
    	driveTalonLF.set(defaultSpeed);
    	driveTalonLB.set(defaultSpeed * -1);
    	driveTalonRB.set(defaultSpeed);
		driveTalonRF.set(defaultSpeed * -1);
    	
    }
    
    public void stopMotors() {
    	driveTalonLF.set(0);
    	driveTalonLB.set(0);
    	driveTalonRB.set(0);
    	driveTalonRF.set(0);
    	
    }
}


package org.usfirst.frc.team6646.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team6646.robot.Robot;

/**
 *
 *	This command exists to test all of the motors of the drive train for proper functionlity
 *	@author Evan Seils
 *
 */
public class testMotors extends Command {
	
	Timer testTimer = new Timer();
	
    public testMotors() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	super("TestMotor");
    	requires(Robot.kDuelTalons);
    }

    // Called just before this runs the first time
    protected void initialize() {
    	testTimer.reset();
    	testTimer.start();
    	Robot.kDuelTalons.alternateMotors(true);
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if(testTimer.get() <= 10) {
    		return false;
    	} else {
    		return true;
    	}
    }

    // Called once after is Finished returns true ~ Marcelo Torre ;) xD Autum Goodman waz here ;P
    protected void end() {
    	Robot.kDuelTalons.stopMotors();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}

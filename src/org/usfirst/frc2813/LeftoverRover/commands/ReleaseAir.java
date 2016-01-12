package org.usfirst.frc2813.LeftoverRover.commands;

import org.usfirst.frc2813.LeftoverRover.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class ReleaseAir extends Command {

	// Normal Java constructor
	// This is a good place to put the requires method
	public ReleaseAir() {
		requires(Robot.shirtLauncher);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		Robot.shirtLauncher.toggleSolenoid();
		Timer.delay(5);
	}

	// This code is basically run after each iteration of execute(), if you want a command
	// to run once and only once, you put return true;
	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false; // Returns false so it is run continuously
	}

	// Called once after isFinished returns true
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}

}

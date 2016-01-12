package org.usfirst.frc2813.LeftoverRover.auto;

import org.usfirst.frc2813.LeftoverRover.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class LineUpShotXY extends Command {
	
	private int outerWorkPosition; // From 2 to 5, 5 being rightmost outer work

	protected void initialize() {
		requires(Robot.nav6);
		requires(Robot.pIDDrive);
	}

	protected void execute() {
		
	}

	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

	protected void end() {
		// TODO Auto-generated method stub

	}

	protected void interrupted() {
		// TODO Auto-generated method stub

	}

}

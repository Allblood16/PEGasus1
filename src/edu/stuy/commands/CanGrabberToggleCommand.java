package edu.stuy.commands;

import edu.stuy.Robot;
import edu.wpi.first.wpilibj.command.Command;

/**
 * Changes the position of the can grabber to the position opposite of
 * the current position
 */
public class CanGrabberToggleCommand extends Command {

    public CanGrabberToggleCommand() {
        requires(Robot.canner);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        Robot.canner.toggle();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}

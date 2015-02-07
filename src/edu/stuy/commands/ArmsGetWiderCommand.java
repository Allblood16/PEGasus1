package edu.stuy.commands;

import edu.stuy.Robot;
import edu.stuy.util.ArmsPosition;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ArmsGetWiderCommand extends Command {

    public ArmsGetWiderCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(Robot.arms);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        ArmsPosition.prevPosition(Robot.arms.getCurrentPosition()).goToPosition();
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

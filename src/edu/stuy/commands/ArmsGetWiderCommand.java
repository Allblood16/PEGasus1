package edu.stuy.commands;

import edu.stuy.Robot;
import edu.stuy.util.ArmsPosition;
import edu.wpi.first.wpilibj.command.Command;

/**
 * Changes the position of the arms to the next widest position
 */
public class ArmsGetWiderCommand extends Command {

    public ArmsGetWiderCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(Robot.arms);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        ArmsPosition nextPosition = ArmsPosition.widerPosition(Robot.arms.getCurrentPosition());
        nextPosition.goToPosition();
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

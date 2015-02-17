package edu.stuy.commands.auton;

import static edu.stuy.RobotMap.AUTON_DRIVE_FORWARD_DRIVER_SIDE_INCHES;
import static edu.stuy.RobotMap.AUTON_DRIVE_FORWARD_DRIVER_SIDE_TIMEOUT;
import edu.stuy.commands.ArmsSetReleaseCommand;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutonOneSetPushForwardCommand extends CommandGroup {

    public  AutonOneSetPushForwardCommand() {
        addSequential(new ArmsSetReleaseCommand());
        addSequential(new AutonDriveForwardInchesCommand(AUTON_DRIVE_FORWARD_DRIVER_SIDE_INCHES, AUTON_DRIVE_FORWARD_DRIVER_SIDE_TIMEOUT));
    }
}

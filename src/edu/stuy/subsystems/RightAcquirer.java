package edu.stuy.subsystems;

import static edu.stuy.RobotMap.ACQUIRER_RIGHT_ROLLER_ID;
import edu.stuy.commands.AcquirerRightStopCommand;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class RightAcquirer extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    private CANTalon rightRoller;

    public RightAcquirer() {
        rightRoller = new CANTalon(ACQUIRER_RIGHT_ROLLER_ID);
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        setDefaultCommand(new AcquirerRightStopCommand());
    }

    public void acquire() {
        rightRoller.set(1.0);
    }

    public void stop() {
        rightRoller.set(0.0);
    }

    public void release() {
        rightRoller.set(-1.0);
    }

}

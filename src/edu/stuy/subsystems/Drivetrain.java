package edu.stuy.subsystems;

import static edu.stuy.RobotMap.DRIVETRAIN_ENCODER_INCHES_PER_PULSE;
import static edu.stuy.RobotMap.DRIVETRAIN_ENCODER_LEFT_CHANNEL_A;
import static edu.stuy.RobotMap.DRIVETRAIN_ENCODER_LEFT_CHANNEL_B;
import static edu.stuy.RobotMap.DRIVETRAIN_ENCODER_RIGHT_CHANNEL_A;
import static edu.stuy.RobotMap.DRIVETRAIN_ENCODER_RIGHT_CHANNEL_B;
import static edu.stuy.RobotMap.DRIVETRAIN_GYRO_CHANNEL;
import static edu.stuy.RobotMap.DRIVE_FRONT_LEFT_ID;
import static edu.stuy.RobotMap.DRIVE_FRONT_RIGHT_ID;
import static edu.stuy.RobotMap.DRIVE_REAR_LEFT_ID;
import static edu.stuy.RobotMap.DRIVE_REAR_RIGHT_ID;

import com.ctre.CANTalon;

import edu.stuy.commands.DrivetrainTankDriveCommand;
import edu.stuy.util.StuyGyro;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Drivetrain controls the drivetrain on the robot
 * Uses ramping
 * Has two speed modes, regular and slow mode
 */

public class Drivetrain extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    private CANTalon frontLeftMotor;
    private CANTalon rearLeftMotor;
    private CANTalon frontRightMotor;
    private CANTalon rearRightMotor;
    private RobotDrive robotDrive;
    private Encoder leftEncoder;
    private Encoder rightEncoder;
    private StuyGyro gyro;
    private boolean speedUp;
    private boolean overridden;

    public Drivetrain() {
        frontLeftMotor = new CANTalon(DRIVE_FRONT_LEFT_ID);
        rearLeftMotor = new CANTalon(DRIVE_REAR_LEFT_ID);
        frontRightMotor = new CANTalon(DRIVE_FRONT_RIGHT_ID);
        rearRightMotor = new CANTalon(DRIVE_REAR_RIGHT_ID);
        robotDrive = new RobotDrive(
                frontLeftMotor,
                rearLeftMotor,
                frontRightMotor,
                rearRightMotor);

        leftEncoder = new Encoder(DRIVETRAIN_ENCODER_LEFT_CHANNEL_A, DRIVETRAIN_ENCODER_LEFT_CHANNEL_B, true, EncodingType.k2X);
        leftEncoder.setDistancePerPulse(DRIVETRAIN_ENCODER_INCHES_PER_PULSE);
        rightEncoder = new Encoder(DRIVETRAIN_ENCODER_RIGHT_CHANNEL_A, DRIVETRAIN_ENCODER_RIGHT_CHANNEL_B, false, EncodingType.k2X);
        rightEncoder.setDistancePerPulse(DRIVETRAIN_ENCODER_INCHES_PER_PULSE);

        gyro = new StuyGyro(DRIVETRAIN_GYRO_CHANNEL);
        gyro.setDeadband(0.005);
        speedUp = true;
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        setDefaultCommand(new DrivetrainTankDriveCommand());
    }

    public void tankDrive(double leftSpeed, double rightSpeed) {
        robotDrive.tankDrive(leftSpeed, rightSpeed);
    }

    //For PID only:
    public void arcadeDrive(double moveValue, double rotateValue, boolean squaredInput) {
        robotDrive.arcadeDrive(moveValue, rotateValue, squaredInput);
    }

    public void setBrakeMode(boolean on) {
        frontLeftMotor.enableBrakeMode(on);
        rearLeftMotor.enableBrakeMode(on);
        frontRightMotor.enableBrakeMode(on);
        rearRightMotor.enableBrakeMode(on);
    }

    public void resetEncoders() {
        leftEncoder.reset();
        rightEncoder.reset();
    }

    public void resetGyro() {
        gyro.reset();
    }

    public void setSpeedUp(boolean b) {
        speedUp = b;
    }

    public void stop() {
        robotDrive.tankDrive(0, 0);
    }

    /**
     * Get the positive values of left and right encoder
     *
     * @return the larger of the absolute values of left and right encoder
     */
    public double getDistanceAbsolute() {
        return Math.max(Math.abs(getLeftEncoder()), Math.abs(getRightEncoder()));
    }

    public double getLeftEncoder() {
        return leftEncoder.getDistance();
    }

    public double getRightEncoder() {
        return rightEncoder.getDistance();
    }

    public double getGyroAngle() {
        return gyro.getAngle();
    }

    public double getLeftVoltage() {
        return frontLeftMotor.getOutputVoltage() / 12;
    }

    public double getRightVoltage() {
        return -frontRightMotor.getOutputVoltage() / 12;
    }

    public boolean isSpeedUp() {
        return speedUp;
    }

    /**
     * Sets the override for ramping
     * @param on Whether or not ramping should be overridden.
     */
    
    public void setOverridden(boolean on) {
        overridden = on;
    }

    public boolean isOverridden() {
        return overridden;
    }

}
package org.usfirst.frc.team3546.robot.subsystems;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;
import org.usfirst.frc.team3546.robot.RobotMap;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveTrain extends Subsystem {
	private final RobotDrive driveTrainMotors = RobotMap.driveTrainMotors;

	public static boolean drivetraininvert = false;

	public void invertDriveTrain(){

		if(drivetraininvert == true){
			drivetraininvert = false;
		}else{
			drivetraininvert = true;
		}
	}

	public void ForwardDrive(){
		drivetraininvert = false;
	}

	public void ReverseDrive(){
		drivetraininvert = true;
	}

	protected void initDefaultCommand() {}

	//public void stop() {
		//driveTrainMotors.tankDrive(0, 0);
	//}

	public void setMotorOutputs(double motorleft, double motorright) {
		driveTrainMotors.tankDrive(motorleft, motorright);
	}

	public void setMotorOutputs(Joystick leftJoystick, Joystick rightJoystick) {

		if(drivetraininvert == false) {
			driveTrainMotors.tankDrive(leftJoystick, rightJoystick);
		}
		else{
			driveTrainMotors.tankDrive(-rightJoystick.getAxis(Joystick.AxisType.kY), -leftJoystick.getAxis(Joystick.AxisType.kY));
		}
	}

	//BEGINNING OF ANDREWS CODE THAT IS REQUIRED FOR DRIVE STRAIGHT AND DRIVE AT ANGLE ---->

	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

	// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
	//private final Encoder rightDrivetrainEncoder = RobotMap.drivetrainRightDrivetrainEncoder;
	//private final Encoder leftDrivetrainEncoder = RobotMap.drivetrainLeftDrivetrainEncoder;
	private final RobotDrive drivetrainMotors = RobotMap.driveTrainMotors;

	// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS


	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	//public void initDefaultCommand() {
		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND


		// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
		//setDefaultCommand(new Drive());



	public void takeInputs(Joystick stick1, Joystick stick2){drivetrainMotors.tankDrive(stick1, stick2);
	}

	public void takeInputs(double left, double right){drivetrainMotors.tankDrive(left, right);
	}

	public void takeRotateInput(double gas, double rotate_rate){
		drivetrainMotors.mecanumDrive_Cartesian(0, rotate_rate, -gas, 0);
	}

	public void stop() {drivetrainMotors.drive(0, 0);
	}
}
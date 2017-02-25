package org.usfirst.frc.team3546.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import org.usfirst.frc.team3546.robot.commands.*;

/**
 * Created by User on 2/18/2017.
 */
public class DriveForwardAt60 extends CommandGroup{
    public DriveForwardAt60(){
        //Drive Straight Power must be at 70%
        addSequential(new DriveTrainHighGear());
        addSequential(new DriveStraight(2.05, false));
        addSequential(new DriveAtAngle(-120, .25, 1.85));
        addSequential(new WaitCommand(.5));
        addSequential(new SetGearRelease());
        addSequential(new WaitCommand(.5));
        addSequential(new DriveStraight(1, true));

    }
}

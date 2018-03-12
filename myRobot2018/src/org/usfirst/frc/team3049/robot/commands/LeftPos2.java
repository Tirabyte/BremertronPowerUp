package org.usfirst.frc.team3049.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

import org.usfirst.frc.team3049.robot.subsystems.Drivetrain;
import org.usfirst.frc.team3049.robot.Robot;
/**
 *
 */
public class LeftPos2 extends CommandGroup {

	/**
	 * Auto Command going for the Left switch in start Position 2 (Middle)
	 */
    public LeftPos2() {
    	
    	addSequential(new GripperControl(1));
    	addSequential(new SetElevatorHeight(2));
    	addSequential(new GyroDriveStraight(1.0, 0.5)); //placeholder Distance Needed: 52"
    	addSequential(new GyroTurnLeft(90));
    	addSequential(new GyroDriveStraight(2.0, 0.5)); //placeholder Distance Needed: 63.94"
    	addSequential(new GyroTurnRight(90));
    	addSequential(new GyroDriveStraight(0.5, 0.5)); //placeholder Distance Needed: 53"
    	addSequential(new SetElevatorHeight(1));
    	addSequential(new GripperControl(3));

//    	addSequential(new GyroTurnLeft(90));
//    	addSequential(new EncoderDriveStraight(3.0));
//    	addSequential(new GyroTurnRight(90));
    	
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}

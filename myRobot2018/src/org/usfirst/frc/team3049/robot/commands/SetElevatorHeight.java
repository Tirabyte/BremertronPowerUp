package org.usfirst.frc.team3049.robot.commands;

import org.usfirst.frc.team3049.robot.Robot;
import org.usfirst.frc.team3049.robot.subsystems.Elevator;
import org.usfirst.frc.team3049.robot.subsystems.Gripper;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class SetElevatorHeight extends Command {
	private static double m_distance;
	private int m_setting;
	private static double m_speedUp = 0.1;//Change this number to change the rate of raising for set heights
	private static double m_speedDown = 0.1;//Change this number to change the rate of lowering for set heights

	private static Elevator m_elevator;
	
	/**
	 * Command that sets the elevator to a certain Position
	 * <h2>Height Settings:</h2>
	 * 
	 * <ul>
	 * 	<li>0 = Ground</li>
	 *  <li>1 = Exchange</li>
	 *  <li>2 = Portal</li>
	 *  <li>3 = Switch</li>
	 *  <li>4 = Scale</li>
	 *  <li>5 = Climb</li>
	 * </ul>
	 * @param setting Used to set value to desired height
	 */
    public SetElevatorHeight(int setting) { // 0 for Ground, 1 for Exchange, 2 for Portal, 3 for Switch, 4 for Scale, 5 for Climb
    	requires(Robot.elevator);
    	m_elevator = Robot.elevator;
    	m_setting = setting;
    	if (m_setting == 0){//m_distance numbers are PLACEHOLDERS remember to set them to actual values
    		m_distance = 1;
    	}else if (m_setting == 1){
    		m_distance = 18;
    	}else if (m_setting == 2){
    		m_distance = 36;
    	}else if (m_setting == 3){
    		m_distance = 54;
    	}else if (m_setting == 4){
    		m_distance = 72;
    	}else if (m_setting == 5){
    		m_distance = 90;
    	}
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() { 
    	if(Elevator.strPot.get() > m_distance){
    		m_elevator.lower(m_speedDown); 
    	}else if (Elevator.strPot.get() < m_distance){
    		m_elevator.raise(m_speedUp);
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if((Elevator.strPot.get()-0.1) <= m_distance && m_distance <= (Elevator.strPot.get()+0.1)){
        	return true;
        }else {
        	return false;
        }
    }

    // Called once after isFinished returns true
    protected void end() {
    	m_elevator.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	m_elevator.stop();
    }
}

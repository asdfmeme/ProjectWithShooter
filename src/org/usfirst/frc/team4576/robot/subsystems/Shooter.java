package org.usfirst.frc.team4576.robot.subsystems;


import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.FeedbackDevice;
import edu.wpi.first.wpilibj.CANTalon.StatusFrameRate;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.command.Subsystem;


public class Shooter extends PIDSubsystem {
		
	public Shooter() {
		
		shooterWheelR.changeControlMode(CANTalon.TalonControlMode.Follower);
		shooterWheelR.set(shooterWheelL.getDeviceID());
		shooterWheelR.reverseOutput(true);
		
		shooterElevL.changeControlMode(CANTalon.TalonControlMode.Follower);
		shooterElevL.set(shooterElevR.getDeviceID());
		shooterElevL.reverseOutput(true); 
		
		int absPos = shooterElevR.getPulseWidthPosition() & 0xFFF;  /* mask only 12 bits */
		shooterElevR.setEncPosition(absPos);
		shooterElevR.setFeedbackDevice(FeedbackDevice.QuadEncoder);
		shooterElevR.reverseSensor(false);
		shooterElevR.configEncoderCodesPerRev(4096);
		shooterElevR.configNominalOutputVoltage(+0f, -0f);
		shooterElevR.configPeakOutputVoltage(+0f, -0f);
		shooterElevR.setAllowableClosedLoopErr(0);
		shooterElevR.setProfile(0);
		shooterElevR.setF(0.0);
		shooterElevR.setP(0.1);
		shooterElevR.setI(0.0);
		shooterElevR.setD(0.0);

	}
	
	CANTalon shooterElevL = new CANTalon(4);
	CANTalon shooterElevR = new CANTalon(5);
	CANTalon shooterWheelL = new CANTalon(6);
	CANTalon shooterWheelR = new CANTalon(7);
	
	
	
	//double currentAmps = shooterWheelR.getOutputCurrent();
	//DigitalInput d6 = new DigitalInput(8);
	//DigitalInput d7 = new DigitalInput(9);
	
	@Override
	protected void initDefaultCommand() {

	}

	public void up() {
		//Timer.delay(1);
		shooterElevR.set(-.5);
		

	}

	public void down() {
		shooterElevR.set(.5);
		
	}
	public void in(){
		shooterWheelL.set(-.5);
				
		
	}
	
	public void out(){
		shooterWheelL.set(.5);
				
	} 

	public void stop() {
		shooterElevR.set(0);
		shooterWheelL.set(0);
		
	}
	
	
	public void gamePadControl(Joystick stick)
	{
		
		//System.out.println("gamepad control");
		//System.out.println(stick.getRawAxis(3) +  " " + stick.getRawAxis(2));
			if(stick.getRawAxis(3) - stick.getRawAxis(2) < 0 && stick.getRawAxis(3) - stick.getRawAxis(2) > -0.1)
			{
				shooterElevR.set(0);
				//shooterElevL.set(0);
				return;
			}
		
		
		
			if(stick.getRawAxis(3) - stick.getRawAxis(2) > 0 && stick.getRawAxis(3) - stick.getRawAxis(2) < 0.1)
			{
				shooterElevR.set(0);
				//shooterElevL.set(0);
				return;
			}
		
		
		shooterElevR.set(stick.getRawAxis(3) - stick.getRawAxis(2));
		//shooterElevL.set(stick.getRawAxis(3) - stick.getRawAxis(2));
	}

	@Override
	protected double returnPIDInput() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	protected void usePIDOutput(double output) {
		// TODO Auto-generated method stub
		
	}

	

	}
	


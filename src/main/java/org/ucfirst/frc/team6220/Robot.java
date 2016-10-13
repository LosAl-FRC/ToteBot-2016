package org.ucfirst.frc.team6220;

import edu.wpi.first.wpilibj.*;

/**
 * Created by CGale9024 on 10/12/2016.
 */
public class Robot extends IterativeRobot {

    //Defines the variables as members of our Robot class
    RobotDrive drive; //pins 0,1,2,3
    Joystick joystick;
    Servo steering; //channel 4
    int autoLoopCounter;

    //Initializes the variables in the robotInit method, this method is called when the robot is initializing
    public void robotInit() {
        this.drive = new RobotDrive(0,1,2,3);
        this.joystick = new Joystick(1);
        this.steering = new Servo(4);
    }

    public void operatorControl() {
        //int reverse = 1;
        while(isOperatorControl() && isEnabled()) {
            //http://team358.org/files/programming/ControlSystem2015-2019/images/XBoxControlMapping.jpg
            steering.setAngle((joystick.getRawAxis(0) + 1) / 2);
            double movement = joystick.getRawAxis(3) - joystick.getRawAxis(2);
            drive.drive(movement, 0);
            Timer.delay(0.005);
        }
    }

}

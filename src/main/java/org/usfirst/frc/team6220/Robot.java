package org.usfirst.frc.team6220;

import edu.wpi.first.wpilibj.*;

/**
 * @author Ktar5 (Carter Gale)
 * @author RolyPoly (Will Dang)
 * @author alew2161 (Alexander Lew)
 *
 *         Creation date: 10/13/16
 */
public class Robot extends SampleRobot {

    //Defines the variables as members of our Robot class
    RobotDrive drive; //pins 0,1,2,3
    Joystick joystick;
    Servo steering; //channel 4

    //Initializes the variables in the robotInit method, this method is called when the robot is initializing.
    public void robotInit() {
        this.drive = new RobotDrive(0, 1, 2, 3);
        this.joystick = new Joystick(1);
        this.steering = new Servo(4);
    }

    public void operatorControl() {
        //int reverse = 1;
        while (isOperatorControl() && isEnabled()) {
            //http://team358.org/files/programming/ControlSystem2015-2019/images/XBoxControlMapping.jpg
            steering.setAngle((joystick.getRawAxis(0) + 1) / 2);
            double movement = joystick.getRawAxis(3) - joystick.getRawAxis(2);
            drive.drive(movement, 0);
            Timer.delay(0.005);
        }
    }

}


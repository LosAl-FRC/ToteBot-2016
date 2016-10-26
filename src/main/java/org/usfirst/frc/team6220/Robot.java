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
        System.out.println("Robot has started");
        this.drive = new RobotDrive(0, 1, 2, 3);
        this.joystick = new Joystick(0);
        this.steering = new Servo(4);
    }

    public void operatorControl() {
        //int reverse = 1;
        int i = 0;
        while (isOperatorControl() && isEnabled()) {
            //http://team358.org/files/programming/ControlSystem2015-2019/images/XBoxControlMapping.jpg
            double angle = (joystick.getRawAxis(0) + 1) / 2;
            if(angle > .48 && angle < .51){
                angle = .5;
            }
            angle *= 180;
            //Fun things v
            //angle = Math.pow(angle, joystick.getRawAxis(3) - joystick.getRawAxis(2));
            steering.setAngle(angle);
            double movement = joystick.getRawAxis(3) - joystick.getRawAxis(2);
            drive.drive(movement, 0);
            Timer.delay(0.005);
            if(i % 50 == 0){
                i = 0;
                System.out.println("Movement: " + movement + "\nAngle: " + angle + "\n");
            }
            i++;
        }
    }

}


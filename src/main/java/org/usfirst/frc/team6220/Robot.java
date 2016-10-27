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

    private RobotDrive drive; //pins 0,1,2,3
    private Joystick joystick; //port bottom right on Carter's laptop
    private Servo steering; //pin 4

    //Called when the robot is initialized
    public void robotInit() {
        System.out.println("Robot has started");
        this.drive = new RobotDrive(0, 1, 2, 3);
        this.joystick = new Joystick(0);
        this.steering = new Servo(4);
    }

    //http://team358.org/files/programming/ControlSystem2015-2019/images/XBoxControlMapping.jpg
    public void operatorControl() {
        int i = 0;
        while (isOperatorControl() && isEnabled()) {
            double angle = (joystick.getRawAxis(0) + 1) / 2;
            if(angle > .48 && angle < .51){
                angle = .5;
            }
            angle *= 15;
            //angle = Math.pow(angle, joystick.getRawAxis(3) - joystick.getRawAxis(2));
            steering.setAngle(angle);
            double movement = joystick.getRawAxis(3) - joystick.getRawAxis(2);
            drive.drive(movement, 0);
            /*
            drive.setInvertedMotor(RobotDrive.MotorType.kFrontLeft, true);
            drive.setInvertedMotor(RobotDrive.MotorType.kFrontRight, true);
            */
            Timer.delay(0.01);
            if(i % 50 == 0){
                i = 0;
                System.out.println("Movement: " + movement + "\nAngle: " + angle + "\n");
            }
            i++;
        }
    }


}


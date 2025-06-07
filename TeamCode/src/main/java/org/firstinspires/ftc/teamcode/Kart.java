package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.rev.RevBlinkinLedDriver;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public abstract class Kart implements KartConstants{

    public Servo steeringWheel;
    public ColorSensor colorSensor;
    public RevBlinkinLedDriver blinkin;
    private final double basePower, turnMultiplier;

    public Kart(HardwareMap hwMap, Telemetry telemetry, double basePower, double turnMultiplier) {

        steeringWheel = hwMap.get(Servo.class, "wheel");
        colorSensor = hwMap.get(ColorSensor.class, "colorSensor");
        blinkin = hwMap.get(RevBlinkinLedDriver.class, "blinkin");


        this.basePower = basePower;
        this.turnMultiplier = turnMultiplier;

    }

    public void driveTeleop(boolean forwardButton, boolean reverseButton, double strafe, double turn, boolean isOverrided, boolean forwardOverride, boolean reverseOverride, double strafeOverride, double turnOverride) {

        double powerReal;
        double turnReal;
        double strafeReal;

        if (isOverrided) {
            setMotorZeroPower(DcMotor.ZeroPowerBehavior.BRAKE);
            turnReal = turnOverride * turnMultiplier;
            strafeReal = strafeOverride;
            if (forwardOverride) powerReal = basePower; else if (reverseOverride) powerReal = -basePower; else powerReal = 0;

            blinkin.setPattern(RevBlinkinLedDriver.BlinkinPattern.STROBE_WHITE);
        } else {
            setMotorZeroPower(DcMotor.ZeroPowerBehavior.FLOAT);
            turnReal = turn * turnMultiplier;
            strafeReal = strafe;
            if (forwardButton) powerReal = basePower; else if (reverseButton) powerReal = -basePower; else powerReal = 0;

            colorLights();
        }

        drive(powerReal, strafeReal, turnReal);
        steer(turn);

    }

    public abstract void drive(double power, double strafe, double turn);

    public abstract void setMotorZeroPower(DcMotor.ZeroPowerBehavior mode);

    public void steer(double turn){
        steeringWheel.setPosition(0.5 - 0.5 * turn);
    }

    public enum Color{
        NEUTRAL,
        BLUE,
        RED,
        GREEN,
        YELLOW
    }

    public Color getColor() {

        int sensorRed = colorSensor.red() / 1000 * 255;
        int sensorGreen = colorSensor.green() / 1000 * 255;
        int sensorBlue = colorSensor.blue() / 1000 * 255;
        float[] sensorHSV = {0, 0, (float) 0.5}; //middle grey by default

        android.graphics.Color.RGBToHSV(sensorRed, sensorGreen, sensorBlue, sensorHSV);

        if (sensorHSV[2] < 0.4) { return Color.NEUTRAL; }

        if (sensorHSV[0] > redHueRange[0] && sensorHSV[0] < redHueRange[1]) { return Color.RED; }
        if (sensorHSV[0] > yellowHueRange[0] && sensorHSV[0] < yellowHueRange[1]) {return Color.YELLOW; }
        if (sensorHSV[0] > greenHueRange[0] && sensorHSV[0] < greenHueRange[1]) {return Color.GREEN; }
        if (sensorHSV[0] > blueHueRange[0] && sensorHSV[0] < blueHueRange[1]) {return Color.BLUE; }

        return Color.NEUTRAL;

    }

    public void colorLights(){
        if(getColor() == Color.NEUTRAL){
            blinkin.setPattern(RevBlinkinLedDriver.BlinkinPattern.GRAY);
        }
        if(getColor() == Color.RED){
            blinkin.setPattern(RevBlinkinLedDriver.BlinkinPattern.RED);
        }
        if(getColor() == Color.BLUE){
            blinkin.setPattern(RevBlinkinLedDriver.BlinkinPattern.BLUE);
        }
        if(getColor() == Color.GREEN){
            blinkin.setPattern(RevBlinkinLedDriver.BlinkinPattern.GREEN);
        }
        if(getColor() == Color.YELLOW){
            blinkin.setPattern(RevBlinkinLedDriver.BlinkinPattern.YELLOW);
        }

    }
}

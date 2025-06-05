package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.rev.RevBlinkinLedDriver;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public abstract class Kart {

    public Servo steeringWheel;
    public ColorSensor colorSensor;
    public RevBlinkinLedDriver blinkin;
    private final double basePower;
    int[][] redColorRange, greenColorRange, blueColorRange, yellowColorRange;

    public Kart(HardwareMap hwMap, Telemetry telemetry, double basePower, int[][] redColorRange, int[][] greenColorRange, int[][] blueColorRange, int[][] yellowColorRange) {

        steeringWheel = hwMap.get(Servo.class, "wheel");
        colorSensor = hwMap.get(ColorSensor.class, "colorSensor");
        blinkin = hwMap.get(RevBlinkinLedDriver.class, "blinkin");
        String currentOpMode = this.getClass().getSimpleName();
        String currentConfig = hwMap.getClass().toString();

        this.basePower = basePower;


        telemetry.addLine("Current OpMode is ");
        telemetry.addData("", currentOpMode);
        telemetry.addLine("Current Config is ");
        telemetry.addData("", currentConfig);


    }

    public void driveTeleop(boolean forwardButton, boolean reverseButton, double strafe, double turn, boolean isOverrided, boolean forwardOverride, boolean reverseOverride, double strafeOverride, double turnOverride) {

        double powerReal;
        double turnReal;
        double strafeReal;

        if (isOverrided) {
            turnReal = turnOverride;
            strafeReal = strafeOverride;
            if (forwardOverride) powerReal = basePower; else if (reverseOverride) powerReal = -basePower; else powerReal = 0;

            blinkin.setPattern(RevBlinkinLedDriver.BlinkinPattern.HOT_PINK);
        } else {
            turnReal = turn;
            strafeReal = strafe;
            if (forwardButton) powerReal = basePower; else if (reverseButton) powerReal = -basePower; else powerReal = 0;

            colorLights();
        }

        drive(powerReal, strafeOverride, turnReal);
        steer(turn);

    }

    public abstract void drive(double power, double strafe, double turn);

    public void steer(double turn){
        steeringWheel.setPosition(0.5 + 0.5 * turn);
    }

    public enum Color{
        NEUTRAL,
        BLUE,
        RED,
        GREEN,
        YELLOW
    }

//    public Color getColor(){
//        if(colorSensor.red() > colorSensor.blue() && colorSensor.red() > colorSensor.green() && colorSensor.red() > 225){
//            return Color.RED;
//        }
//        if((colorSensor.red() < colorSensor.blue() && colorSensor.blue() > colorSensor.green())&& colorSensor.blue() > 325){
//            return Color.BLUE;
//        }
//        if((colorSensor.green() > colorSensor.blue() && colorSensor.red() < colorSensor.green())&& colorSensor.green() > 250 && colorSensor.red() < colorSensor.blue() && colorSensor.green() < 500){
//            return Color.GREEN;
//        }
//        if((colorSensor.green() > colorSensor.blue() && colorSensor.red() > colorSensor.blue())&& colorSensor.red() > 300 && colorSensor.green() > 500){
//            return Color.YELLOW;
//        }
//        return Color.GREY;
//    }

    public boolean colorWithinRange( int[] color, int[][] colorRange) {

        boolean redValuesWithinRange;
        boolean greenValuesWithinRange;
        boolean blueValuesWithinRange;

        redValuesWithinRange = color[0] >= colorRange[0][0] && color[0] <= colorRange[1][0];
        greenValuesWithinRange = color[1] >= colorRange[0][1] && color[1] <= colorRange[1][1];
        blueValuesWithinRange = color[2] >= colorRange[0][2] && color[2] <= colorRange[1][2];


        return redValuesWithinRange && greenValuesWithinRange && blueValuesWithinRange;
    }

    public Color getColor () {
        int[] sensorColor = new int[]{colorSensor.red(), colorSensor.green(), colorSensor.blue()};
        if (colorWithinRange(sensorColor, redColorRange)) {
            return Color.RED;
        }
        if (colorWithinRange(sensorColor, greenColorRange)) {
            return Color.GREEN;
        }
        if (colorWithinRange(sensorColor, yellowColorRange)) {
            return Color.YELLOW;
        }
        if (colorWithinRange(sensorColor, blueColorRange)) {
            return Color.BLUE;
        }
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

package org.firstinspires.ftc.teamcode.karts;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.Kart;

public class MarioKart extends Kart {

    static double basePower = 0.6;

    static int[][] redColorRange = {
            {800, 0, 0}, //minimum
            {1000, 0, 0} //maximum
    };

    static int[][] greenColorRange = {
            {800, 0, 0}, //minimum
            {1000, 0, 0} //maximum
    };

    static int[][] blueColorRange = {
            {800, 0, 0}, //minimum
            {1000, 0, 0} //maximum
    };

    static int[][] yellowColorRange = {
            {800, 0, 0}, //minimum
            {1000, 0, 0} //maximum
    };

    public MarioKart(HardwareMap hwMap, Telemetry telemetry) {

        super(hwMap, telemetry, basePower, redColorRange, greenColorRange, blueColorRange, yellowColorRange);


    }

    @Override
    public void drive(double power, double strafe, double turn) {
        //TODO: ADD DRIVE CODE
    }
}

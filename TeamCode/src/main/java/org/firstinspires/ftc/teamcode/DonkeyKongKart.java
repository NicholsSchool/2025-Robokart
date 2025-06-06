package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class DonkeyKongKart extends Kart {

    public DcMotorEx rMotor, lMotor;

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

    public DonkeyKongKart(HardwareMap hwMap, Telemetry telemetry) {

        super(hwMap, telemetry, basePower, redColorRange, greenColorRange, blueColorRange, yellowColorRange);
        rMotor = hwMap.get(DcMotorEx.class, "rMotor");
        lMotor = hwMap.get(DcMotorEx.class, "lMotor");


        rMotor.setDirection(DcMotorEx.Direction.FORWARD);
        lMotor.setDirection(DcMotorEx.Direction.FORWARD);

    }

    @Override
    public void drive(double power, double strafe, double turn) {
            lMotor.setPower(power - 0.4 * turn);
            rMotor.setPower(-power - 0.4 * turn);
    }
}

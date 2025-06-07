package org.firstinspires.ftc.teamcode.karts;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.Kart;

public class LuigiKart extends Kart {

    static double basePower = 0.6;
    static double turnMultiplier = 0.4;

    DcMotorEx backLeft, backRight, frontLeft, frontRight, hMotor;

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

    public LuigiKart(HardwareMap hwMap, Telemetry telemetry) {

        super(hwMap, telemetry, basePower, turnMultiplier, redColorRange, greenColorRange, blueColorRange, yellowColorRange);
        frontLeft = hwMap.get(DcMotorEx.class, "frontLeft");
        frontRight = hwMap.get(DcMotorEx.class, "frontRight");
        backLeft = hwMap.get(DcMotorEx.class, "backLeft");
        backRight = hwMap.get(DcMotorEx.class, "backRight");
        hMotor = hwMap.get(DcMotorEx.class, "hMotor");

    }

    @Override
    public void drive(double power, double strafe, double turn) {

        frontLeft.setPower(power - turn);
        frontRight.setPower(power + turn);
        backRight.setPower(power + turn);
        backLeft.setPower(power - turn);
        hMotor.setPower(strafe);

    }

    @Override
    public void setMotorZeroPower(DcMotor.ZeroPowerBehavior mode) {

        frontLeft.setZeroPowerBehavior(mode);
        frontRight.setZeroPowerBehavior(mode);
        backLeft.setZeroPowerBehavior(mode);
        backRight.setZeroPowerBehavior(mode);
        hMotor.setZeroPowerBehavior(mode);

    }
}

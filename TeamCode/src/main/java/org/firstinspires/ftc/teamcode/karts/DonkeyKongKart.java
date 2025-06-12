package org.firstinspires.ftc.teamcode.karts;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.Kart;

public class DonkeyKongKart extends Kart {

    public DcMotorEx rMotor, lMotor;

    static double basePower = 0.6;
    static double turnMultiplier = 0.5;

    public DonkeyKongKart(HardwareMap hwMap, Telemetry telemetry) {

        super(hwMap, telemetry, basePower, turnMultiplier);
        rMotor = hwMap.get(DcMotorEx.class, "rMotor");
        lMotor = hwMap.get(DcMotorEx.class, "lMotor");

    }

    @Override
    public void drive(double power, double strafe, double turn) {
        lMotor.setPower(power - turn);
        rMotor.setPower(-power - turn);
    }

    @Override
    public void setMotorZeroPower(DcMotor.ZeroPowerBehavior mode) {
        lMotor.setZeroPowerBehavior(mode);
        rMotor.setZeroPowerBehavior(mode);
    }
}

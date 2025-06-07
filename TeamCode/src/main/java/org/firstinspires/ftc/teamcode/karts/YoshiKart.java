package org.firstinspires.ftc.teamcode.karts;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.Kart;

public class YoshiKart extends Kart {

    public DcMotorEx rMotor, lMotor, fMotor;

    static double basePower = 0.6;
    static double turnMultiplier = 0.4;

    public YoshiKart(HardwareMap hwMap, Telemetry telemetry) {

        super(hwMap, telemetry, basePower, turnMultiplier);
        rMotor = hwMap.get(DcMotorEx.class, "rMotor");
        lMotor = hwMap.get(DcMotorEx.class, "lMotor");
        fMotor = hwMap.get(DcMotorEx.class, "fMotor");

    }

    @Override
    public void drive(double power, double strafe, double turn) {
        lMotor.setPower(power * Math.sqrt(3) / 2 - strafe / 2 - turn);
        rMotor.setPower(-power * Math.sqrt(3) / 2 + strafe / 2 - turn);
        fMotor.setPower(strafe - turn);
    }

    @Override
    public void setMotorZeroPower(DcMotor.ZeroPowerBehavior mode) {
        lMotor.setZeroPowerBehavior(mode);
        rMotor.setZeroPowerBehavior(mode);
        fMotor.setZeroPowerBehavior(mode);
    }
}

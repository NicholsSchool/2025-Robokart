package org.firstinspires.ftc.teamcode.karts;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.Kart;

public class PeachKart extends Kart {

    public DcMotorEx rMotor, lMotor, fMotor, bMotor;

    static double basePower = 0.6;
    static double turnMultiplier = 0.4;

    public PeachKart(HardwareMap hwMap, Telemetry telemetry) {

        super(hwMap, telemetry, basePower, turnMultiplier);
        rMotor = hwMap.get(DcMotorEx.class, "rMotor");
        lMotor = hwMap.get(DcMotorEx.class, "lMotor");
        fMotor = hwMap.get(DcMotorEx.class, "fMotor");
        bMotor = hwMap.get(DcMotorEx.class, "bMotor");

    }

    @Override
    public void drive(double power, double strafe, double turn) {
        lMotor.setPower(-power - turn);
        rMotor.setPower(power - turn);
        fMotor.setPower(-strafe - turn);
        bMotor.setPower(strafe - turn);
    }

    @Override
    public void setMotorZeroPower(DcMotor.ZeroPowerBehavior mode) {
        lMotor.setZeroPowerBehavior(mode);
        rMotor.setZeroPowerBehavior(mode);
        fMotor.setZeroPowerBehavior(mode);
        bMotor.setZeroPowerBehavior(mode);
    }
}

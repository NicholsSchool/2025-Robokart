package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * Kiwi Teleop Code
 */
@TeleOp(name="KartTeleop", group="Iterative Opmode")
public class KartTeleop extends OpMode
{
    DKKart DK;
    double power;
    /*
     * Code to run ONCE when the driver hits INIT
     */
    @Override
    public void init() {
        DK = new DKKart(hardwareMap, telemetry);


        // Tell the driver that initialization is complete.
        telemetry.addData("Status", "Initialized");
    }

    /*
     * Code to run REPEATEDLY after the driver hits INIT, but before they hit PLAY
     */
    @Override
    public void init_loop() {}

    /*
     * Code to run ONCE when the driver hits PLAY
     */
    @Override
    public void start() {
    }

    /*
     * Code to run REPEATEDLY after the driver hits PLAY but before they hit STOP
     */
    @Override
    public void loop(){
        DK.driveTeleop(gamepad1.b, gamepad1.a, 0.0, gamepad1.left_stick_x, gamepad2.right_bumper, gamepad2.b, gamepad2.a, 0.0, gamepad2.left_stick_x);
    }

    /*
     * Code to run ONCE after the driver hits STOP
     */
    @Override
    public void stop() {}
}

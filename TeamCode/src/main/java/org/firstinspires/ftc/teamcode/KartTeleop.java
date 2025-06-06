package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import java.io.IOException;
import java.util.Properties;


@TeleOp(name="KartTeleop", group="Iterative Opmode")
public class KartTeleop extends OpMode {
    Properties properties;
    Kart kart;
    /*
     * Code to run ONCE when the driver hits INIT
     */
    @Override
    public void init() {

        try {
            properties = new Properties();
            properties.load(hardwareMap.appContext.getAssets().open("KartConfig.properties"));
        } catch (IOException e) {
            throw new RuntimeException(
                    "Unable to load Kart Properties file. Ensure code was built using kart-specific " +
                            "Gradle tasks (e.x. gradlew[.bat] installMarioRelease). They can be found in the" +
                            "RoboKart task groups. You cannot build RoboKart code using just the play button " +
                            "in Android Studio.\n\n" +
                            "Full Stack Trace:\n\n" + e.getMessage());
        }

        String kartString = properties.getProperty("kartType");

        switch (kartString) {
            case "DonkeyKong":
                kart = new DonkeyKongKart(hardwareMap, telemetry);
                break;
            default:
                throw new RuntimeException("Illegal Kart Configuration: " + kartString);
        }

        telemetry.addData("Status", "Initialized with KartConfig " + kartString);
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
        kart.driveTeleop(gamepad1.b, gamepad1.a, 0.0, gamepad1.left_stick_x, gamepad2.right_bumper, gamepad2.b, gamepad2.a, 0.0, gamepad2.left_stick_x);
    }

    /*
     * Code to run ONCE after the driver hits STOP
     */
    @Override
    public void stop() {}
}

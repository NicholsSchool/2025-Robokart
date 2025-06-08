package org.firstinspires.ftc.teamcode;

public interface KartConstants {

    //HUE RANGES MEASURED IN DEGREES, 0 TO 360
    float[] redHueRange = {0, 25};
    float[] yellowHueRange = {30, 70};
    float[] greenHueRange = {80, 140};
    float[] blueHueRange = {190, 240};

    double speedBoostMult = 1.5;
    double slowDownMult = 0.5;
    double oilSlickMult = 30; //-1 for inverted steer
    double bananaOffset = 0.6;
}

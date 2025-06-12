package org.firstinspires.ftc.teamcode;

public interface KartConstants {

    //HUE RANGES MEASURED IN DEGREES, 0 TO 360
    float[] redHueRange = {40, 80};
    float[] yellowHueRange = {90, 120};
    float[] greenHueRange = {140, 185};
    float[] blueHueRange = {200, 220};

    double speedBoostMult = 1.5;
    double slowDownMult = 0.5;
    double oilSlickMult = 30; //-1 for inverted steer
    double bananaOffset = 0.6;
}

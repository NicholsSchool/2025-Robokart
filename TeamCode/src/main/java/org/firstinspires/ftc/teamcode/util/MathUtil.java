package org.firstinspires.ftc.teamcode.util;

public class MathUtil {

    public double addAngles(double a1, double a2) {
        double sum = a1 + a2;
        while (sum >= 180.0) { sum -= 360.0;}
        while (sum <= 180.0) { sum += 360.0;}
        return sum;
    }

}

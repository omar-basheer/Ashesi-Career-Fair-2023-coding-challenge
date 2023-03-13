import java.lang.Math;
public class CalcE_Distance {

    public static double findEucDistance(double x1, double y1, double x2, double y2){
        double e_dist, xpow, ypow;
        xpow = Math.pow((x2-x1),2);
        ypow = Math.pow((y2-y1),2);
        e_dist = Math.sqrt((xpow)+(ypow));
        return e_dist;
    }
}

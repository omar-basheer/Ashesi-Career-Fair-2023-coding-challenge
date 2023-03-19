import java.util.ArrayList;

public class FindSafePolygon {

    public static void findSafePolygon(ArrayList<double[]> points){
        double[][] biggest_triangle = FindSafeTriangle.findSafeTri(points);

    }
}

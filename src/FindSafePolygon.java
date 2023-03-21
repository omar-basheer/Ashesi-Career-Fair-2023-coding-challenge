import java.util.ArrayList;
import java.util.Arrays;

public class FindSafePolygon {

    // need all remaining unsafe points, that form triangles
    // ArrayList<double[]> unsafe_points = FindSafeTriangle.tri_points_list;
    public static void mergeShapes(ArrayList<double[]> triangle, ArrayList<double[]> polygon){
        double[] adj_point1 = new double[0];
        double[] adj_point2 = new double[0];

        for(int i=0; i<triangle.size(); i++){
            for (int j=0;j<polygon.size(); j++){
                if(triangle.get(i).equals(polygon.get(j)) && adj_point1.length == 0){
                    adj_point1 = polygon.get(j);
                }
                if(triangle.get(i).equals(polygon.get(j)) && triangle.get(i) != adj_point1 && adj_point1.length != 0 && adj_point2.length == 0){
                    adj_point2 = polygon.get(j);
                }
            }
        }
        System.out.println("triangle: " + FindSafeTriangle.listToString(triangle));
        System.out.println("polygon: " + FindSafeTriangle.listToString(polygon));
        System.out.println("adjacent point 1: " + Arrays.toString(adj_point1));
        System.out.println("adjacent point 2: " + Arrays.toString(adj_point2));
        System.out.println(" ");
    }

    public static void findSafePolygon(ArrayList<double[]> points){
        ArrayList<double[]> polygon = FindSafeTriangle.findSafeTri(points);
//        System.out.println(FindSafeTriangle.listToString(polygon));

        // create collection of all keys from triangles map
        Double[] keys = FindSafeTriangle.triangles.keySet().toArray(new Double[FindSafeTriangle.triangles.size()]);
        for(int i=0; i<keys.length; i++){
            System.out.println("triangle: "+ i);
            mergeShapes(FindSafeTriangle.triangles.get(keys[i]), polygon);
        }

    }

    public static void main(String[]args){

        double[] floatArr1 = new double[]{2.8,1.6};
        double[] floatArr2 = new double[]{0.5,0.5};
        double[] floatArr3 = new double[]{1,3.5};
        double[] floatArr4 = new double[]{3,4};
        double[] floatArr5 = new double[]{2,3};
        double[] floatArr6 = new double[]{3,0.5};

        ArrayList<double[]> test_array = new ArrayList<>();
        test_array.add(floatArr1);
        test_array.add(floatArr2);
        test_array.add(floatArr3);
        test_array.add(floatArr4);
        test_array.add(floatArr5);
        test_array.add(floatArr6);

        findSafePolygon(test_array);
    }
}

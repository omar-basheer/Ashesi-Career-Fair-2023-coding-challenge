import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
public class FindSafeTriangle {
    public static HashMap<Double, double[][]> triangles = new HashMap<>();

    public static void findSafeTri(ArrayList<double[]> points ){
        double max_area = 0;
        if(points.size() >= 3){
            double x1,y1,x2,y2,x3,y3;

            for (int i=0; i<points.size(); i++){
                for (int j=i+1; j<points.size(); j++){
                    for( int k=j+1; k<points.size(); k++){
                        x1 = points.get(i)[0];
                        y1 = points.get(i)[1];
                        System.out.println(x1 +","+ y1);
                        x2 = points.get(j)[0];
                        y2 = points.get(j)[1];
                        System.out.println(x2 +","+ y2);
                        x3 = points.get(k)[0];
                        y3 = points.get(k)[1];
                        System.out.println(x3 +","+ y3);

                        double curr_slope = CalcSlope.findSlope(x1,y1,x2,y2);
                        System.out.println("curr_slope:" + curr_slope);

                        double next_slope = CalcSlope.findSlope(x2,y2,x3,y3);
                        System.out.println("next_slope:" + next_slope);

                        if(curr_slope == next_slope){
                            System.out.println("slopes " + curr_slope + " and " + next_slope + " are equal, points are co-linear. \n points: (" + x1 + "," + y1 + ") ,(" + x2 + "," + y2 + ") ,(" + x3 + "," + y3 + ")");
                        }
                        else{
                            double[][] tri_points = new double[][]{points.get(i), points.get(j), points.get(k)};
                            double area = CalcArea.findArea(x1,y1,x2,y2,x3,y3);
                            triangles.putIfAbsent(area, tri_points);
                            System.out.println("inserted: " + area + "->" + Arrays.deepToString(tri_points));
                        }

                    }
                }
            }

            if(triangles.size() != 0){
                // get max area?
                Double[] tri_area = triangles.keySet().toArray(new Double[triangles.size()]);
                max_area = tri_area[0];
                for(int i=0; i<tri_area.length; i++){
                    if(tri_area[i] > max_area){
                        max_area = tri_area[i];
                    }
                }
                System.out.println(" ");
                System.out.println("biggest triangle points: " + Arrays.deepToString(triangles.get(max_area)));
                System.out.println("triangle area: " + max_area + " units squared");
            }
            else {
                System.out.println("no triangles formed, all points are co-linear");
            }
        }
        else{
            System.out.println("Error: at least 3 points are needed for program to run");
        }
//        return max_area;
    }

    public static void printMap(HashMap<Double, double[][]> thisMap){
        int i = 1;
        for(Double key : thisMap.keySet()){
            System.out.println(i + " " + key + " >> " + Arrays.deepToString(thisMap.get(key)));
            System.out.println(" ");
            i++;
        }
    }
}

import java.util.Collection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

public class FindSafeSurrounding {
    public static void findSafeSurr(ArrayList<double[]> points){
        double[] safe_point = points.get(0);
        double distance;

        HashMap<Double, double[][]> distances = new HashMap<>();

        for(int i=1; i<points.size(); i++){
            distance = CalcE_Distance.findEucDistance(safe_point[0], safe_point[1], points.get(i)[0], points.get(i)[1]);
            double[] point1 = new double[]{safe_point[0], safe_point[1]};
            double[] point2 = new double[]{points.get(i)[0], points.get(i)[1]};
            distances.putIfAbsent(distance, new double[][]{point1,point2});
        }

        Set<Double> keySet = distances.keySet();
        ArrayList<Double> all_distances = new ArrayList<>(keySet);
        double min_dist1 = all_distances.get(0);
        double min_dist2 = all_distances.get(0);
        int index1 = 0, index2 = 0;

        for(int i=0; i<all_distances.size(); i++){
            if(all_distances.get(i) < min_dist1){
                min_dist1 = all_distances.get(i);
                index1 = i;
            }
        }
        all_distances.remove(index1);

        for(int i=0; i<all_distances.size(); i++){
            if(all_distances.get(i) < min_dist2){
                min_dist2 = all_distances.get(i);
                index2 = i;
            }
        }

        // get the closest points
        double[] close_point1 = new double[]{distances.get(min_dist1)[1][0], distances.get(min_dist1)[1][1]};
        double[] close_point2 = new double[]{distances.get(min_dist2)[1][0], distances.get(min_dist2)[1][1]};
        System.out.println(Arrays.toString(close_point1));
        System.out.println(Arrays.toString(close_point2));

        // get other triangles that contain the close_points
        Collection<double[][]> values = FindSafeTriangle.triangles.values();
        ArrayList<double[][]> allValues = new ArrayList<>(values);

        for(int k=0; k<allValues.size(); k++){
            System.out.println("test");
            double[][] temp = allValues.get(k);
            for(int i=0; i<temp.length; i++){
                if((Arrays.equals(temp[0], close_point1) && Arrays.equals(temp[1], close_point2))){
                    double[] close_point3 = temp[2];
                    // calc area helper
                    CalcArea.findEarthQuakeArea(close_point1[0],close_point1[1],close_point2[0],close_point2[1],close_point3[0],close_point3[1],safe_point[0],safe_point[1]);
                }
                else if((Arrays.equals(temp[2], close_point2) && Arrays.equals(temp[1], close_point1))){
                    double[] close_point3 = temp[0];
                    // calc area helper
                    CalcArea.findEarthQuakeArea(close_point1[0],close_point1[1],close_point2[0],close_point2[1],close_point3[0],close_point3[1],safe_point[0],safe_point[1]);
                }
                else if((Arrays.equals(temp[0], close_point2) && Arrays.equals(temp[2], close_point1))){
                    double[] close_point3 = temp[1];
                    // calc area helper
                    CalcArea.findEarthQuakeArea(close_point1[0],close_point1[1],close_point2[0],close_point2[1],close_point3[0],close_point3[1],safe_point[0],safe_point[1]);
                }
                else if((Arrays.equals(temp[1], close_point2) && Arrays.equals(temp[2], close_point1))){
                    double[] close_point3 = temp[0];
                    // calc area helper
                    CalcArea.findEarthQuakeArea(close_point1[0],close_point1[1],close_point2[0],close_point2[1],close_point3[0],close_point3[1],safe_point[0],safe_point[1]);
                }
                else if((Arrays.equals(temp[2], close_point2) && Arrays.equals(temp[0], close_point1))){
                    double[] close_point3 = temp[1];
                    // calc area helper
                    CalcArea.findEarthQuakeArea(close_point1[0],close_point1[1],close_point2[0],close_point2[1],close_point3[0],close_point3[1],safe_point[0],safe_point[1]);
                }
                else if((Arrays.equals(temp[0], close_point2) && Arrays.equals(temp[1], close_point1))){
                    double[] close_point3 = temp[2];
                    // calc area helper
                    CalcArea.findEarthQuakeArea(close_point1[0],close_point1[1],close_point2[0],close_point2[1],close_point3[0],close_point3[1],safe_point[0],safe_point[1]);
                }
                else{
                    System.out.println("warning: person is not located within any safe triangle");
                }

            }
        }

    }

    public static void main(String[]args){


    }

}

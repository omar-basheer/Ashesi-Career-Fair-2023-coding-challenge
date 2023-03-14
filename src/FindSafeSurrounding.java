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
        double min_dist = all_distances.get(0);
        double[] close_point1 = new double[0];
        double[] close_point2 = new double[0];
        int min_index = 0;

        for(int i=0; i<2; i++){
            for(int j=0; j<all_distances.size(); j++){
                if(all_distances.get(j) < min_dist){
                    min_dist = all_distances.get(j);
                    min_index = j;
                }
            }
            if(i==1){
                close_point2 = new double[]{distances.get(min_dist)[1][0], distances.get(min_dist)[1][1]};
            }else {
                close_point1 = new double[]{distances.get(min_dist)[1][0], distances.get(min_dist)[1][1]};
                all_distances.remove(min_index);
                min_dist = all_distances.get(0);
            }
        }

        System.out.println(Arrays.toString(close_point1));
        System.out.println(Arrays.toString(close_point2));

        // get other triangles that contain the close_points
        Collection<double[][]> values = FindSafeTriangle.triangles.values();
        ArrayList<double[][]> allValues = new ArrayList<>(values);

        int count = 0;
        for(int k=0; k<allValues.size(); k++){
//            System.out.println("test");
            double[][] temp = allValues.get(k);
            double[] close_point3;
            for(int i=0; i<temp.length; i++){
                close_point3 = safe_point;
                if((Arrays.equals(temp[0], close_point1) && Arrays.equals(temp[1], close_point2))){
                    close_point3 = temp[2];
                }
                else if((Arrays.equals(temp[2], close_point2) && Arrays.equals(temp[1], close_point1))){
                    close_point3 = temp[0];
                }
                else if((Arrays.equals(temp[0], close_point2) && Arrays.equals(temp[2], close_point1))){
                    close_point3 = temp[1];
                }
                else if((Arrays.equals(temp[1], close_point2) && Arrays.equals(temp[2], close_point1))){
                    close_point3 = temp[0];
                }
                else if((Arrays.equals(temp[2], close_point2) && Arrays.equals(temp[0], close_point1))){
                    close_point3 = temp[1];
                }
                else if((Arrays.equals(temp[0], close_point2) && Arrays.equals(temp[1], close_point1))){
                    close_point3 = temp[2];
                }
                if(close_point3 != safe_point){
                    CalcArea.findEarthQuakeArea(close_point1[0],close_point1[1],close_point2[0],close_point2[1],close_point3[0],close_point3[1],safe_point[0],safe_point[1]);
                    count++;
                }
            }
        }
        if(count == 0){
            System.out.println("warning: person is not located within any safe triangle");
        }
    }
}

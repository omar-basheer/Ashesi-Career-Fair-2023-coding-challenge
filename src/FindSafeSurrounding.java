import java.util.Collection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

public class FindSafeSurrounding {
    public static void printPoints(double[] arr1, double[] arr2, double[] arr3){
        System.out.println("close point 1: " + Arrays.toString(arr1));
        System.out.println("close point 2: " + Arrays.toString(arr2));
        System.out.println("close point 3: " + Arrays.toString(arr3));
    }

    public static void findSafeSurr(ArrayList<double[]> points){
        System.out.println("finding safe surrounding : ");
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
        System.out.println("close point 1: " + Arrays.toString(close_point1));
        System.out.println("close point 2: " + Arrays.toString(close_point2) + "\n");

        // get other triangles that contain the close_points
        Collection<double[][]> values = FindSafeTriangle.triangles.values();
        ArrayList<double[][]> allValues = new ArrayList<>(values);

        int count = 0;
        for(int k=0; k<allValues.size(); k++){
            double[][] temp = allValues.get(k);
            double[] close_point3;
//            System.out.println("temp array: " + Arrays.deepToString(temp));
//            for(int i=0; i<temp.length; i++){
            close_point3 = safe_point;
            if((Arrays.equals(temp[0], close_point1) && Arrays.equals(temp[1], close_point2))){
                close_point3 = temp[2];
                printPoints(close_point1, close_point2, close_point3);
//                System.out.println("case 1 \n");
            }
            else if((Arrays.equals(temp[2], close_point2) && Arrays.equals(temp[1], close_point1))){
                close_point3 = temp[0];
                printPoints(close_point1, close_point2, close_point3);
//                System.out.println("case 2 \n");
            }
            else if((Arrays.equals(temp[0], close_point2) && Arrays.equals(temp[2], close_point1))){
                close_point3 = temp[1];
                printPoints(close_point1, close_point2, close_point3);
//                System.out.println("case 3 \n");
            }
            else if((Arrays.equals(temp[1], close_point2) && Arrays.equals(temp[2], close_point1))){
                close_point3 = temp[0];
                printPoints(close_point1, close_point2, close_point3);
//                System.out.println("case 4 \n");
            }
            else if((Arrays.equals(temp[2], close_point2) && Arrays.equals(temp[0], close_point1))){
                close_point3 = temp[1];
                printPoints(close_point1, close_point2, close_point3);
//                System.out.println("case 5 \n");
            }
            else if((Arrays.equals(temp[0], close_point2) && Arrays.equals(temp[1], close_point1))){
                close_point3 = temp[2];
                printPoints(close_point1, close_point2, close_point3);
//                System.out.println("case 6 \n");
            }
            if(close_point3 != safe_point){
                System.out.println("temp array: " + Arrays.deepToString(temp)+"\n");
                CalcArea.findEarthQuakeArea(close_point1[0],close_point1[1],close_point2[0],close_point2[1],close_point3[0],close_point3[1],safe_point[0],safe_point[1]);
                count++;
            }
//            else{
//                System.out.println("skipped temp \n");
//            }
//            }
        }
        if(count == 0){
            System.out.println("warning: person is not located within any safe triangle");
        }
    }
}

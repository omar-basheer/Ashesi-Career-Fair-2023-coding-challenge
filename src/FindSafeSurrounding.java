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

        // find points closest to safe point
        for(int i=1; i<points.size(); i++){
            distance = CalcE_Distance.findEucDistance(safe_point[0], safe_point[1], points.get(i)[0], points.get(i)[1]);
            double[] point1 = new double[]{safe_point[0], safe_point[1]};
            double[] point2 = new double[]{points.get(i)[0], points.get(i)[1]};
            distances.putIfAbsent(distance, new double[][]{point1,point2});
        }

        // get the smallest distance from map keys, the closest point is the value of this key
        Set<Double> keySet = distances.keySet();
        ArrayList<Double> all_distances = new ArrayList<>(keySet);
        double min_dist = all_distances.get(0);
        double[] close_point1 = new double[0];
        double[] close_point2 = new double[0];
        int min_index = 0;

        // loop through distances;
        for(int i=0; i<2; i++){
            for(int j=0; j<all_distances.size(); j++){
                if(all_distances.get(j) < min_dist){
                    min_dist = all_distances.get(j);
                    min_index = j;
                }
            }
            // assign second closest to close point 2
            if(i==1){
                close_point2 = new double[]{distances.get(min_dist)[1][0], distances.get(min_dist)[1][1]};
            }else {
                // assign closest to close point 1
                close_point1 = new double[]{distances.get(min_dist)[1][0], distances.get(min_dist)[1][1]};
                all_distances.remove(min_index);
                min_dist = all_distances.get(0);
            }
        }
        System.out.println("close point 1: " + Arrays.toString(close_point1));
        System.out.println("close point 2: " + Arrays.toString(close_point2) + "\n");

        // get other triangles that contain the close_points
        Collection<ArrayList<double[]>> values = FindSafeTriangle.triangles.values();
        ArrayList<ArrayList<double[]>> allValues = new ArrayList<>(values);

        // search through each triangle, comparing close points 1 and 2 until we find a triangle that has both those 2 points. assign it's 3rd point as close point 3
        int count = 0;
        for(int k=0; k<allValues.size(); k++){
            ArrayList<double[]> temp = allValues.get(k);
            double[] close_point3;
//            System.out.println("temp array: " + Arrays.deepToString(temp));
//            for(int i=0; i<temp.length; i++){
            close_point3 = safe_point;
            if((Arrays.equals(temp.get(0), close_point1) && Arrays.equals(temp.get(1), close_point2))){
                close_point3 = temp.get(2);
                printPoints(close_point1, close_point2, close_point3);
//                System.out.println("case 1 \n");
            }
            else if((Arrays.equals(temp.get(1), close_point1) && Arrays.equals(temp.get(2), close_point2))){
                close_point3 = temp.get(0);
                printPoints(close_point1, close_point2, close_point3);
//                System.out.println("case 2 \n");
            }
            else if((Arrays.equals(temp.get(0), close_point2) && Arrays.equals(temp.get(2), close_point1))){
                close_point3 = temp.get(1);
                printPoints(close_point1, close_point2, close_point3);
//                System.out.println("case 3 \n");
            }
            else if((Arrays.equals(temp.get(1), close_point1) && Arrays.equals(temp.get(0), close_point2))){
                close_point3 = temp.get(0);
                printPoints(close_point1, close_point2, close_point3);
//                System.out.println("case 4 \n");
            }
            else if((Arrays.equals(temp.get(2), close_point2) && Arrays.equals(temp.get(0), close_point1))){
                close_point3 = temp.get(1);
                printPoints(close_point1, close_point2, close_point3);
//                System.out.println("case 5 \n");
            }
            else if((Arrays.equals(temp.get(1), close_point2) && Arrays.equals(temp.get(2), close_point1))){
                close_point3 = temp.get(0);
                printPoints(close_point1, close_point2, close_point3);
//                System.out.println("case 6 \n");
            }
            //
            if(close_point3 != safe_point){
                // check if person is within the triangle
                System.out.println("temp array: " + FindSafeTriangle.listToString(temp)+"\n");
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

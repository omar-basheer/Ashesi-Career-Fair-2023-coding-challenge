import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class FindSafeTriangle {
    public static HashMap<Double, double[][]> triangles = new HashMap<>();

    public static ArrayList<double[]> readFile(String csvFile) throws IOException {

        ArrayList<double[]> points = new ArrayList<>();
        Scanner inputStream = null;


        try{
            inputStream = new Scanner(new FileInputStream(csvFile));
            inputStream.nextLine();
            while (inputStream.hasNextLine()){
                String line = inputStream.nextLine();
                String[] list = line.split(",");
                double x_cor = Double.parseDouble(list[0]);
                double y_cor = Double.parseDouble((list[1]));
                double[] temp = new double[]{x_cor,y_cor};
                points.add(temp);

            }
        }
        catch (FileNotFoundException e){
            System.exit(0);
        }

        return points;

    }

    public static void findSafeTri(ArrayList<double[]> points ){
        double max_area = 0;
        if(points.size() >= 3){
            double x1,y1,x2,y2,x3,y3;
            double map_index = 1;

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
//                            map_index++;
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

    public static void main(String[]args) throws IOException {
        System.out.println("working...");

        double[] floatArr1 = new double[]{0.5,0.5};
        double[] floatArr2 = new double[]{1,3.5};
        double[] floatArr3 = new double[]{2,3};
        double[] floatArr4 = new double[]{3,4};
        double[] floatArr5 = new double[]{3,0.5};
//
//        ArrayList<double[]> test_array = new ArrayList<>();
//        test_array.add(floatArr1);
//        test_array.add(floatArr2);
//        test_array.add(floatArr3);
//        test_array.add(floatArr4);
//        test_array.add(floatArr5);

//        double[] floatArr1 = new double[]{1,1};
//        double[] floatArr2 = new double[]{2,2};
//        double[] floatArr3 = new double[]{3,3};
//        double[] floatArr4 = new double[]{4,4};
//        double[] floatArr5 = new double[]{5,5};

        ArrayList<double[]> test_array = new ArrayList<>();
        test_array.add(floatArr1);
        test_array.add(floatArr2);
        test_array.add(floatArr3);
        test_array.add(floatArr4);
        test_array.add(floatArr5);

        //points 10
//        double[] floatArr1 = new double[]{724608,215073};
//        double[] floatArr2 = new double[]{523639,989854};
//        double[] floatArr3 = new double[]{14146,99476};
//        double[] floatArr4 = new double[]{109004,339321};
//        double[] floatArr5 = new double[]{399311,245174};
//        double[] floatArr6 = new double[]{430471,376122};
//        double[] floatArr7 = new double[]{151995,541689};
//        double[] floatArr8 = new double[]{570685,593949};
//        double[] floatArr9 = new double[]{798017,813868};
//        double[] floatArr10 = new double[]{401480,247604};
//
//        ArrayList<double[]> test_array = new ArrayList<>();
//            test_array.add(floatArr1);
//            test_array.add(floatArr2);
//            test_array.add(floatArr3);
//            test_array.add(floatArr4);
//            test_array.add(floatArr5);
//            test_array.add(floatArr6);
//            test_array.add(floatArr7);
//            test_array.add(floatArr8);
//            test_array.add(floatArr9);
//            test_array.add(floatArr10);

//        double[] floatArr1 = new double[]{834757,915510};
//        double[] floatArr2 = new double[]{548025,965589};
//        double[] floatArr3 = new double[]{217322,593335};
//        double[] floatArr4 = new double[]{555857,814348};
//        double[] floatArr5 = new double[]{554779,602712};
//        double[] floatArr6 = new double[]{844213,454662};
//        double[] floatArr7 = new double[]{376475,22095};
//        double[] floatArr8 = new double[]{352716,526397};
//        double[] floatArr9 = new double[]{675635,512283};
//        double[] floatArr10 = new double[]{571704,669770};
//
//        ArrayList<double[]> test_array = new ArrayList<>();
//            test_array.add(floatArr1);
//            test_array.add(floatArr2);
//            test_array.add(floatArr3);
//            test_array.add(floatArr4);
//            test_array.add(floatArr5);
//            test_array.add(floatArr6);
//            test_array.add(floatArr7);
//            test_array.add(floatArr8);
//            test_array.add(floatArr9);
//            test_array.add(floatArr10);


        ArrayList<double[]> temp = readFile("points10.csv");
        findSafeTri(test_array);
        printMap(triangles);

//        for (int i =0; i < temp.size(); i++){
//            System.out.println("x_cor: " + temp.get(i)[0] + " y_cor: " + temp.get(i)[1]);
//        }



    }
}

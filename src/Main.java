import java.util.ArrayList;

public class Main {
    public static void main(String[]args){
        System.out.println("working...");

//        double[] floatArr1 = new double[]{0.5,0.5};
//        double[] floatArr2 = new double[]{1,3.5};
//        double[] floatArr3 = new double[]{2,3};
//        double[] floatArr4 = new double[]{3,4};
//        double[] floatArr5 = new double[]{3,0.5};
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
//
//        ArrayList<double[]> test_array = new ArrayList<>();
//        test_array.add(floatArr1);
//        test_array.add(floatArr2);
//        test_array.add(floatArr3);
//        test_array.add(floatArr4);
//        test_array.add(floatArr5);

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

        FindSafeTriangle.findSafeTri(test_array);
//        FindSafeTriangle.printMap(FindSafeTriangle.triangles);
        FindSafeSurrounding.findSafeSurr(test_array);





    }


}
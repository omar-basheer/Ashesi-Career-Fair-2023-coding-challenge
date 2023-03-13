public class CalcSlope {

    public static double findSlope(double x1, double y1, double x2, double y2){
        double slope;
        if(x2 - x1 != 0){
          slope = (y2-y1)/(x2-x1);
          return slope;
        }else{
            System.out.println("division by zero error encountered");
            return Integer.MAX_VALUE;
        }
    }
}

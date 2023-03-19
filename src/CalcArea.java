import java.text.DecimalFormat;
import java.util.Arrays;

public class CalcArea {

    public static double findArea(double x1, double y1, double x2, double y2, double x3, double y3) {
        double area;
        DecimalFormat df = new DecimalFormat("#.##");
        area = Double.parseDouble(df.format(0.5 * Math.abs((x1*(y2-y3) + x2*(y3-y1) + x3*(y1-y2)))));
        return area;
    }

    public static void findEarthQuakeArea(double x1, double y1, double x2, double y2, double x3, double y3, double sp1, double sp2){
        double area1, area2, area3, tri_area, total;
        double[][] triangle = new double[0][];
        DecimalFormat df = new DecimalFormat("#.##");

        tri_area =findArea(x1,y1,x2,y2,x3,y3);
        System.out.println("triangle area: " + tri_area);

        area1 = findArea(x1,y1,x2,y2,sp1,sp2);
        System.out.println("area1: " + area1);

        area2 = findArea(x1,y1,sp1,sp2,x3,y3);
        System.out.println("area2: " + area2);

        area3 = findArea(sp1,sp2,x2,y2,x3,y3);
        System.out.println("area3: " + area3);

        total = area1+area2+area3;
        System.out.println("area1+area2+area3: " + total);

        triangle = new double[][]{{x1,y1},{x2,y2},{x3,y3}};
        if(area1+area2+area3 == tri_area){
            System.out.println("safe triangle: " + Arrays.deepToString(triangle));
        }else{
            System.out.println("triangle not safe: " + Arrays.deepToString(triangle));
        }
        System.out.println(" ");
    }
}

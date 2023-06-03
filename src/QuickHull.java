import java.util.*;

public class QuickHull {
    private static List<Point> convexHull = new ArrayList<>();
    public static void Quick_Hull(List<Point> points){
        if (points.size() < 3) return;
        int min =  points.get(0).getX();
        int max = min;
        for (int i = 1; i < points.size(); i++){
            if (points.get(i).getX() < points.get(min).getX())
                min = i;
            if (points.get(i).getX() > points.get(max).getX())
                max = i;
        }
        Point A = points.get(min);
        Point B = points.get(max);
        convexHull.add(A);
        convexHull.add(B);
        List<Point> S1 = new ArrayList<>();
        List<Point> S2 = new ArrayList<>();
        for (Point point : points) {
            if (cross(B.getX() - A.getX(), B.getY() - A.getY(), point.getX() - A.getX(), point.getY() - A.getY()) > 0)
                S1.add(point);
            if (cross(B.getX() - A.getX(), B.getY() - A.getY(), point.getX() - A.getX(), point.getY() - A.getY()) < 0)
                S2.add(point);
        }
        FindHull(S1, A, B);
        FindHull(S2, B, A);
        System.out.println("Acoperirea convexa are punctele:");
        for (Point point : convexHull)
            point.print();
    }
    public static int cross(int x1, int y1, int x2, int y2) {
        return x1 * y2 - x2 * y1;
    }
    public static void FindHull(List<Point> Sk, Point P, Point Q){
        if (Sk.size() == 0) return;
        int max = Integer.MIN_VALUE;
        Point C = null;
        for (Point point : Sk){
            int cr = cross(Q.getX() - P.getX(), Q.getY() - P.getY(), point.getX() - P.getX(), point.getY() - P.getY());
            if (cr > max){
                max = cr;
                C = point;
            }
        }
        if (C == null) return;
        convexHull.add(C);
        //List<Point> S0 = new ArrayList<>();
        List<Point> S1 = new ArrayList<>();
        List<Point> S2 = new ArrayList<>();
        for (Point point : Sk){
            //if (cross(C.getX() - P.getX(), C.getY() - P.getY(), point.getX() - P.getX(), point.getY() - P.getY()) < 0)
              //  S0.add(point);
            if (cross(C.getX() - P.getX(), C.getY() - P.getY(), point.getX() - P.getX(), point.getY() - P.getY()) > 0)
                S1.add(point);
            if (cross(Q.getX() - C.getX(), Q.getY() - C.getY(), point.getX() - C.getX(), point.getY() - C.getY()) > 0)
                S2.add(point);
        }
        FindHull(S1, P, C);
        FindHull(S2, C, Q);
    }
}

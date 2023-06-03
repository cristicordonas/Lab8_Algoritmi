import java.util.ArrayList;
import java.util.List;

public class Gift_Wrapping {
    public static void gftwrp(List<Point> S){
        if (S.size() < 3) return;
        List<Point> P = new ArrayList<>();
        Point pointOnHull;
        int min =  S.get(0).getX();
        for (int i = 1; i < S.size(); i++){
            if (S.get(i).getX() < S.get(min).getX())
                min = i;
        }
        pointOnHull = S.get(min);
        int i = 0;
        Point endpoint;
        do {
            P.add(i, pointOnHull);
            endpoint = S.get(0);
            for (Point point : S) {
                if ((endpoint == pointOnHull) || (cross(pointOnHull, endpoint, point) > 0))
                    endpoint = point;
            }
            i++;
            pointOnHull = endpoint;
        }while (endpoint != P.get(0));
        System.out.println("Acoperirea convexa are punctele:");
        for (Point point : P)
            point.print();
    }
    public static int cross(Point A, Point B, Point C) {
        return (B.getX() - A.getX()) * (C.getY() - A.getY()) - (B.getY() - A.getY()) * (C.getX() - A.getX());
    }
}

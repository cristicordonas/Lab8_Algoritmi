import java.util.*;
public class Graham_Scan {
    public static int ccw(Point p, Point q, Point r) {
        return (q.getY() - p.getY()) * (r.getX() - q.getX()) -
                (q.getX() - p.getX()) * (r.getY() - q.getY());
    }
    public static int cross(int x1, int y1, int x2, int y2) {
        return x1 * y2 - x2 * y1;
    }
    public static Point top(Stack<Point> S) {
        return S.peek();
    }

    public static Point next_to_top(Stack<Point> S) {
        return S.get(S.size() - 2);
    }
    public static void GRAHAM_SCAN(List<Point> points) {
        if (points.size() < 3) return;
        Stack<Point> stiva = new Stack<>();
        int l = 0;
        for (int i = 1; i < points.size(); i++)
            if (points.get(i).getX() + points.get(i).getY() < points.get(l).getX() + points.get(l).getY())
                l = i;
        Point initial = points.get(l);
        Collections.sort(points, (a, b) -> {
            int cr = cross(a.getX() - initial.getX(), a.getY() - initial.getY(), b.getX() - initial.getX(), b.getY() - initial.getY());
            if (cr > 0)
                return 1;
            else
                return -1;
        });
        for (Point point : points){
            while (stiva.size() > 1 && ccw(next_to_top(stiva), top(stiva), point) <= 0)
                stiva.pop();
            stiva.push(point);
        }
        System.out.println("Acoperire convexa are punctele:");
        for (Point point : stiva)
            point.print();
    }
}
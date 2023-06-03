import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Point> points = new ArrayList<>();
        points.add (new Point(0, 3));
        points.add (new Point(1, 1));
        points.add (new Point(2, 2));
        points.add (new Point(4, 4));
        points.add (new Point(0, 0));
        points.add (new Point(1, 2));
        points.add (new Point(3, 1));
        points.add (new Point(3, 3));
        System.out.print("Algoritmul Graham Scan:\n");
        Graham_Scan.GRAHAM_SCAN(points);
        System.out.print("\nAlgoritmul Quick Hull:\n");
        QuickHull.Quick_Hull(points);
        System.out.print("\nAlgoritmul Gift Wrapping:\n");
        Gift_Wrapping.gftwrp(points);
    }
}
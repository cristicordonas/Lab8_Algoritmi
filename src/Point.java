public class Point {
    private int x, y;
    Point() {
        x = 0;
        y = 0;
    }
    Point(int a, int b) {
        x = a;
        y = b;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public void print() {
        System.out.println("(" + x + ", " + y + ")");
    }
}

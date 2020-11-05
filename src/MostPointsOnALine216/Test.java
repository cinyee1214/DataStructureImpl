package MostPointsOnALine216;

public class Test {
    public static void main(String[] args) {
        Solution s1 = new Solution();
        Point[] points = new Point[] {new Point(2, 1), new Point(2, 3), new Point(1, 1)};
        int num = s1.most(points);
        System.out.println(num);

    }
}

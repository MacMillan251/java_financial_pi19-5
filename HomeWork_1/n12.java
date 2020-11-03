import java.util.Scanner;

class Scratch {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("X1 >> ");
        double x1 = in.nextDouble();
        System.out.print("Y1 >> ");
        double y1 = in.nextDouble();
        System.out.print("X2 >> ");
        double x2 = in.nextDouble();
        System.out.print("Y2 >> ");
        double y2 = in.nextDouble();
        in.close();
        double length = Math.sqrt(Math.pow(x2-x1,2)+Math.pow(y2-y1,2));
        System.out.printf("%.3f", length);
    }
}
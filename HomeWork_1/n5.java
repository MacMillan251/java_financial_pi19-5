import java.util.Scanner;

class Scratch {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("A >> ");
        int a = in.nextInt();
        System.out.print("B >> ");
        int b = in.nextInt();
        in.close();
        var c = Math.sqrt(a*a + b*b);
        System.out.printf("C = %.0f", c);
    }
}
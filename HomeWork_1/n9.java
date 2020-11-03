import java.util.Scanner;

class Scratch {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите число >> ");
        int x = in.nextInt();
        in.close();
        x-=21;
        System.out.print("Разница между " + (x+21) + " и 21 = " + x);
    }
}
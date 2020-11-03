import java.util.Scanner;

class Scratch {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("1-е число >> ");
        int x = in.nextInt();
        System.out.print("2-е число >> ");
        double y = in.nextInt();
        in.close();
        double z = (x + y) / 2;
        if(((x + y) % 10) % 2 == 0) {  //конструкция для вывода целого числа без точки
            System.out.printf("%.0f", z);
        }
        else{
            System.out.printf("%.1f", z);
        }

    }
}
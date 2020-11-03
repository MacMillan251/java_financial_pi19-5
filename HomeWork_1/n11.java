import java.util.Scanner;

class Scratch {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("1-е число >> ");
        int x = in.nextInt();
        System.out.print("2-е число >> ");
        double y = in.nextInt();//тип double для деления со значением после точки
        in.close();
        double z = Math.sqrt(x * y);
        if(z%1 == 0) {  //конструкция для вывода целого числа без точки
            System.out.printf("%.0f", z);
        }
        else{
            System.out.printf("%.3f", z);
        }

    }
}
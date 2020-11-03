class Scratch {
    public static void main(String[] args) {
        int x = 10;
        int y = 5;
        x = x + y - (y = x);
        System.out.println("x = " + x + ", y = " + y);
        x += y;
        y = x - y;
        x -= y;
        System.out.println("x = " + x + ", y = " + y);
    }
}
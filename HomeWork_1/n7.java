class Scratch {
    public static void main(String[] args) {
        int x = 1876;
        String Str = new String(Integer.toBinaryString(x));
        int length = Str.length();
        char ch = Str.charAt(length-2);
        System.out.println(Str);
        System.out.println("Число десятков = " + ch);

    }
}
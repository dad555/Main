public class test1 {
    public static void main(String[] args) {
        while(condition()) {
            System.out.println("Inside 'while'");
        }
        System.out.println("Exited 'while'");
        System.out.println(Math.random());


        for (char c = 0; c < 128; c++) {
            if (Character.isLowerCase(c)) System.out.println("значение: " + (int) c + " символ: " + c);
        }
    }

    static boolean condition() {
        boolean result = Math.random() < 0.09;
        System.out.println(result + ", ");
        return result;
    }
}

public class generic {
    public static void main(String[] args) {
        Account<Integer, String> acc = new Account<>();
        acc.setA(19);
        acc.setX("Artur");

        System.out.println(acc.getA());

        Account<String> accSt = new Account<>();
        accSt.setA("Hello");


    }

}
class Account <A, X> {
    A a;
    X x,

    public A getA() {
        return a;
    }

    public void setA(A a) {
        this.a = a;
    }

    public X getX() {
        return x;
    }

    public void setX(X x) {
        this.x = x;
    }
}

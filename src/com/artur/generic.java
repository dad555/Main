package com.artur;

public class generic {
    public static void main(String[] args) {
        Account<Integer, String> acc = new Account<>();
        acc.setX(19);
        acc.setY("Artur");

        System.out.println(acc.getX());

        Account<String, Long> accSt = new Account<>();
        accSt.setX("Hello");
        accSt.setY(1020L);


    }

}
class Account <X, Y> {
    private X x;
    private Y y;

    public X getX() {
        return x;
    }

    public void setX(X x) {
        this.x = x;
    }

    public Y getY() {
        return y;
    }

    public void setY(Y y) {
        this.y = y;
    }
}

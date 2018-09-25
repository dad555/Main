package ChainedExpresions;

class ChainExcDemo {
    static void demoproc() {
        NullPointerException e = new NullPointerException("Верхний уровень");
        e.initCause(new ArithmeticException("причина"));
        throw e;
    }

    public static void main(String[] args) {
        try {
            demoproc();
        }
        catch (NullPointerException t) {
            System.out.println("Перехвачено: " + t);
            System.out.println("Исходная причина: " + t.getCause());
        }
    }
}
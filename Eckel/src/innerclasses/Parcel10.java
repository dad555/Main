package innerclasses;

class Destination {
    private String label;
    Destination() {
    }
}

public class Parcel10 {
    public Destination destination (final String dest, final float price) {
        return new Destination() {
            private int cost;
            // Инициализация экземпляра для каждого объекта
            {
                cost = Math.round(price);
                if (cost > 100) {
                    System.out.println("Превышение бюджета!!");
                }
            }
            private String label = dest;
            public String readLabel() {
                return label;
            }
        };
    }

    public static void main(String[] args) {
        Parcel10 p = new Parcel10();
        Destination d = p.destination("Армения", 101.45F);
    }
}

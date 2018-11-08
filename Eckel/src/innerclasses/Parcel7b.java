package innerclasses;


public class Parcel7b {
    static class MyContents implements Contents {
        private int i = 11;
        public int value() {
            return i;
        }

        public void setValue(int x) {
            this.i = x;
        }
    }

    public Contents contents() {
        return new MyContents();
    }

    public static void main(String[] args) {
        Parcel7b p = new Parcel7b();
        Contents c = p.contents();
        System.out.println(c.value());
        MyContents myContents = new MyContents();
        myContents.setValue(15);
        System.out.println(c.value());
        System.out.println(myContents.value());
    }
}

import java.io.File;

public class test1 {
    public static void main(String[] args) {
        File f = new File("MyTestFile.txt");
        File dir = new File("Chapter7");
        dir.mkdir();

        if(dir.isDirectory()) {
            for(String s : dir.list()) {
                System.out.println(s);
            }
        }

        System.out.println(dir.getAbsoluteFile());
        System.out.println(f.delete());
    }
}

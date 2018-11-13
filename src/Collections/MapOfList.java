package Collections;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapOfList {
    public static Map<String, List<? extends Integer>> mapoflist = new HashMap<>();
    static {
        mapoflist.put("Артур", Arrays.asList(12, 230, 334, 563));
        mapoflist.put("Диана", Arrays.asList(14, 220, 333, 526));
        mapoflist.put("Давид", Arrays.asList(156, 240, 343, 5326));
        mapoflist.put("Ирина", Arrays.asList(16, 30, 533, 546));
        mapoflist.put("Игорь", Arrays.asList(130, 20, 363, 536));
    }

    public static void main(String[] args) {
        System.out.println("People: " + mapoflist.keySet());
        System.out.println("Numbers: " + mapoflist.values());

        for(String s : mapoflist.keySet()) {
            System.out.println(s + " has:");
            for(Integer i : mapoflist.get(s)) {
                System.out.println("    " + i);
            }
        }

        System.out.println(mapoflist.containsKey("Артур"));
    }
}

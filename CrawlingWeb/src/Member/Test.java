package Member;

import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        HashMap<String, String> dict = new HashMap<>();
        dict.put("ZZA1","5433");
        dict.put("ZZA2","312543");
        dict.put("ZZA3","12543");
        dict.put("ZZA4","5412443");
        for (Map.Entry<String, String> stringStringEntry : dict.entrySet()) {
            System.out.println(stringStringEntry);
        }

    }
}

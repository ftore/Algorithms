package streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by e068529 on 5/11/17.
 */
public class Count {
    public static void main(String[] args) {
        String[] names = {"Akaml", "Mashhur Sattorov", "Bahrom"};
        List<String> stringList = Arrays.asList(names);

        long count = stringList.stream().filter(w -> w.length() > 8).count();



    }
}

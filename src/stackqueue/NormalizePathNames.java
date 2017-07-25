package stackqueue;

import java.util.*;

/**
 * Created by e068529 on 7/11/17.
 */
public class NormalizePathNames {
    public static String normalize(String path) {
        String[] paths = path.split("/");
        StringBuilder normalPath = new StringBuilder();
        java.util.Stack<String> stack = new java.util.Stack<>();

        for(int i = 0; i < paths.length; i++) {
            String curr = paths[i];
            if(curr.equals("..")) {
                stack.pop();
            } else if(curr.equals(".") || "".equals(curr)) {
                continue;
            } else {
                stack.push(paths[i]);
            }
        }

        Iterator<String> iterator = stack.iterator();

        while (iterator.hasNext()) {
            String s = iterator.next();
            normalPath.append("/");
            normalPath.append(s);
        }

        return normalPath.toString();
    }

    public static void main(String[] args) {
        String path1 = "/usr/lib/../bin/gcc";
        String path2 = "scripts//./,./scripts/awkscripts/././";

        System.out.println(normalize(path1));
        System.out.println(normalize(path2));
    }
}

package strings;

public class CompareVersion {
    public static int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");

        int size = Math.min(v1.length, v2.length);
        System.out.println(size);
        int i;
        for(i = 0; i < size; i++) {
            int num1 = Integer.parseInt(v1[i]);
            int num2 = Integer.parseInt(v2[i]);

            System.out.println(num1 + " | " + num2);
            if(num1 < num2) {
                return -1;
            } else if(num1 > num2) {
                return 1;
            }
        }

        if(i < v1.length) return 1;
        else if(i < v2.length) return -1;

        return 0;
    }

    public static void main(String[] args) {
        System.out.println(compareVersion("1", "1.1"));
    }
}

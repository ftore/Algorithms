package arrays;

import java.util.Arrays;

public class BulbSwitcher {
    public int bulbSwitch(int n) {
        if(n == 0) return -1;
        boolean[] bulbs = new boolean[n];

        Arrays.fill(bulbs, true);
        bulbSwitch(n, bulbs, 1);

        int count = 0;
        for(int i = 0; i < n; i++) {
            if(bulbs[i]) count++;
        }

        return count;
    }

    private void bulbSwitch(int n, boolean[] bulbs, int step) {
        if(step == n - 1) {
            togleBulb(bulbs, n - 1);
            return;
        }

        int i = step;

        for(; i < n; i += step + 1) {
            togleBulb(bulbs, i);
        }

        bulbSwitch(n, bulbs, step + 1);
    }

    private void togleBulb(boolean[] bulbs, int i) {
        if(bulbs[i]) {
            bulbs[i] = false;
        } else {
            bulbs[i] = true;
        }
    }

    public static void main(String[] args) {
        BulbSwitcher bulbSwitcher = new BulbSwitcher();

        System.out.println(bulbSwitcher.bulbSwitch(3));
    }
}

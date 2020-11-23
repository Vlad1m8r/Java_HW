package com.HW;

import java.util.Arrays;

public class Second {

    public static void main(String[] args) {

        int[] mas = new int[1_000_000];
        for (int i = 0; i<mas.length; i++)
            mas[i] = (int) (Math.random()*1_000_000);

        double time = System.currentTimeMillis();
        for (int i = 0; i<100; i++)
            perebor(mas,999500);
        System.out.println(perebor(mas,424));
        System.out.println("Time: " + (System.currentTimeMillis() - time));

        Arrays.sort(mas);

        time = System.currentTimeMillis();
        for (int i = 0; i<100; i++)
            doublf(mas,999500);
        System.out.println(doublf(mas,999500));
        System.out.println("Time: " + (System.currentTimeMillis() - time));

    }

    private static boolean perebor(int[] m, int i) {

        for (int j: m)
            if (j == i)
                return true;
        return false;
    }

    // Выполняется дольше т.к. испл System.arraycopy на каждом шаге рекурсии
    private static boolean doublf(int[] m, int i) {
        int[] n_m = new int[m.length/2];
        if (m.length == 0)
            return false;
        if (m[m.length/2] == i)
            return true;
        else if (m[m.length/2] > i) {
            System.arraycopy(m, 0, n_m, 0, m.length / 2);
            return doublf(n_m, i);
        }
        else if (m[m.length/2] < i) {
            System.arraycopy(m, m.length / 2, n_m, 0, m.length/2);
            return doublf(n_m, i);
        }
        return false;

        // Выполнение без испл System.arraycopy еще не доделанная
//        if (m[num] == i)
//            return true;
//        else if (m[num] < i)
//            return doublf(m, i, Math.abs(num - m.length/2)/2+num);
//        else if (m[num] > i)
//            return doublf(m, i, num/2);
//        return false;
    }

}

package com.HW;

public class Third {

    public static void main(String[] args) {

        System.out.println(coren(0));

    }

    static float coren(float x) {
        if (   (int)(Math.cos(Math.toRadians(Math.pow(x, 5))) + Math.pow(x, 4) - 345.3 * x - 23) == 0  )
            return x;
        else if (x > 10)
            return 0;
        else
            x = coren(x+0.001f);
        return x;
    }

}

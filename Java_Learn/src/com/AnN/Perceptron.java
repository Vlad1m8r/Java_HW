package com.AnN;

import java.net.IDN;

public class Perceptron {

    public static final double LEARNING_RATE = 0.03;
    public static final double MOMENT = 0.1;
    public static final int BIAS = 1;
    public static final double[][] INPUT_DATE = {{0,0,0,0},
                                             {0,0,0,1},
                                             {0,0,1,0},
                                             {1,0,1,1},
                                             {0,1,0,0},
                                             {0,1,0,1},
                                             {0,1,1,0},
                                             {0,1,1,1},
                                            {1,0,0,0},
                                            {1,0,0,1}};

    public static final int[] OUTPUT_DATE = {0,0,0,1,0,2,2,1,0,2};
    public static final double[] HIDDEN_LAYER = new double [INPUT_DATE.length*2];
    public static final double[][] INPUT_WEIGHTS = ran_weight(INPUT_DATE[0].length, HIDDEN_LAYER.length);
    public static final double[][] HIDDEN_WEIGHTS = ran_weight(HIDDEN_LAYER.length, 1);

    private static double[][] ran_weight(int num_of_n, int len){
        double[][] rw = new double[num_of_n][len];
        for (int i = 0; i < num_of_n; i++)
            for (int j = 0; j < len; j++)
                rw[i][j] = Math.random();
        return rw;
    }

    public static double calcWeightSum (double[] date, double[] weights){
        double weightsSum = 0;
        for (int i = 0; i < date.length; i++)
            weightsSum += date[i] * weights[i];
        return weightsSum  + BIAS ;
    }

    //################################################
    public static double sigmoid (double x){
        return 1/(1 + Math.pow(Math.E, -x));
    }

    public static double hyperbolicTangent (double x){
        return (Math.pow(Math.E, 2*x) - 1) / (Math.pow(Math.E, 2*x) + 1);
    }

    public static double activeFunction (double weightsSum){
        return sigmoid(weightsSum);
    }

    //################################################
    public static double derivedSigmoid(double actual){
        return (1 - actual) * actual;
    }

    public static double derivedTangent(double actual){
        return 1 - (actual * actual);
    }

    public static double derivedFunction (double actual){
        return derivedSigmoid(actual);
    }

    //################################################
    public static double calcBPOut(int ideal, double actual){
        return (ideal - actual) * derivedFunction(actual);
    }

    public  static double calcGradient (int out, double deltaNOut){
        return  out * deltaNOut;
    }

    public static double adjustments(double gradient, double bfr){
        return LEARNING_RATE * gradient + MOMENT * bfr; // 0 = (delta[i-1])
    }



    public static double calcError (int ideal, double actual){
        return Math.pow(ideal - actual, 2);
    }

    public static double calcBPHidden (int[] weights, double out, double delta){
        return 0;
    }

    public static double calcBPInput (double weights, double out, double deltaNOut){
        return derivedFunction(out) * (weights * deltaNOut);
    }
    public  static double calcGradient (double out, double deltaNOut){
        return  out * deltaNOut;
    }


    static double[][] transMatrix (double[][] A) {
        double[][] matrix = new double[A[0].length][A.length];
        for (int i = 0; i < A.length; i+=1) {
            for (int j = 0; j < A[0].length; j+=1) {
                matrix[j][i] = A[i][j];
            }
        }
        return matrix;
    }

}

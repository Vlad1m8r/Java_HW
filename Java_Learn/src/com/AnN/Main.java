package com.AnN;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        double[][] input_layer = Perceptron.INPUT_DATE;
        int[] ideal_date = Perceptron.OUTPUT_DATE;
        double[][] inputWeights = Perceptron.INPUT_WEIGHTS;
        double[] hidden1 = Perceptron.HIDDEN_LAYER;
        double[][] hiddenWeights = Perceptron.HIDDEN_WEIGHTS;


        int epoch_num = 100_000;
        double error = 0;
        double output;
        double weights_sum;
        double gradient;
        double delta_out;
        double delta_h;
        double[] delta_h_b = new double[hiddenWeights.length];
        Arrays.fill(delta_h_b, 0);

        System.out.println("Weights\n" + Arrays.deepToString(inputWeights));
        System.out.println("Input date\n" + Arrays.deepToString(input_layer));
        System.out.println("Output date\n" + Arrays.toString(ideal_date) + "\n");

//        for (int ep = 0; ep < epoch_num; ep++){
//            for (int i = 0; i < input_layer.length; i++){
//                weights_sum = Perceptron.calcWeightSum(input_layer[i], inputWeights);
//                output = Perceptron.activeFunction(weights_sum);
//                error = ideal_date[i] - output;
//
//                delta = Perceptron.calcBPOut(ideal_date[i], output);
//                for (int w = 0; w < inputWeights.length; w++) {
//                    gradient = Perceptron.calcGradient(input_layer[i][w], delta);
//                    inputWeights[w] += Perceptron.adjustments(gradient);
//                }
//
//            }
//        }



        for (int ep = 0; ep < epoch_num; ep++){
            for (int j = 0; j < input_layer.length; j++){
                // Считаються значения нейронов скрытого слоя
                for (int i = 0; i < hidden1.length; i++){
                    weights_sum = Perceptron.calcWeightSum(input_layer[j], Perceptron.transMatrix(inputWeights)[i]);
                    output = Perceptron.activeFunction(weights_sum);
                    hidden1[i] = output;
                }
                // Считается значения выходного нейрона
                weights_sum = Perceptron.calcWeightSum(hidden1, Perceptron.transMatrix(hiddenWeights)[0]);
                output = Perceptron.activeFunction(weights_sum);
                error = ideal_date[j] - output;
                delta_out = Perceptron.calcBPOut(ideal_date[j], output); // Дельта выхода считаем 1 раз

                for (int w = 0; w < hiddenWeights.length; w++) {
                    gradient = Perceptron.calcGradient(hidden1[w], delta_out);
                    hiddenWeights[w][0] += Perceptron.adjustments(gradient, delta_h_b[w]);
                    delta_h_b[w] = hiddenWeights[w][0];
                }

                for (int w = 0; w < inputWeights.length; w++){
                    delta_h = Perceptron.calcBPInput(hidden1[j], hiddenWeights[w][0], delta_out);
                    gradient = Perceptron.calcGradient(input_layer[j][w], delta_h);
                    inputWeights[w][0] += Perceptron.adjustments(gradient, 0);
                }
            }



        }

        System.out.println("Error = " + error);
        System.out.println("Result inputWeights\n" + Arrays.deepToString(inputWeights));


        System.out.println();
        System.out.println();

        double[][] test_date = {{0,0,0,0},
                                {0,0,0,1},
                                {0,0,1,0},
                                {0,0,1,1},
                                {0,1,0,0},
                                {0,1,0,1},
                                {0,1,1,0},
                                {0,1,1,1},
                                {1,0,0,0},
                                {1,0,0,1}};
        for (double[] d : test_date){
            int res = 0;
            double weightSum = Perceptron.calcWeightSum(d, Perceptron.transMatrix(inputWeights)[0]);
            double out = weightSum;

            System.out.print("Date = " + Arrays.toString(d));
            System.out.printf(" Out = %.5f", out);
            if (out > 0.5)
                res = 1;
            System.out.println(" Res = " + res);
        }

    }
}

package version2;

import java.util.Random;

public class Neuron {
    double[] weights;
    double bias;
    double learningRate;

    private  static  final  Random rand = new Random();

    public Neuron(int numInputs, double learningRate) {
        this.learningRate = learningRate;
        this.weights = new double[numInputs];
        this.bias = 0.0;

        // randomize weights
        for (int i = 0; i < numInputs; i++) {
            weights[i] = rand.nextGaussian() * Math.sqrt(2.0 / numInputs);
        }
    }

    // calculating weighted sum
    public double weightedSum(double[] inputs) {
        double sum = bias;
        for (int i = 0; i < inputs.length; i++) {
            sum += inputs[i] * weights[i];
        }
        return  sum;
    }

    public void updateWeights(double delta, double[] lastInput) {
        if(weights.length != lastInput.length) {
            System.out.println("MISMATCH! weights=" +weights.length + " lastInput=" + lastInput.length);
            System.out.println("This neuron has " + weights.length + " weights but got input len " + lastInput.length);
            throw new RuntimeException("stop");
        }

        for (int j=0; j<weights.length; j++) {
            weights[j] -= learningRate * delta * lastInput[j];
        }
        bias -= learningRate * delta;
    }
}

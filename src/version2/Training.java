package version2;

public class Training {
    Network network;
    double learningRate;

    public Training(int numLayers, int[] neuronsPerLayer, ActivationType[] layersActivationType, int inputSize, double learningRate) {
        this.learningRate = learningRate;
        this.network = new Network(numLayers, neuronsPerLayer, layersActivationType, inputSize, learningRate);
    }

    public double[] mseLoss(double[] inputs, double[] target) {
        double[] prediction = network.forward(inputs);

        if (prediction.length != target.length) {
            throw new IllegalArgumentException(
                    "Target and prediction length mismatch: target=" + target.length
                    + ", prediction=" + prediction.length);
        }

        double[] loss = new double[prediction.length];
        for (int i = 0; i < prediction.length; i++) {
            double difference = target[i] - prediction[i];
            loss[i] = 0.5 * difference * difference;
        }
        return loss;
    }

    /**
     * MSE derivative: dL/dy = y - t
     * Call this with the already-computed network output, not the original inputs.
     */
    public double[] lossDerivative(double[] prediction, double[] target) {
        if (prediction.length != target.length) {
            throw new IllegalArgumentException(
                    "prediction length (" + prediction.length +
                    ") != target length (" + target.length + ")");
        }
        double[] deriv = new double[prediction.length];
        for (int i = 0; i < deriv.length; i++) {
            deriv[i] = prediction[i] - target[i];
        }
        return deriv;
    }

    public void train(double[][] allInputs, double[][] allTargets, int epochs) {
        for (int epoch = 0; epoch < epochs; epoch++) {
            double totalLoss = 0;
            for (int s = 0; s < allInputs.length; s++) {
                double[] pred = network.forward(allInputs[s]);

                // loss for monitoring
                for(int i = 0; i < pred.length; i++) {
                    double diff = pred[i] - allTargets[s][i];
                    totalLoss += 0.5 * diff * diff;
                }

                double[] lossDeriv = lossDerivative(pred, allTargets[s]);
                network.backward(lossDeriv);
            }
            System.out.println("Epoch " + epoch + " loss: " + totalLoss / allInputs.length);
        }
    }

    public double[] predict(double[] inputs) {
        return network.forward(inputs);
    }
}
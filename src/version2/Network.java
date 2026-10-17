package version2;

public class Network {
    Layer[] layers;

    public Network(int numLayers, int[] neuronsPerLayer, ActivationType[] types, int inputSize, double learningRate) {
        this.layers = new Layer[numLayers];

        layers[0] = new Layer(neuronsPerLayer[0], inputSize, types[0], learningRate);

        for (int i = 1; i < numLayers; i++) {
            layers[i] = new Layer(neuronsPerLayer[i], neuronsPerLayer[i - 1], types[i], learningRate);
        }
    }

    public double[] forward(double[] inputs) {
        double[] currentInput = inputs;
        for (Layer layer : layers) {
            currentInput = layer.forward(currentInput);
        }
        return currentInput;
    }

    public void backward(double[] lossDerivative) {
        double[] errorToPropagate = lossDerivative;
        // go backwards
        for (int i = layers.length - 1; i >= 0; i--) {
            errorToPropagate = layers[i].backward(errorToPropagate);
        }
    }
}

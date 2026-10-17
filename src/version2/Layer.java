package version2;

public class Layer {
    Neuron[] neurons;
    ActivationType activationType;      // enum: RELU, SIGMOID, etc

    double[] lastInput;
    double[] lastWeightedSum;
    double[] lastActivation;

    public Layer(int numNeurons, int numInputsPerNeuron, ActivationType type, double learningRate) {
        this.activationType = type;
        this.neurons = new Neuron[numNeurons];
        for (int i = 0; i < numNeurons; i++) {
            neurons[i] = new Neuron(numInputsPerNeuron, learningRate);
        }
    }

    public double[] forward(double[] inputs) {
        lastInput = inputs.clone();
        lastWeightedSum = new double[neurons.length];

        double[] outputs = new double[neurons.length];
        for (int i = 0; i < neurons.length; i++) {
            lastWeightedSum[i] = neurons[i].weightedSum(inputs);
            outputs[i] = Activation.apply(lastWeightedSum[i], activationType);
        }
        this.lastActivation = outputs.clone();

        return outputs;
    }

    public double[] backward(double[] errorFromNextLayer) {
        double[] delta = new double[neurons.length];
        double[] errorForPrevLayer = new double[lastInput.length];

        // layer delta calc
        // SIGMOID / TANH need the activated value; RELU / LINEAR need the pre-activation
        for (int i = 0; i < neurons.length; i++) {
            double derivArg = (activationType == ActivationType.SIGMOID
                            || activationType == ActivationType.TANH)
                    ? lastActivation[i]
                    : lastWeightedSum[i];
            double deriv = Activation.derivative(derivArg, activationType);
            delta[i] = errorFromNextLayer[i] * deriv;
        }

        // error for prev layer
        for (int i = 0; i < lastInput.length; i++) {
            double sum = 0;
            for (int j = 0; j < neurons.length; j++) {
                sum += neurons[j].weights[i] * delta[j];
            }
            errorForPrevLayer[i] = sum;
        }

        // layer weight updates
        for (int i = 0; i < neurons.length; i++) {
            neurons[i].updateWeights(delta[i], lastInput);
        }
        return errorForPrevLayer;
    }
}
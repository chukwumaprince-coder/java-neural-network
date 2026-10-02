public class bpComp {
    static outputNeuron oN = new outputNeuron(1, 0.1, 0.2);

    // prediction calculation
    private static double predict() {
        return oN.calcActivation();
    }

    // loss calculations
    // loss for monitoring (mean squared error)
    private static double outLoss() {
        double target = receiveTarget();
        double prediction = predict();
        return 0.5 * Math.pow((target - prediction), 2);
    }
    // loss for propagation
    private static double loss() {
        double target = receiveTarget();
        double prediction = predict();
        return (prediction - target);
    }

    // output error calculation
    private static double outputError() {
        double prediction = predict();
        double derivative = prediction * (1 - prediction);  // derivative for sigmoid activation
        double loss = loss();
        return loss * derivative;
    }

    // hidden error calculation
    // first neuron hidden error calculation
    private static double hiddenError1() {
        double activation = outputNeuron.getInput1();
        double derivative = activation * (1 - activation);
        double weight = oN.getWeight5();
        double outputError = outputError();
        return outputError * weight * derivative;
    }
    //second neuron hidden error calculation
    private static double hiddenError2() {
        double activation = outputNeuron.getInput2();
        double derivative = activation *  (1 - activation);
        double weight = oN.getWeight6();
        double outputError = outputError();
        return outputError * weight * derivative;
    }


    static double outputError = outputError();
    static double activation1 = outputNeuron.getInput1();
    static double activation2 = outputNeuron.getInput2();

    static double[] inputs = inputNeuron.passInput();  // avoiding getting input from hidden neurons, fine as they are the same.
    static double input1 = inputs[0];
    static double input2 = inputs[1];
    static double hiddenError1 = hiddenError1();
    static double hiddenError2 = hiddenError2();

    // output layer weight gradient computations
    static double outputWeightGradient1 = outputError * activation1;
    static double outputWeightGradient2 = outputError * activation2;
    static double outputBiasGradient = outputError;

    // hidden layer weight gradient computation
    static double hiddenWeightGradient1 = hiddenError1 * input1;
    static double hiddenWeightGradient2 = hiddenError1 * input2;
    static double hiddenWeightGradient3 = hiddenError2 * input1;
    static double hiddenWeightGradient4 = hiddenError2 * input2;
    static double hiddenBiasGradient1 = hiddenError1;
    static double hiddenBiasGradient2 = hiddenError2;

    // receiving old parameter values
    private static double[] receiveParams() {
        return outputNeuron.getParams();
    }

    // updating the values
    private static void update(double learning_rate, int epochs) {

        for (int i = 0; i <= epochs; i++) {
            displayOutput();

            double oldOutputWeight1 = oN.getWeight5();
            double oldOutputWeight2 = oN.getWeight6();
            double oldOutputBias = oN.getBias();

            double[] oldParams = receiveParams();
            double oldHiddenWeight1 = oldParams[0];
            double oldHiddenWeight2 = oldParams[1];
            double oldHiddenWeight3 = oldParams[2];
            double oldHiddenWeight4 = oldParams[3];
            double oldHiddenBias1 = oldParams[4];
            double oldHiddenBias2 = oldParams[5];

            double newOutputWeight1 = oldOutputWeight1 - (learning_rate * outputWeightGradient1);
            double newOutputWeight2 = oldOutputWeight2 - (learning_rate * outputWeightGradient2);
            double newOutputBias = oldOutputBias - (learning_rate * outputBiasGradient);

            double newHiddenWeight1 = oldHiddenWeight1 - (learning_rate * hiddenWeightGradient1);
            double newHiddenWeight2 = oldHiddenWeight2 - (learning_rate * hiddenWeightGradient2);
            double newHiddenWeight3 = oldHiddenWeight3 - (learning_rate * hiddenWeightGradient3);
            double newHiddenWeight4 = oldHiddenWeight4 - (learning_rate * hiddenWeightGradient4);
            double newHiddenBias1 = oldHiddenBias1 - (learning_rate * hiddenBiasGradient1);
            double newHiddenBias2 = oldHiddenBias2 - (learning_rate * hiddenBiasGradient2);

            oN.setWeight5(newOutputWeight1);
            oN.setWeight6(newOutputWeight2);
            oN.setBias(newOutputBias);
            outputNeuron.passParams(newHiddenWeight1, newHiddenWeight2, newHiddenWeight3,
                    newHiddenWeight4, newHiddenBias1, newHiddenBias2, i, epochs);
        }
    }

    // public train function
    public static void train(double learning_rate, int epochs) {
        double lnr_rate;
        lnr_rate = learning_rate;

        int total_epochs;
        total_epochs = epochs;

        update(lnr_rate, total_epochs);
    }
    // public query function for inference
    public static void query(double input_a, double input_b) {
        double inp1;
        inp1 = input_a;

        double inp2;
        inp2 = input_b;
        System.out.println("\nThe inference is: " + oN.infer(inp1, inp2));
    }
    // query for previous / pretraining result
    public static void untrainedQuery() {
        System.out.println("The untrained prediction is: " + oN.calcActivation());
    }

    // helper functions
    // getting the target
    private static double receiveTarget() {
        double[] arr = inputNeuron.passInput();
        return arr[2];
    }

    // output display
    public static void displayOutput() {
        System.out.print("\n ========== Outputs ==========" + "\nMSE (out)loss: " + outLoss() + "\n");
    }
}

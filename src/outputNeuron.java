public class outputNeuron {
    private double weight5;
    private double weight6;
    private double bias;

    static hiddenNeuron hN1 = new hiddenNeuron(1, 0.5, 0.1);
    static hiddenNeuron hN2 = new hiddenNeuron(0.3, 0.5, 0.2);

    // instantiating neurons to attain layer input values
    public static double[] receiveInput() {
        double activation1 = hN1.getActivation();
        double activation2 = hN2.getActivation();

        return new double[]{activation1, activation2};
    }

    public outputNeuron(double weight5, double weight6, double bias) {
        this.weight5 = weight5;
        this.weight6 = weight6;
        this.bias = bias;
    }

    private double calcWeightedSum() {
        return (weight5 * getInput1()) + (weight6 * getInput2() + bias);
    }
    public double calcActivation() {
        return 1.0 / (1.0 + Math.exp(-calcWeightedSum()));
    }

    // prediction at inference for query
    public double infer(double input1, double input2) {
        double wtdSum = ((weight5 * input1) + (weight6 * input2) + bias);
        return 1.0 / (1.0 + Math.exp(-wtdSum));
    }

    // separating activation inputs for use
    public static double getInput1() {
        double[] arr = receiveInput();
        return arr[0];
    }
    public static double getInput2() {
        double[] arr = receiveInput();
        return arr[1];
    }

    // pass hN values to back propagation computation class
    public static double[] getParams() {
        double hiddenWeight1 = hN1.getWeight1();
        double hiddenWeight2 = hN1.getWeight2();
        double hiddenWeight3 = hN2.getWeight1();
        double hiddenWeight4 = hN2.getWeight2();
        double hiddenBias1 = hN1.getBias();
        double hiddenBias2 = hN2.getBias();

        return new double[]{hiddenWeight1, hiddenWeight2, hiddenWeight3, hiddenWeight4, hiddenBias1, hiddenBias2};
    }

    // passing updated parameters from back propagation computation class to the hidden neurons
    public static void passParams(double newHiddenWeight1, double newHiddenWeight2, double newHiddenWeight3,
                                      double newHiddenWeight4, double newHiddenBias1, double newHiddenBias2,
                                  int i, double epochs) {
        if (i < epochs) {
            hN1.setWeight1(newHiddenWeight1);
            hN1.setWeight2(newHiddenWeight2);
            hN1.setBias(newHiddenBias1);
            hN2.setWeight1(newHiddenWeight3);
            hN2.setWeight2(newHiddenWeight4);
            hN2.setBias(newHiddenBias2);
        }
    }

    // getters
    public double getWeight5() {
        return weight5;
    }
    public double getWeight6() {
        return weight6;
    }
    public double getBias() {
        return bias;
    }

    // setters
    public void setWeight5(double newWeight5) {
        this.weight5 = newWeight5;
    }
    public void setWeight6(double newWeight6) {
        this.weight6 = newWeight6;
    }
    public void setBias(double newBias) {
        this.bias = newBias;
    }
}

import java.util.Arrays;

public class outputNeuron {
    private double weight5;
    private double weight6;
    private double bias;
    //private double inputs;

    // instantiating neurons to attain layer input values
    public static double[] receiveInput() {
        hiddenNeuron hN1 = new hiddenNeuron(1, 0.5, 0.1);
        hiddenNeuron hN2 = new hiddenNeuron(0.3, 0.5, 0.2);
        double activation1 = hN1.getActivation();
        double activation2 = hN2.getActivation();
        //System.out.println("1st activation: " + activation1 + "2nd activation: " + activation2);

        return new double[]{activation1, activation2};
    }

    public outputNeuron(double weight5, double weight6, double bias) {
        this.weight5 = weight5;
        this.weight6 = weight6;
        this.bias = bias;
    }

    public double calcWeightedSum() {
        return (weight5 * getInput1()) + (weight6 * getInput2() + bias);
    }
    public double calcActivation() {
        System.out.println(1.0 / (1.0 + Math.exp(-calcWeightedSum())));
        return 1.0 /(1.0 + Math.exp(-calcWeightedSum()));
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

    // test getInput functions
    public static void testInputReceived() {
        System.out.println(Arrays.toString(receiveInput()));
    }
    public static void testGetInput1() {
        System.out.println(getInput1());
    }
    public static void testGetInput2() {
        System.out.println(getInput2());
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

package version1;

public class hiddenNeuron{
    private double weight1;
    private double weight2;
    private double bias;

    public hiddenNeuron(double weight1, double weight2, double bias) {
        this.weight1 = weight1;
        this.weight2 = weight2;
        this.bias = bias;
    }

    // main functions
    private double calcWeightedSum() {
        return (weight1 * receiveInput1()) + (weight2 * receiveInput2()) + bias;
    }
    private double calcActivation() {
        return 1.0 / (1.0 + Math.exp(-calcWeightedSum()));  //sigmoid activation
    }
    public double getActivation() {
        return calcActivation();
    }

    // helper functions
    private static double receiveInput1() {
        double[] arr = inputNeuron.passInput();
        return arr[0];
    }
    private static double receiveInput2() {
        double[] arr = inputNeuron.passInput();
        return arr[1];
    }

    // getters
    public double getWeight1() {
        return  weight1;
    }
    public double getWeight2() {
        return weight2;
    }
    public double getBias() {return bias;}

    // setters
    public void setWeight1(double newWeight1) {
        this.weight1 = newWeight1;
    }
    public void setWeight2(double newWeight2) {
        this.weight2 = newWeight2;
    }
    public void setBias(double newBias) {
        this.bias = newBias;
    }

    public String toString() {
        return "The activation is: " + calcActivation();
    }
}

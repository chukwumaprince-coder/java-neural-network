public class hiddenNeuron{
    private double input1;
    private double input2;
    private double weight1;
    private double weight2;
    private double bias;

    public hiddenNeuron(double weight1, double weight2,
                        double bias, double input1, double input2) {
        this.weight1 = weight1;
        this.weight2 = weight2;
        this.input1 = input1;
        this.input2 = input2;
        this.bias = bias;
    }

    // helper functions
    public double calcWeightedSum() {
        return (weight1 * input1) + (weight2 * input2) + bias;
    }
    public double calcActivation() {
        return 1.0 / (1.0 + Math.exp(-calcWeightedSum()));  //sigmoid activation
    }

    // getters
    public double getWeight1() {
        return  weight1;
    }
    public double getWeight2() {
        return weight2;
    }
    public double getInput1() {
        return input1;
    }
    public double getInput2() {
        return input2;
    }
    public double getBias() {
        return bias;
    }
    public double getActivation() {
        return calcActivation();
    }

    // setters
    public void setWeight1(double newWeight1) {
        this.weight1 = newWeight1;
    }
    public void setWeight2(double newWeight2) {
        this.weight2 = newWeight2;
    }
    public void setInput1(double newInput1) {
        this.input1 = newInput1;
    }
    public void setInput2(double newInput2) {
        this.input2 = newInput2;
    }
    public void setBias(double newBias) {
        this.bias = newBias;
    }

    public String toString() {
        return "The activation is: " + calcActivation();
    }
}

// public abstract class neuron {
    // private double weight;
    // private double bias;


    // helper functions
    // public abstract double calcInitialOutput();
        //return ((weight * input_a) + (weight * input_b) + bias);

    // public abstract double calcActivation(); //sigmoid
        //return 1.0 / (1.0 + Math.exp(-calcInitialOutput()));


    // getters
    // public abstract double getWeight();
        //return weight;

    // public abstract double getBias();
        //return bias;

    // public abstract double getInput_a();
        //return input_a;

    // public abstract double getInput_b();
        //return input_b;

    // setters
    // public abstract void setWeight(double newWeight);
        //this.weight = newWeight;

    // public abstract void setBias(double newBias);
        //this.bias = newBias;

    // public abstract void setInput_a(double newInput);
        //this.input_a = newInput;

    // public abstract void setInput_b(double newInput);
        //this.input_b = newInput;

    // to string method for printing neuron attributes
    // @Override
    // public String toString() {
        // return "Initial Output: " + calcInitialOutput() + "\nSigmoid Activation Output: " + calcActivation();
    // }
// }


// public static double receiveInput() {
//    hiddenNeuron[] hiddenNeurons = new hiddenNeuron[2];
//    hiddenNeurons[0] = new hiddenNeuron(1, 0.5, 0.1, 2, 2);
//    hiddenNeurons[1] = new hiddenNeuron(0.3, 0.5, 0.2, 1, 3);

//    for (hiddenNeuron h: hiddenNeurons) {
//        double activations = h.getActivation();
//        System.out.println(activations);

//        if (activations > 0) {
//            return activations;
//        }
//    }
//    return 0;
//}
//}

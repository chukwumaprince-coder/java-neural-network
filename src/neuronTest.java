//import java.util.Arrays;

public class neuronTest {
    public static void main(String[] args) {
        //outputNeuron.testInputReceived();
        outputNeuron.testGetInput1();
        outputNeuron.testGetInput2();

        outputNeuron oN = new outputNeuron(1,0.1, 0.2);
        oN.calcActivation();

        //System.out.println(Arrays.toString(inputNeuron.getInput()));
    }
}
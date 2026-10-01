import java.util.Scanner;

public class inputNeuron {
    static Scanner sc = new Scanner(System.in);


    public static double[] getInput() {

        System.out.print("Enter first input: ");
        double input1 = sc.nextDouble();

        System.out.print("Enter second input: ");
        double input2 = sc.nextDouble();
        sc.close();

        // To add target input

        return new double[]{input1, input2};
    }

    static double[] inputs = getInput();
    public static double[] passInput() {
        return inputs;
    }
}

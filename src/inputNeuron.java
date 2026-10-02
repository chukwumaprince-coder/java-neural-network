import java.util.Scanner;

public class inputNeuron {

    private static double[] getInput() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first input: ");
        double input1 = sc.nextDouble();

        System.out.print("Enter second input: ");
        double input2 = sc.nextDouble();

        // Entering the target value
        System.out.print("Enter target value: ");
        double target = sc.nextDouble();
        sc.close();

        return new double[]{input1, input2, target};
    }

    static double[] inputs = getInput();
    public static double[] passInput() {
        return inputs;
    }
}

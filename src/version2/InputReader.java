package version2;

import java.util.Scanner;
import java.util.ArrayList;

public class InputReader {
    Scanner sc = new Scanner(System.in);

    public double[] getInputs() {
        ArrayList<Double> list = new ArrayList<>();

        System.out.println("Enter input doubles (type 'done' to finish)");

        while (true) {
            String token = sc.next();       // read as string always

            if (token.equalsIgnoreCase("done") || token.equalsIgnoreCase("x")) {
                break;
            }

            try {
                double val = Double.parseDouble(token);
                list.add(val);
            } catch (NumberFormatException e) {
                System.out.println("'" + token + "' is not a number or 'done'. Try again");
            }
        }

        // convert ArrayList to array
        double[] arr = new double[list.size()];
        for (int i=0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }

    public double getTarget() {
        System.out.println("Enter target value for training: ");
        return sc.nextDouble();
    }

    public ActivationType getActivationType() {
        System.out.println("Enter activation (relu/sigmoid): ");
        String s = sc.nextLine();       // user types relu
        return ActivationType.fromString(s);
    }

    public double[] getLayersNeuronCount() {
        double[] arr = new double[3];

        for (int i=0; i < arr.length; i++) {
            System.out.println("Enter layer neuron count: " + (i + 1) +
                    " (only hidden and output layer numbers are effective)");
            arr[i] = sc.nextDouble();
        }
        return arr;
    }
}

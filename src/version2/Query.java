package version2;

public class Query {
    public static  void main(String[] args) {
        int inputSize = 2;
        int[] layers = {4, 1};
        ActivationType[] types = {ActivationType.SIGMOID, ActivationType.SIGMOID};

        Training training = new Training(2, layers, types, inputSize, 0.1);

        double[][] X = {{0,0},{0,1},{1,0},{1,1}};
        double[][] Y = {{0},{1},{1},{0}};

        System.out.println("inputSize arg: 2");
        System.out.println("X[0].length: " + X[0].length);
        System.out.println("neuronsPerLayer[0]: 4");

        training.train(X, Y, 5000);

        System.out.println(java.util.Arrays.toString(training.predict(new double[]{0,0})));
    }
}

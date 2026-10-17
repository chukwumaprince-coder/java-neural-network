package version2;

public class Activation {
    public static double apply(double z, ActivationType type) {
        return switch (type) {
            case RELU    -> Math.max(0, z);
            case SIGMOID -> 1.0 / (1.0 + Math.exp(-z));
            case TANH    -> Math.tanh(z);
            case LINEAR  -> z;
        };
    }

    /**
     * @param value  for SIGMOID/TANH this must be the *activated* output;
     *               for RELU/LINEAR this must be the pre-activation z
     */
    public static double derivative(double value, ActivationType type) {
        return switch (type) {
            case SIGMOID -> value * (1.0 - value);
            case TANH    -> 1.0 - value * value;
            case RELU    -> value > 0 ? 1.0 : 0.0;
            case LINEAR  -> 1.0;
        };
    }
}
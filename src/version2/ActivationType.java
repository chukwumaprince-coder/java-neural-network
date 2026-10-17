package version2;

public enum ActivationType {
    RELU, SIGMOID, TANH, LINEAR;

    public static ActivationType fromString(String input) {
        return ActivationType.valueOf(input.trim().toUpperCase());
    }
}
